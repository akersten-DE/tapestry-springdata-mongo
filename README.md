tapestry-springdata-mongo
=========================

A very simple example how to integrate tapestry and spring-data with mongoDB


The project was created with the maven tapestry-archetype for Tapestry version 5.3.7 and use spring-data-mongodb in version 1.2.1.RELEASE


Most work has been done by the tapestry-spring integration (see http://tapestry.apache.org/integrating-with-spring-framework.html)

We just need to add the spring configuration. In this example it is springContext.xml and springMongoContext.xml. Both files are referenced in the web.xml. 
The spring-config files uses Tapestry-Symbols to configure some values like the database-url. The values for the symbols are set in the class AppModule.

The spring-services can be used within tapestry as every tapestry-service. An example is in the class Index. 


To run the example you need a mongoDB (see http://www.mongodb.org/) and use maven "mvn jetty:run" to start the web-app