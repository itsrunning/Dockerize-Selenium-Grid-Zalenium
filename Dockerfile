FROM maven:3.6.0-jdk-8-alpine
ADD . .
ARG    xml
ENV xml=$xml
CMD ["echo", "${xml}"]
CMD ["mvn","install"]
