pipeline {
    agent any
    tools { 
        maven 'Maven'
    }
    stages {
        stage('git checkout') {
            steps {
                echo 'fetching git code'
                git poll: false, url: 'git@github.com:srinath730/tomcat-root-war.git'
            }
        }
        stage(' Maven Build') {
            steps {
                echo 'Maven Build'
                sh 'mvn clean install'
            }
        }
        stage(' Tomcat Deploy ') {
            steps {
                echo 'Tocat Deployment'
                sh 'scp target/ROOT.war ubuntu@13.232.186.162:/opt/tomcat/webapps'
            }
        }
    }
}
