FROM hirokimatsumoto/alpine-openjdk-11
ADD /target/*0.0.1-SNAPSHOT.jar *0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","*0.0.1-SNAPSHOT"]