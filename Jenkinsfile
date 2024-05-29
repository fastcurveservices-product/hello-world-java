#!groovy
pipeline {
  agent none
  stages {
    stage('Maven Install') {
      agent {
        docker {
          image 'maven:3.9.6'
        }
      }
      steps {
        sh 'mvn sonar:sonar -Dsonar.token=squ_78b56e97db2eaa0d9ec39a67e7765a50032bb8d8 -Dsonar.host.url=http://host.docker.internal/sonarqube'
        sh 'mvn clean install -e -DskipTests'
        archiveArtifacts "target/hello-world.jar"
      }
    }

    stage('Docker Build') {
      agent any
      steps {
        sh 'docker build -t localhost:5000/hello-world .'
      }
    }
    stage('Docker Push') {
      agent any
      steps {
        withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
          // sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh "docker login http://localhost:5000/v2/ -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
          sh 'docker push localhost:5000/hello-world:latest'
        }
      }
    }
  }
  post {
    always {
      // Clean up workspace
      // cleanWs()
    }
    success {
      // Notify on success
      echo "Build successful!"
    }
    unstable {
      // Notify on unstable build
      echo "Build unstable."
    }

    failure {
      // Notify on failure
      echo "Build failed!"
    }
  }
}