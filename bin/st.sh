
#APP_JAR_NAME="read-0.0.1-SNAPSHOT.jar"
#JVM_ARGS="-server -Xms1024m -Xmn512m"

#    cd ../    
#    nohup java $JVM_ARGS -jar $APP_JAR_NAME

#    echo ----
#    echo $APP_JAR_NAME start...
#    echo ---

   cd ../
   nohup java -jar read-0.0.1-SNAPSHOT.jar >usr/readstart/output.log 2>&1 &
   echo $!> /var/run/read-0.0.1-SHAPSHOT.pid
   echo read start



