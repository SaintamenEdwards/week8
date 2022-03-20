podTemplate(yaml: ''' 
    apiVersion: v1 
    kind: Pod 
    spec: 
      containers:  
      - name: centos 
        image: centos 
        env:  
        - name: CALCIP 
          value: 10.101.99.235 
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
                         set +e
                         CALCIP=10.101.99.235
                         chmod +x acceptance-test.sh
                         chmod +x gradlew
                         ./gradlew acceptanceTest -Dcalculator.url=http://$CALCIP:8080 
                         ''' 
                    } 

               } 
          } 
     } 
}
