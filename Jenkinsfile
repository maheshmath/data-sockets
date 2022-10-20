pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Build'){
            steps {

                git 'https://github.com/maheshmath/data-sockets.git'

                sh """
                export PATH=$PATH:/usr/local/bin
                mvn -Dmaven.test.failure.ignore=true clean package"
                docker build -t temp:0.1 .
                """

            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}