pipeline {
  agent any
  options { timestamps(); disableConcurrentBuilds() }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Build & Test') {
      steps {
        sh 'chmod +x mvnw || true'
        sh './mvnw -B -U clean test'
      }
      post {
        always {
          junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml,target/failsafe-reports/*.xml'
        }
      }
    }
  }
}
