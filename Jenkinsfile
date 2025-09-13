pipeline {
  agent any

  options {
    timestamps()
    disableConcurrentBuilds()
  }

  environment {
    MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
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
          chmod +x mvnw || true
          ./mvnw -B clean test verify -Dheadless=true
        '''
      }
    }
  }

  post {
    always {
      // JUnit nəticələri
      junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'

      // Cucumber artefaktları (JSON/HTML/rerun)
      archiveArtifacts allowEmptyArchive: true, artifacts: 'target/cucumber.json, target/cucumber-html-report/**, target/failed_Scenario.txt'

      // HTML reportu göstər (HTML Publisher plugin tələb edir)
      script {
        try {
          publishHTML(target: [
            reportDir: 'target/cucumber-html-report',
            reportFiles: 'index.html',
            reportName: 'Cucumber HTML Report',
            keepAll: true,
            alwaysLinkToLastBuild: true,
            allowMissing: true
          ])
        } catch (e) {
          echo "HTML Publisher plugin quraşdırılmayıb və ya report qovluğu yoxdur: ${e}"
        }
      }
    }
  }
}
