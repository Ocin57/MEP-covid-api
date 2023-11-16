pipeline {
    agent any

    stages {

        /*
        stage('Git Clone') {
            steps {
                echo 'Preparing..'
                sh 'git clone https://github.com/Ocin57/MEP-covid-api.git'
            }
        }

        stage('Compose Build') {
            steps {
                echo 'Building..'
                
                //sh 'docker compose up -d'
                
            }
        }*/
        
        stage('Docker Build') {
            steps {
                sh 'docker build -t nicokgr/mep-backend:latest .'
            }
        }
        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    sh 'docker push nicokgr/mep-backend:latest'
                }
            }
        }
    }
}
