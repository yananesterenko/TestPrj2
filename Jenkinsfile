pipeline {
    agent any

    parameters {
        choice(name: 'ENVIRONMENT', choices: ['dev', 'qa', 'prod'], description: 'Select environment')
    }

    stage('Print Properties') {
            steps {
                script {
                    // Print out the properties after the build
                    echo "Properties for ${params.ENVIRONMENT} environment:"
                    sh "cat src/${params.ENVIRONMENT}.properties"
                }
            }
        }

    stages {
        stage('Build') {
            steps {
                sh "./gradlew build -Penv=${params.ENVIRONMENT}"
            }
        }

        stage('Deploy') {
            steps {
                // Add deployment steps here
            }
        }
    }
}