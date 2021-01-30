FROM maven as compiler

WORKDIR ./app

COPY ./ .

RUN mvn clean install

RUN mv target/Foto-Managment.war target/foto.war


FROM tomcat

COPY --from=compiler /app/target/foto.war /usr/local/tomcat/webapps/

WORKDIR /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]