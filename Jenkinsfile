pipeline {
    agent any

//     parameters {
//         choice(name: 'ENVIRONMENT', choices: ['dev', 'qa', 'prod'], description: 'Select environment')
//         gitParameter(branch: '',
//         branchFilter: 'origin/{.*}'),
//         defaultValue: 'dev',
//         description: '',
//         name: 'BRANCH',
//         quickFilterEnabled: true,
//         selectedValue: 'TOP',
//         sortMode: 'DESCENDING',
//         tagFilter: '*',
//         type: ''
//     }

    parameters {
        choice(name: 'ENVIRONMENT', choices: ['dev', 'qa', 'prod'], description: 'Select environment')
        gitParameter(branchFilter: 'origin/(.*)', defaultValue: 'master', description: 'Select a branch', name: 'BRANCH')
    }


    stages {
        stage('Checkout') {
            steps {
                script {
                    def branchName = params.BRANCH ?: 'master'
                    checkout([$class: 'GitSCM',
                        branches: [[name: "*/${branchName}"]],
                        userRemoteConfigs: [[url: env.GIT_URL]]])
                    }
                }
            }
        stage('Print Properties') {
                steps {
                    script {
                        // Print out the properties after the build
                        echo "Properties for ${params.ENVIRONMENT} environment:"
                        //sh "cat src/${params.ENVIRONMENT}.properties"
                        bat "type ${params.ENVIRONMENT}.properties"
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