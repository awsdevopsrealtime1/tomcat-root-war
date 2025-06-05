def call(String repo_url, String branch) {
    echo "Cloning repo from ${repo_url}"
    
    checkout([$class: 'GitSCM',
              branches: [[name: "*/${branch}"]],
              doGenerateSubmoduleConfigurations: false,
              extensions: [],
              submoduleCfg: [],
              userRemoteConfigs: [[url: repo_url]]])
}
