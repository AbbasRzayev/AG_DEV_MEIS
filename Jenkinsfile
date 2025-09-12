pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Jenkins repodan kodu çəkəcək
                git 'https://github.com/AbbasRzayev/MEIS.git'
            }
        }

        stage('Build') {
            steps {
                // Maven ilə build/test
                sh './mvnw clean test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}