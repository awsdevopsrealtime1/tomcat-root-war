pipeline {
        agent { label 'master' }
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
        stage(' Tomcat Deployment to Dev env ') {
                agent { label '$AGENT_LABLE' }
            steps {
                echo 'Tocat Deployment'
                sh 'scp -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null target/ROOT.war ubuntu@$IP_Address:/opt/tomcat/webapps'
            }
        }
        stage(' Tomcat Deployment to QA env ') {
                agent { label '$AGENT_LABLE' }
            steps {
                echo 'Tocat Deployment'
                sh 'scp -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null target/ROOT.war ubuntu@$IP_Address:/opt/tomcat/webapps'
            }
        }
    }
}
