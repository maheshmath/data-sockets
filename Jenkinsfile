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
                    docker build -t "$DOCKER_HUB/data-sockets:$current_version" . 
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