pipeline {
    agent any
    stages {   
        /*
        stage('Git Clone') {
            steps {
                echo 'Git Clone'
                sh 'git clone https://github.com/Ocin57/MEP-covid-api.git'
            }
        }*/     
        stage('Docker Build') {
            steps {
                echo 'Docker Build'
                //sh 'docker build -t nicokgr/mep-backend:latest .'
                sh 'docker compose up -d'
            }
        }
        stage('Docker Push') {
            steps {
                echo 'Docker push'
                withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    //sh 'docker push nicokgr/mep-backend:latest'
                    sh 'docker compose push'
                }
            }
        }
    }
}
