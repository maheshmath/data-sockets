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
                    mvn -Dmaven.test.failure.ignore=true clean package
                    imagename = "$DOCKER_HUB/data-sockets:$current_version"
                    echo $imagename
                    docker build -t $imagename .
                    docker push $imagename
                    docker rmi $imagename 
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