pipeline {
    agent any

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
                sh 'chmod +x mvnw || true'
                sh './mvnw clean test -Dheadless=true'
            }
        }
    }

    post {
        always {
            junit testResults: 'target/surefire-reports/*.xml,target/failsafe-reports/*.xml', allowEmptyResults: true
            archiveArtifacts artifacts: 'target/**/cucumber*.json,target/**/cucumber-html-report/**,**/screenshots/**/*.*', allowEmptyArchive: true, fingerprint: true
            publishHTML(target: [
              reportDir: 'target/cucumber-html-report',
              reportFiles: 'index.html',
              reportName: 'Cucumber HTML',
              keepAll: true,
              alwaysLinkToLastBuild: true
            ])
        }
    }
}
