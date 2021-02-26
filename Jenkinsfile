pipeline {
  agent any
  triggers {
    pollSCM '* * * * *'   // it means pull git every minute
  }
  stages {
    stage('Build') {
      steps {
        sh 'gradle assemble'
      }
    }
    stage('Test') {
          steps {
            sh 'gradle test'
          }
        }
  }
}
