FROM openjdk:8-jre-alpine
RUN mkdir -p /usr/local/service
COPY OptimisePath-0.0.1-SNAPSHOT.jar /usr/local/service/ShortestPath-1.0.jar
WORKDIR /usr/local/service
EXPOSE 8085
CMD ["java","-jar","OptimisePath-0.0.1-SNAPSHOT.jar"]
