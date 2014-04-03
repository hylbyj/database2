#!/bin/bash

mkdir -p bin
CP1="src:commons-lang3-3.3.1.jar:google-http-client-1.17.0-rc-sources.jar:google-http-client-1.17.0-rc.jar:json-path-0.5.3.jar:json-simple-1-1.1.1.jar"
CP2="bin:commons-lang3-3.3.1.jar:google-http-client-1.17.0-rc-sources.jar:google-http-client-1.17.0-rc.jar:json-path-0.5.3.jar:json-simple-1-1.1.1.jar"
javac -d bin/ -cp ${CP1} src/test.java src/*java 
java -cp ${CP2}  test $1 $2 $3 "$4" $5 $6

# ./run.sh Mxnr9RJ9poyUII770cqTc/1H9V 0.9 "snow leopard"

