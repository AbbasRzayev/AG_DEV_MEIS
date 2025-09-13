pipeline {
  agent any
  options { timestamps(); disableConcurrentBuilds() }

  environment {
    SELENIUM_REMOTE_URL = 'http://selenium:4444/wd/hub'
    HEADLESS = 'true'
  }

  stages {
    stage('Checkout') { steps { checkout scm } }

    stage('Build & Test') {
      steps {
        sh 'chmod +x mvnw || true'
        sh """
          ./mvnw -B -U clean test \
            -DSELENIUM_REMOTE_URL=${SELENIUM_REMOTE_URL} \
            -Dheadless=${HEADLESS}
        """
      }
      post {
        always {
          junit testResults: 'target/surefire-reports/*.xml,target/failsafe-reports/*.xml', allowEmptyResults: true
          archiveArtifacts artifacts: 'target/**/cucumber*.json,target/**/cucumber-html-report/**,**/screenshots/**/*.*', allowEmptyArchive: true, fingerprint: true
          // Cucumber HTML reportunu brauzerdə görmək üçün (əgər yaradırsa):
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
}
