#!/usr/bin/perl

use Config;
use Cwd;
use Cwd 'abs_path';
use File::Find;
use File::Basename;

my $rjava_base = dirname(abs_path($0))."/..";
my $rjc_script = "$rjava_base/rjc";
my $build_path = "$rjava_base/build";
my $rjava_lib_path = "$build_path/rjava";
my $generated_c_path = "$rjava_base/output";
my $rjc_jar = "$build_path/rjc.jar";
my $test_source = "$rjava_base/unittest/src";

my $rjc_main = "org.rjava.compiler.RJavaCompiler";
my $rjc_flags = "";

my $mute = "> /dev/null 2>&1";
#my $mute = "2>&1";

my $os = "$Config{osname}";
if ($os eq "linux") {
  $rjc_flags = $rjc_flags."-host_os linux ";
}

if ($ARGV[0] eq "m32") {
  $rjc_flags = $rjc_flags."-m32 ";
}

print "OS: $os\n\n";

print "RJava base dir:$rjava_base\n\n";

print "Generating compiler jar...";
system("ant -file $rjava_base/mybuild.xml $mute") == 0
or die "Failed to build RJava Compiler";
print "done\n";

my @test_suite;
find(\&add_to_test_suite, $test_source);

my $total_compile = 0;
my $success_compile = 0;
my $total_exec = 0;
my $success_exec = 0;
my $total_test = 0;
my $success_test = 0;

#print "\nStart unit tests (No Opt flag)\n\n";
#run_test_suite("false");

print "\nStart unit tests (with Opt flag)\n\n";
run_test_suite("true");

sub run_test_suite() {
  $total_compile = 0;
  $success_compile = 0;
  $total_exec = 0;
  $success_exec = 0;
  $total_test = 0;
  $success_test = 0;

  # debug, only run one unittest
  my $run_once = 0;

  foreach $test (@test_suite) {
    run_test($test, $_[0]);
    if ($run_once == 1) {
      exit 0;
    }
  }

  print "===Unit Test Results===\n";
  print "Compilation success: $success_compile / $total_compile\n";
  print "Execution success  : $success_exec / $total_exec\n";
  print "Testcase success   : $success_test / $total_test (not including testcases that cannot execute)\n";
  print "===  End of Results ===\n";
}

sub run_test() {
  print "Run test: $_[0]\n";
  
  chdir($rjava_base);
  
  # RJava to C
  $total_compile ++;
  my $opt_flag;
  if ($_[0] eq "false") {
    $opt_flag = "-dt";
  } else {
  	$opt_flag = "";
  }
  my $exec_cmd = "$rjc_script $opt_flag $rjc_flags -dir $test_source -o test $_[0] $mute";
  print "$exec_cmd\n";
  system($exec_cmd);
  
  print "  RJava -> C ";
  if ( $? != 0) {
    print "(fail)\n";
    return;
  } else {
    print "(pass)\n";
  }
  
  # C to binary
  print "  C -> binary ";
  chdir($generated_c_path);
  system("make $mute");
  if ($? != 0) {
    print "(fail)\n";
    return;
  } else {
    print "(pass)\n";
  }
  
  # compilation succeeds
  $success_compile ++;
  
  # record the output
  print "  Exec ";
  chdir($generated_c_path);
  my @out = `./test`;
  $total_exec ++;
  if ( $? != 0 ) {
    print "(fail)\n";
	return;
  } else {
    print "(pass)\n";
  }
  $success_exec ++;
  
  my $local_fail = 0;
  my $local_succ = 0;
  foreach (@out) {
	($test_name, $result) = ($_ =~ m/(.*):(.*)/);
	if ($result eq "success") {
	  $local_succ ++;
	} else {
	  print "*$test_name:$result\n";
	  $local_fail ++;
	}
  }
  
  my $local_total = $local_fail + $local_succ;
  $success_test = $success_test + $local_succ;
  $total_test = $total_test + $local_total;
  
  print "---success $local_succ / $local_total ---\n";
  print "\n";
}

sub add_to_test_suite() {
  my $unit_test = $File::Find::name if(/\.java$/i);
  if ($unit_test =~ m#org/rjava/unittest/UnitTest.java#) {
    return;
  } else {
    push @test_suite, $File::Find::name if(/\.java$/i);
  }
}
