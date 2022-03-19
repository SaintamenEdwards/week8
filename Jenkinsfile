podTemplate(yaml: '''
    apiVersion: v1
    kind: Pod
    spec:
      serviceAccountName: api-service-account
      containers:
      - name: centos
        image: centos
        command:
        - sleep
        args:
        - 99d
      restartPolicy: Never
''') { 
     node(POD_LABEL) { 
          stage('k8s') { 
               git 'https://github.com/SaintamenEdwards/week8.git' 
               container('centos') { 
                    stage('start calculator') { 
                         sh ''' 
                         chmod +x acceptance-test.sh
                         chmod +x gradlew
                         ./gradlew acceptanceTest -Dcalculator.url=http://calculator-service:8080 
                         ''' 
                    } 
               } 
          } 
     } 
} 
