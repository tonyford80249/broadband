ref: Engineer Static Repository File

BUILD INSTRUCTIONS:
===================
This is an Eclipse project by default.

When you first import this project to Eclipse, you may notice some errors with reference to HttpServletRequest 
and HttpServletResponse classes.  This can be fixed by providing the jsp-api.jar and servlet-api.jar libraries
from your Tomcat server.  You can do this by right-clicking on the project then Build Path > Configure Build Path >
Libraries (tab) > Add External Jars > then add the two library files: jsp-api.jar and servlet-api.jar.

If for any reason you don't have a Tomcat server available, you can add the jsp-api.jar and servlet-api.jar found in
'etc/lib' folder.

You can build the project through Ant by running build.xml.  Please take note that you need to supply the 
tomcat home directory (tomcat.home.dir) in build.properties file.

This application is also built using Maven.  The pom.xml file is located under the top root directory. 

To build the project into a war file using Maven: from the terminal or command prompt, navigate to the directory path of the project, 
then enter the command "mvn package" (no quotes) or "mvn package -DskipTests=true" (no quotes) to skip JUnit and 
Selenium tests.

