Jersey 2 + Spring + Mockito + Test
==================================

Here is an example: how to combine the Jersey 2 with Spring framework. 
Unit tests based on [nl.bstoi.jersey.test-framework](http://mvnrepository.com/artifact/nl.bstoi.jersey.test-framework) and Mockito framework.

Enable Spring DI with Jersey 2
---------------------
To enable work Spring with a resource, it must be annotated with @Component.

	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import org.springframework.stereotype.Component;
	 
	@Component
	@Path("/")
	public class SomeResource {
	 
	    @Transactional
	    @GET
	    public void updateResource() {
	        // ...
	    }
	}

[More info](https://jersey.java.net/documentation/latest/spring.html)

Usage
-------

Run application

	mvn jetty:run

Use CURL command:
	
	curl -i http://localhost:8080/jersey2-spring-example/api/status
	
Example response:

	HTTP/1.1 200 OK
	Date: Thu, 24 Mar 2016 22:24:34 GMT
	Content-Type: application/json
	Content-Length: 24
	Server: Jetty(9.2.11.v20150529)
	
	{"status":1458858274698}

Run unit tests:

	mvn test
	
Handle API errors
Mechanism of handling errors based on [Exception Mapper](https://docs.oracle.com/javaee/7/api/javax/ws/rs/ext/ExceptionMapper.html)

Not found:
Request:

	curl -i http://localhost:8080/jersey2-spring-example/api/invalid
	
Response:

	HTTP/1.1 404 Not Found
	Date: Sun, 03 Apr 2016 20:02:15 GMT
	Content-Type: application/json
	Content-Length: 48
	Server: Jetty(9.2.11.v20150529)
	
	{"code":404,"description":"Endpoint not found."}
	
Internal Server Error:
Request:

	curl -i http://localhost:8080/jersey2-spring-example/api/status/error
	
Response:

	HTTP/1.1 500 Internal Server Error
	Date: Sun, 03 Apr 2016 20:07:09 GMT
	Content-Type: application/json
	Content-Length: 51
	Server: Jetty(9.2.11.v20150529)
	
	{"code":500,"description":"Internal server error."}
	


