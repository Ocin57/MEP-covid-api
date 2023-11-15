pipeline {
    agent any

    stages {

        stage('build') {
            steps {
                echo 'Building..'

                //checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/Ocin57/MEP-covid-api.git']]])
                //git clone 'https://github.com/Ocin57/MEP-covid-api.git'
                
                sh 'docker compose up -d'                
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
