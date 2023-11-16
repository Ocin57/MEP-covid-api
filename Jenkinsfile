pipeline {
    agent any

    stages {

        /*
        stage('Preparation') {
            steps {
                echo 'Preparing..'
                sh 'git clone https://github.com/Ocin57/MEP-covid-api.git'
            }
        }*/

        stage('build') {
            steps {
                echo 'Building..'
                
                sh 'docker compose up -d'

                
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                test = sh 'curl http://localhost:8081/api/center/'
                echo test
            }
        }

        /*
        stage('Docker Build') {
            steps {
                sh 'docker build -t backend .'
            }
        }
        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    sh 'docker push shanem/spring-petclinic:latest'
                }
            }
        }
        */
    }
}
