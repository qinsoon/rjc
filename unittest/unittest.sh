#!/usr/bin/perl

use Cwd;

my $rjava_base = getcwd."/..";
my $build_path = "$rjava_base/build";
my $generated_c_path = "$build_path/output";
my $rjc_jar = "$build_path/rjc.jar";
my $test_base = "src";

my $rjc = "org.rjava.compiler.RJavaCompiler";

my $mute = "> /dev/null 2>&1";
#my $mute = "";

print "generating compiler jar..."
system("ant -file ../mybuild.xml $mute") == 0
or die "Failed to build RJava Compiler";
print "done\n"

print "\nstart unit testing\n\n";

my $unit_test_base = "../unittest/src";
my @unit_tests = (
	"$unit_test_base/org/rjava/unittest/magic/TestAddress.java",
	"$unit_test_base/org/rjava/unittest/magic/TestAddressArray.java"
);

my $failed_compile = 0;
my $failed_exec = 0;

foreach (@unit_tests) {
	chdir($build_path);
	run_test($_);
}

print "\n===compilation fail x$failed_compile, execution fail x$failed_exec===\n";

sub run_test() {
	print "Compilation for $_\n";
	
	# compile RJava to C
	print " -> C ";
	if (system("java -cp $rjc_jar:. $rjc -dir $unit_test_base -o test $_[0] $mute") != 0) {
		$failed_compile ++;
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
	
	@out = `./test`;
	my $local_fail = 0;
	my $local_succ = 0;
	foreach (@out) {
		($test_name, $result) = ($_ =~ m/(.*):(.*)/);
		if ($result eq "success") {
			$local_succ ++;
		} else {
			print "*$test_name:$result\n";
			$failed_exec ++;
			$local_fail ++;
		}
	}
	
	print "---success x$local_succ, fail x$local_fail---\n";
}