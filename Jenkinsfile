pipeline {
     agent any
     stages {
          stage("Acceptance Test") {
               steps {
                    sh "chmod +x acceptance-test.sh"
                    sh "./acceptance-test.sh"
               }
          }
     }
}