pipeline {
    agent any
    
    tools {
        maven "3.6.3"
        git "git"
    }

    triggers {
        cron('H/15 * * * *')
    }
    
    stages {
        stage("Build") {
            steps {
                git branch: 'main', url: 'https://github.com/Damirbek1997/jenkins-test-task'
                sh "mvn clean install"
            }
        }
        stage('Run SonarQube') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean package sonar:sonar -Dsonar.config.path=sonar-project.properties'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    deploy adapters: [tomcat9(credentialsId: 'admin', path: '', url: 'http://localhost:8081')], contextPath: null, war: '**/*.war'
                }
            }
        }
    }
}

