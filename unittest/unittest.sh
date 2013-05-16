#!/usr/bin/perl

use Cwd;
use File::Find;

my $rjava_base = getcwd."/..";
my $build_path = "$rjava_base/build";
my $generated_c_path = "$build_path/output";
my $rjc_jar = "$build_path/rjc.jar";
my $test_base = "src";

my $rjc = "org.rjava.compiler.RJavaCompiler";

#my $mute = "> /dev/null 2>&1";
my $mute = "";

if ($ARGV[0] ne "-skip-compile") {
print "generating compiler jar...";
system("ant -file ../mybuild.xml $mute") == 0
or die "Failed to build RJava Compiler";
print "done\n";
}

print "\nstart unit testing\n\n";

my $unit_test_base = "$rjava_base/unittest/src";
my @unit_tests;
find(\&add_to_unit_test, $unit_test_base);

my $success_compile = 0;
my $total_compile = 0;
my $success_exec = 0;
my $fail_exec = 0;

foreach (@unit_tests) {
	chdir($build_path);
	run_test($_);
}

my $total_exec = $success_exec + $fail_exec;
print "\n===compilation $success_compile / $total_compile, execution $success_exec / $total_exec ===\n";

sub run_test() {
	print "Compilation for $_\n";
	
	# compile RJava to C
	print " -> C ";
	$total_compile ++;
	if (system("java -cp $rjc_jar:. $rjc -dir $unit_test_base -o test $_[0] $mute") != 0) {
		print "(fail)\n";
		return;
	} else {
		print "(pass)\n";
	}
	
	# compile C
	chdir($generated_c_path);
	print " -> binary ";
	if (system("make $mute") != 0) {
		$failed_compile ++;
		print "(fail)\n";
		return;
	} else {
		print "(pass)\n";
	}
	
	$success_compile ++;
	
	@out = `./test`;
	my $local_fail = 0;
	my $local_succ = 0;
	foreach (@out) {
		print "$_\n";
		($test_name, $result) = ($_ =~ m/(.*):(.*)/);
		if ($result eq "success") {
			$success_exec ++;
			$local_succ ++;
		} else {
			print "*$test_name:$result\n";
			$fail_exec ++;
			$local_fail ++;
		}
	}
	
	my $local_total = $local_succ + $local_fail;
	print "---success $local_succ / $local_total ---\n";
}

sub add_to_unit_test() {
	my $unit_test = $File::Find::name if(/\.java$/i);
	if ($unit_test =~ m#org/rjava/unittest/UnitTest.java#) {
		return;
	} else {
		push @unit_tests, $File::Find::name if(/\.java$/i);
	}
}
