
import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.GradleException
class GitBsed {
    static String getGitShortCommitHash() {
        return getCommandOutput('git rev-parse --short HEAD').substring(0,7)
    }

    static String getGitCommitHash() {
        return getCommandOutput('git rev-parse HEAD')
    }

    static getGitCommitCount() {
        
		println "hello"
    }
	
	
	static getGitBranch() throws GradleException {
        String gitBranch = getCommandOutput('git rev-parse --abbrev-ref HEAD').replace("/", "-")

        if (gitBranch == null || gitBranch.empty) {
            throw new GradleException('Could not determine Git branch name')
        }

        println gitBranch
    }
	
	
	 private static String getCommandOutput(String command) {
        if (Os.isFamily(Os.FAMILY_WINDOWS)) {
            command = 'cmd /c ' + command
        }
        return command.execute().in.text.trim()
    }
}