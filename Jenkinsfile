pipeline {
    agent any
    stages {        
        stage('Docker Build') {
            steps {
                echo 'Docker Build'
                sh 'docker build -t nicokgr/mep-backend:latest .'
            }
        }
        stage('Docker Push') {
            steps {
                echo 'Docker push'
                withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    sh 'docker push nicokgr/mep-backend:latest'
                }
            }
        }
    }
}
