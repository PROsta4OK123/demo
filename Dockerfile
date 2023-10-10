FROM jelastic/maven:3.8.6-openjdk-20.ea-b24
WORKDIR /app
COPY . .
RUN mvn package
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]



