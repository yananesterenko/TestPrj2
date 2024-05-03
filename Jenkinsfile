pipeline {
    agent any

    parameters {
        choice(name: 'ENVIRONMENT', choices: ['dev', 'qa', 'prod'], description: 'Select environment')
    }



    stages {
        stage('Print Properties') {
                steps {
                    script {
                        // Print out the properties after the build
                        echo "Properties for ${params.ENVIRONMENT} environment:"
                        //sh "cat src/${params.ENVIRONMENT}.properties"
                        bat "cat src/${params.ENVIRONMENT}.properties"
                    }
                }
            }
        stage('Build') {
            steps {
                //sh "./gradlew build -Penv=${params.ENVIRONMENT}"
                bat'./gradlew build -Penv=${params.ENVIRONMENT}'

            }
        }

        stage('Deploy') {
            steps {
                 echo "Deploy...."
            }
        }
    }
}