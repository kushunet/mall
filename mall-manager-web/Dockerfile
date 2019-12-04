FROM java:8
#
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone

ADD /target/mall-manager-web-0.0.1-SNAPSHOT.jar mall-manager-web.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","mall-manager-web.jar"]