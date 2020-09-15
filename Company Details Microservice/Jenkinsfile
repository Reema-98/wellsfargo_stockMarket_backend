node{
   
   stage('SCM Checkout'){
       git 'https://github.com/Reema-98/Company-Microservices--backend.git'
   }
   
   stage('Mvn Package'){
        sh label: '', script: 'mvn clean package'
       }
       
    stage('Build Docker Image'){
        
     sh 'docker build -t reemasebi/myapp .'
   }
   
   stage('Push Docker Image'){
    withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubpwd')]) {
     sh "docker login -u reemasebi -p ${dockerHubpwd}"
        
    }
     sh 'docker push reemasebi/myapp'
   }
   
   stage('Run Container on Dev Server'){
     sh 'docker run -p 8081:8081 -d --name myapp reemasebi/myapp:latest'
     }
}
