FROM java:8
VOLUME /tmp
ADD  orders.jar
RUN bash -c 'touch /orders.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/orders.jar"]