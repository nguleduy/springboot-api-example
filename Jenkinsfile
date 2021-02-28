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
    stage('Build Docker Image') {
      steps {
        sh 'chmod +x gradlew'
        sh './gradlew docker'
      }
    }
    stage('Push Docker Image') {
      environment {
        DOCKER_HUB_LOGIN = credentials('docker-hub')
      }
      steps {
        sh 'chmod +x gradlew'
        sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
        sh './gradlew dockerPush'
      }
    }
  }
}
