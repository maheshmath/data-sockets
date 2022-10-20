pipeline {
    agent any

    tools {
        maven "M3"
    }

    stages {
        stage('Build'){
            steps {

                git 'https://github.com/maheshmath/data-sockets.git'
                script{
                    current_version = readFile 'version.txt'
                    print("current_version: $current_version")
                }
                sh """
                    mvn -Dmaven.test.failure.ignore=true clean package"
                    docker build -t "data-sockets":"$current_version" .
                    docker push data-sockets:$current_version
                    docker rmi data-sockets:$current_version
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