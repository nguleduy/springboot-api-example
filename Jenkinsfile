pipeline {
  agent any
  triggers {
    pollSCM '* * * * *'   // it means pull git every minute
  }
  stages {
    stage('Build') {
      steps {
        sh './gradlew assemble'
      }
    }
    stage('Test') {
          steps {
            sh './gradlew test'
          }
        }
  }
}
