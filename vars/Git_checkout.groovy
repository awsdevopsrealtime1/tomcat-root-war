def call(String repo_url, String branch) {
	echo "Cloning repo from ${repo_url}"
		checkout scm: [$class: 'GitSCM',
          branches: [[name: branch]],
          userRemoteConfigs: [[url: repo_url]]]
	  
}