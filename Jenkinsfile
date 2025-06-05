@Library('my_library') _
pipeline {
        agent { label 'master' }
    tools { 
        maven 'Maven'
    }
    stages {

        stage('hello world') {
            steps {
                script {
                
                    hello_World('srinath')
                }
            
            }
        }
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
        stage(' Tomcat Deployment ') {
                agent { label "${params.AGENT_LABEL}" }
            steps {
                echo 'Tocat Deployment to'
                sh 'scp -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null target/ROOT.war ubuntu@"${params.IP_Address}":/opt/tomcat/webapps'
            }
        }
    }
}
