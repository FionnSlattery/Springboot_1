pipeline {
  agent any
  options { skipDefaultCheckout(true) }

  stages {
    stage('Checkout') {
      steps {
        git branch: 'main', url: 'https://github.com/Chadlikouider/springboot_1.git'
      }
    }

    stage('Build & Package') {
      agent {
        docker {
          image 'maven:3.9-eclipse-temurin-17'
          args '-v $HOME/.m2:/root/.m2'
          reuseNode true
        }
      }
      steps {
        sh 'which java; java -version; mvn -v'
        sh 'mvn -B clean package'
      }
      post {
        always { junit 'target/surefire-reports/*.xml' }
      }
    }

    stage('Archive') {
      steps { archiveArtifacts artifacts: 'target/*.war', allowEmptyArchive: false }
    }

    stage('Deploy') {
      when { branch 'main' }
      agent any
      steps {
        sh 'docker version'
        sh 'docker build -f Dockerfile -t myapp .'
        sh 'docker rm -f myappcontainer || true'
        sh 'docker run --name myappcontainer -p 8081:8080 -d myapp:latest'
      }
    }
  }
}

