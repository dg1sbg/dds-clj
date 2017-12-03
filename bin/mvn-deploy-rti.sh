#!/bin/bash

if [ -z "$RTI_CONNEXT_DDS_JARPATH" ]; then
    echo "Must set RTI_CONNEXT_DDS_JARPATH to location of RTI DDS jar files"
    exit 1
fi

mvn install:install-file -DgroupId=com.rti.ndds \
  -DartifactId=nddsjavad \
  -Dversion=5.3.0 \
  -Dpackaging=jar \
  -Dfile=$RTI_CONNEXT_DDS_JARPATH/nddsjavad.jar
