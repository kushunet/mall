FROM java:8
#
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone

ADD /target/mall-sell-web-0.0.1-SNAPSHOT.jar mall-sell-web.jar

EXPOSE 8081
ENTRYPOINT ["java","-jar","mall-sell-web.jar"]