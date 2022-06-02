import java.util.regex.Pattern

File build_log_file = new File("${basedir}/build.log")
assert build_log_file.exists();
def build_log = build_log_file.text

// With previous-provider
File valid_with_provider = new File("${basedir}/target/baseline/valid-with-provider-1.0.2.txt")
assert valid_with_provider.isFile()
assert build_log =~ Pattern.quote("[INFO] Baseline check succeeded. See the report in ${valid_with_provider}")
