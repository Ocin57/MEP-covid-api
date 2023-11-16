pipeline {
    agent any
    stages {   
        /*
        // Git Clone uniquement si l'on créer un pipeline unique sur Jenkins
        stage('Git Clone') {
            steps {
                echo 'Git Clone'
                sh 'git clone https://github.com/Ocin57/MEP-covid-api.git'
            }
        }*/     
        stage('Docker Build') {
            steps {
                echo 'Docker Build'

                // Build uniquement l'image du backend 
                //sh 'docker build -t nicokgr/mep-backend:latest .'

                // Build de toutes les images du docker-compose
                sh 'docker compose up -d'
            }
        }
        stage('Docker Push') {
            steps {
                echo 'Docker push'
                withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"

                    // Push uniquement l'image du backend
                    //sh 'docker push nicokgr/mep-backend:latest'

                    // Push de toutes les images du docker-compose
                    sh 'docker compose push'
                }
            }
        }
    }
}
