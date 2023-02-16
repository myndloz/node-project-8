def gv

pipeline {
	agent any
	tools {												
		nodejs "nodejs"
	}
	
	stages {
		stage("init") {
			steps{
				script {
					gv = load "script.groovy"
				}
			}
		}

		stage("increment version") {
			steps {
				script {
					gv.buildApp()
                }
			}
		}

		stage("Run tests") {
			steps {
				script {
					dir("app") {
						gv.testApp()
					}
				}
			}
		}

		stage("Build & Push Docker Image") {
			steps {
				script {
					gv.buildImage()
				}			
			}
		}

		stage("Commit version update") {
			steps {
				script {
					echo "Commit version update to Git repo"
					// withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'smyndloh-GitHub',
					// usernameVariable: 'USER', passwordVariable: 'PWD']]) {
					// 	sh 'git config --global user.email "greatzlab@gmail.com"'
                    //     sh 'git config --global user.name "smyndlo"'
                    //     sh "git remote set-url origin git@github.com:theMartianLabs/node-project-8.git"
					// 	sh 'git checkout jenkins-jobs'
                    //     sh 'git add .'
                    //     sh 'git commit -m "ci: version bump"'
                    //     sh 'git push origin jenkins-jobs'
					// }

				}			
			}		
		}

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