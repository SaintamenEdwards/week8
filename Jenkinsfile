pipeline {
     agent any
     stages {
          stage("Acceptance Test") {
               steps {
                    sh '''
                    CALCIP=10.1.0.216
                    chmod +x acceptance-test.sh
                    chmod +x gradlew
                    ./gradlew acceptanceTest -Dcalculator.url=http://$CALCIP:8080
                    '''
               }
          }
     }
}