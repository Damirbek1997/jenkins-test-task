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
                git branch: 'main', url: 'https://github.com/Damirbek1997/test-task1'
                sh "mvn clean install"
            }
        }
        stage('Run SonarQube') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean package sonar:sonar'
                }
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [
                                    [
                                        containerId: 'tomcat',
                                        contextPath: '',
                                        war: '**/*.war'
                                    ]
                                ]
            }
        }
    }
}

