pipeline {
  agent any
  triggers {
    pollSCM '* * * * *'   // it means pull git every minute
  }
  stages {
    stage('Build') {
      steps {
        sh 'chmod +x gradlew'
        sh './gradlew assemble'
      }
    }
    stage('Test') {
      steps {
        sh 'chmod +x gradlew'
        sh './gradlew test'
      }
    }
  }
}
