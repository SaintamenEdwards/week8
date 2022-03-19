podTemplate(yaml: ''' 
    apiVersion: v1 
    kind: Pod 
    spec: 
      containers:  
      - name: centos 
        image: centos 
        env:  
        - name: CALCIP 
          value: 10.1.0.216 
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
                         CALCIP=10.1.0.216
                         chmod +x acceptance-test.sh
                         chmod +x gradlew
                         ./gradlew acceptanceTest -Dcalculator.url=http://$CALCIP:8080 
                         ''' 
                    } 

               } 
          } 
     } 
} 
