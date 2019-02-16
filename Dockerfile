FROM openjdk:alpine
MAINTAINER Sudhir Yadav "yadavsudhir405@gmail.com"
ENV REFRESHED_AT 10-Feb-2018

RUN mkdir -p /opt/rest-api; mkdir -p /etc/rest-api
COPY target/rest-api-0.0.1-SNAPSHOT.jar /opt/rest-api
COPY .config/rest-api.yml /etc/rest-api

ENV spring.config.name rest-api
ENV spring.config.location file:/etc/rest-api/
EXPOSE 8080

WORKDIR /opt/rest-api
ENTRYPOINT ["java"]
CMD ["-jar","rest-api-0.0.1-SNAPSHOT.jar", "Sudhir", "sudhiris056"]