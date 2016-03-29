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


