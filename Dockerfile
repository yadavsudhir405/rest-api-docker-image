FROM ubuntu:latest
MAINTAINER Sudhir Yadav "yadavsudhir405@gmail.com"
ENV REFRESHED_AT 10-Feb-2018

RUN apt-get update -y
RUN apt-get install -y software-properties-common
RUN add-apt-repository ppa:webupd8team/java
RUN apt-get update -y
RUN echo debconf shared/accepted-oracle-license-v1-1 select true | debconf-set-selections
RUN echo debconf shared/accepted-oracle-license-v1-1 seen true | debconf-set-selections
RUN apt-get install  -y oracle-java8-installer
RUN apt install oracle-java8-set-default
RUN mkdir -p /opt/rest-api; mkdir -p /etc/rest-api
COPY target/rest-api-0.0.1-SNAPSHOT.jar /opt/rest-api
COPY .config/rest-api.yml /etc/rest-api

ENV spring.config.name rest-api
ENV spring.config.location file:/etc/rest-api/
EXPOSE 8080

WORKDIR /opt/rest-api
ENTRYPOINT ["java"]
CMD ["-jar","rest-api-0.0.1-SNAPSHOT.jar", "Sudhir", "sudhiris056"]