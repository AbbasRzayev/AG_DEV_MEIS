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
          sh '''
            chmod +x mvnw
            ./mvnw clean test verify -Dheadless=true
          '''
        }
    }

    post {
      always {
        junit 'target/surefire-reports/*.xml'

        // JSON və HTML reportlar
        archiveArtifacts artifacts: 'target/cucumber.json, target/cucumber-html-report/**, target/failed_Scenario.txt', allowEmptyArchive: true

        publishHTML(target: [
          reportDir: 'target/cucumber-html-report',
          reportFiles: 'index.html',
          reportName: 'Cucumber HTML Report',
          keepAll: true,
          alwaysLinkToLastBuild: true,
          allowMissing: true
        ])
      }
    }
}
