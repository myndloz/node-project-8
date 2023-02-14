
pipeline {
	agent any
	tools {												
		nodejs "nodejs"
	}
	stages {
		stage("increment version") {
			steps {
				script {
					echo "Building application..."
					dir("app") {
                        npm version minor

                        def packageJson = readJSON file: 'package.json'
                        def version = packageJson.version

                        // # set the new version as part of IMAGE_NAME
                        env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                    }
				}
			}
		}

		// stage("Run tests") {
		//     steps {
		//         script {
		//             dir("app") {
		//                 sh "npm install"
		//                 sh "npm run test"
		//             }
		//         }
		//     }

		// }

	// 	stage("Build & Push Docker Image") {
	// 		steps {
	// 			script {
	// 				echo "Building image..."
	// 				withCredentials([usernamePassword(credentialsID: 'smyndloh-DockerHub', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
	// 					sh "docker build -t smyndloh/containerz:${IMAGE_NAME} ."
	// 					sh "echo ${PWD} | docker login -u ${USER} --password-stdin"
	// 					sh "docker push smyndloh/containerz:${IMAGE_NAME}"
	// 				}
	// 			}
			
	// 		}
	// 	}

	// 	stage("Commit version update") {
	// 		steps {
	// 			script {
	// 				echo "Commit version update to Git repo"
	// 				withCredentials([usernamePassword(credentialsID: 'smyndloh-GitHub', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
	// 					sh 'git config --global user.email "greatzlab@gmail.com"'
    //                     sh 'git config --global user.name "smyndlo"'

    //                     sh "git remote set-url origin git@github.com:theMartianLabs/node-project-8.git"
    //                     sh 'git add .'
    //                     sh 'git commit -m "ci: version bump"'
    //                     sh 'git push origin main'
	// 				}

	// 			}			
	// 		}		
	// 	}

	}			
}






//	------------------------------------------------------------------

// def gv
// pipeline {
// 	agent any
// 	tools {												
// 		nodejs "node"
// 	}
// 	stages {
// 		stage("init"){
// 			steps{
// 				script{
// 					gv = load "script.groovy"
// 				}
// 			}
// 		}

// 		stage("build"){
// 			steps{
// 				script {
// 					gv.buildApp()
// 				}
// 			}
// 		}

// 		stage("test"){
// 			steps {
// 				script {
// 					gv.testApp()
// 				}
// 			}
// 		}

// 		stage("deploy"){
// 			steps {
// 				script {
// 					gv.deployApp()
// 				}
// 			}
// 		}
// 	}
// 	// post {
// 	// 	always {}

// 	// }
// }