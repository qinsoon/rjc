#!/usr/bin/perl

use Cwd;
use Cwd 'abs_path';
use File::Find;
use File::Basename;

my $rjava_base = dirname(abs_path($0))."/..";
my $build_path = "$rjava_base/build";
my $rjava_lib_path = "$build_path/rjava";
my $generated_c_path = "$rjava_base/output";
my $rjc_jar = "$build_path/rjc.jar";
my $test_source = "$rjava_base/unittest/src";

my $rjc_main = "org.rjava.compiler.RJavaCompiler";

my $mute = "> /dev/null 2>&1";
#my $mute = "2>&1";

print "RJava base dir:$rjava_base\n\n";

print "Generating compiler jar...";
system("ant -file $rjava_base/mybuild.xml $mute") == 0
or die "Failed to build RJava Compiler";
print "done\n";

print "\nStart unit tests\n\n";

my @test_suite;
find(\&add_to_test_suite, $test_source);

my $total_compile = 0;
my $success_compile = 0;
my $total_exec = 0;
my $success_exec = 0;
my $total_test = 0;
my $success_test = 0;

# debug, only run one unittest
my $run_once = 0;

foreach (@test_suite) {
  run_test($_);
  if ($run_once == 1) {
    exit 0;
  }
}

print "===Unit Test Results===\n";
print "Compilation success: $success_compile / $total_compile\n";
print "Execution success  : $success_exec / $total_exec\n";
print "Testcase success   : $success_test / $total_test (not including testcases that cannot execute)\n";
print "===  End of Results ===\n";

sub run_test() {
  print "Run test: $_\n";
  
  chdir($rjava_base);
  
  # RJava to C
  print "  RJava -> C ";
  $total_compile ++;
  system("java -cp $rjc_jar:$rjava_lib_path $rjc_main -dt -dir $test_source -o test $_ $mute");
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
