node {
  stage('Clone the Git') {
    git 'https://github.com/ValeriaGallegoR/RESTAPI_reto.git'
  }
  stage('SonarQube analysis') {
    def scannerHome = tool 'sonarqube';
    withSonarQubeEnv('sonarqube') {
      sh "${scannerHome}/bin/sonar-scanner \
      -D sonar.login=david \
      -D sonar.password=admin123 \
      -D sonar.projectKey=pilelinedavid \
      -D sonar.exclusions=vendor/**,resources/**,**/*.java \
      -D sonar.host.url=http://ec2-3-142-222-224.us-east-2.compute.amazonaws.com:9000/projects"
    }
  }
}