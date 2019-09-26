FROM java:8
VOLUME /tmp
ADD  app.jar
RUN bash -c 'touch /product.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/product.jar"]