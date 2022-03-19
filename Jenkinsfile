podTemplate(yaml: ''' 
    apiVersion: v1 
    kind: Pod 
    spec: 
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
