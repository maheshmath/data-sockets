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
                    imagename = "$DOCKER_HUB/data-sockets:$current_version"
                    print("current_version: $current_version")
                    print("tag name: $imagename")
                }
                sh """
                    mvn -Dmaven.test.failure.ignore=true clean package
                    echo $imagename
                    docker build -t "$DOCKER_HUB/data-sockets:$current_version" -t "$DOCKER_HUB/data-sockets:latest" . 
                    docker push $imagename
                    docker push "$DOCKER_HUB/data-sockets:latest"
                    docker rmi $imagename "$DOCKER_HUB/data-sockets:latest"

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