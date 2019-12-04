FROM java:8
#
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone

ADD /target/mall-sms-service-0.0.1-SNAPSHOT.jar mall-sms-service.jar

EXPOSE 8092
ENTRYPOINT ["java","-jar","mall-sms-service.jar"]