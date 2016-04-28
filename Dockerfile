FROM ubuntu:14.04

RUN add-apt-repository ppa:webupd8team/java
RUN apt-get update
RUN apt-get install -y oracle-java8-installer

ADD target /service
ADD startup.sh /service/startup.sh

VOLUME ["/service/logs"]

WORKDIR /service
CMD ["startup.sh"]

EXPOSE 80