pipeline {
    agent any
		parameters {
            choice(name: 'ENVIRONMENT', choices: ['dev', 'qa', 'prod'], description: 'Select environment')
            gitParameter(
                //branchFilter: 'origin/(.*)',
                branchFilter: 'origin/(.*)',
                defaultValue: 'master',
                description: 'Select a branch',
                name: 'BRANCH',
                selectedValue: 'TOP',
                sortMode: 'DESCENDING'
                )
            }

			stages {
			stage('Checkout') {
				steps {
					script {
						def branchName = params.BRANCH ?: 'master'
						echo "Checkout from branch: ${params.BRANCH}"
						checkout([$class: 'GitSCM',
							//branches: [[name: "*/${branchName}"]],
							branches: [[name: "${branchName}"]],
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
					echo "Deploying branch ${params.BRANCH} to ${params.ENVIRONMENT} environment"

				}
			}
        }
}
