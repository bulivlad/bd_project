# bd_project
Vanzare de masini la un dealer auto

Pre-Requsites:
1) Oracle (at least) 11G-XE
2) Maven
3) Apache Tomcat

Install steps:
1) After install Oracle 11g-xe, import db from backup.sql files
2) Open cmd, Go into project folder and run mvn clean install command
3) Copy the .war file from [project_root]/frontend/target into [tomcat_root]/webapps
4) Open cmd, go into [tomcat_root]/bin and run catalina.bat jpda run command
