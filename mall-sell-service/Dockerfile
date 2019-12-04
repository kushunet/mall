FROM java:8
#
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone

ADD /target/mall-sell-service-0.0.1-SNAPSHOT.jar mall-sell-service.jar

EXPOSE 8071

ENTRYPOINT ["java","-jar","mall-sell-service.jar"]