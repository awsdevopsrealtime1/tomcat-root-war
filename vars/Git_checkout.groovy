def git_checkout(String repo_url, String branch) {
	echo "Cloning repo from ${repo_url}"
		checkout([
			$class: '$GITSCM', branches: [[name: branch]], userRemoteConfigs: [[ url: repo_url ]]
		])
}