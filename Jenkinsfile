pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven_3.9.9'
    }

    environment {
        DOCKER_IMAGE = 'alison0309/my-java-app:latest'  // Fixed the Docker image name
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'branch2', url: 'https://github.com/Alison0309/simple-java-maven-app.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Deliver') {
            steps {
                bat 'jenkins\\scripts\\deliver.bat'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    bat "docker build -t ${DOCKER_IMAGE} ."  // Fixed string interpolation for Docker image
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    bat '''
                        docker stop java-staging-2 || exit 0
                        docker rm java-staging-2 || exit 0
                        docker run -d --name java-staging-2 -p 8082:8082 ${DOCKER_IMAGE}  // Fixed string interpolation
                    '''
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace'
            deleteDir()
        }
        success {
            echo 'Build succeeded!!!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
