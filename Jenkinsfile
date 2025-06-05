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
                script {
                
                    git_checkout.git_checkout("git@github.com:srinath730/tomcat-root-war.git", "master")

                }
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
