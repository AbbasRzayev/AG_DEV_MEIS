pipeline {
  agent any
  options { timestamps(); ansiColor('xterm'); disableConcurrentBuilds() }

  stages {
    stage('Checkout') {
      steps {
        // bu job-un açıldığı repodan kodu çəkir
        checkout scm
        sh 'git rev-parse --short HEAD'
      }
    }

    stage('Build & Test') {
      steps {
        // mvnw-yə icazə ver
        sh 'chmod +x mvnw || true'
        // Maven Wrapper ilə build+test
        sh './mvnw -B -U clean test'
      }
      post {
        always {
          // TestNG/JUnit reportları (sənin layihənə görə yolu saxlayıram)
          junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml,target/failsafe-reports/*.xml'
        }
      }
    }
  }

  post {
    success { echo '✔ Build PASSED' }
    failure { echo '❌ Build FAILED' }
    always  { echo "Done: ${currentBuild.currentResult}" }
  }
}