FROM hirokimatsumoto/alpine-openjdk-11
ADD /target/*0.0.1-SNAPSHOT *0.0.1-SNAPSHOT
ENTRYPOINT ["java","-jar","*0.0.1-SNAPSHOT"]