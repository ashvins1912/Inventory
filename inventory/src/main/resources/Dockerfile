FROM java:8
VOLUME /tmp
ADD  inventory.jar
RUN bash -c 'touch /inventory.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/inventory.jar"]