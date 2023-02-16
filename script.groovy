def buildApp() {
    echo "Building application..."
        dir("app") {
            sh "npm version minor"

            def packageJson = readJSON file: 'package.json'
            sh "echo $packageJson.version"
            def version = packageJson.version

            //set the new version as part of IMAGE_NAME
            env.IMAGE_NAME = "$version-$BUILD_NUMBER"
        }
}

def testApp() {
    echo "testing the app..."
    sh "npm install"
    sh "npm run test"
}

def buildImage() {
    echo "Building image..."
    // env.VERSION = "1.5.1"
    // env.IMAGE_NAME = "$VERSION-$BUILD_NUMBER"
    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'smyndloh-DockerHub',
    usernameVariable: 'USER', passwordVariable: 'PWD']]) {
        sh "docker build -t smyndloh/containerz:${IMAGE_NAME} ."
        sh "echo ${PWD} | docker login -u ${USER} --password-stdin"
        sh "docker push smyndloh/containerz:${IMAGE_NAME}"
    }
}

// def deployApp() {
//     echo "deploying the app..."
// }

return this