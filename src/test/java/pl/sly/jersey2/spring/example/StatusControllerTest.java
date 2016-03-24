package pl.sly.jersey2.spring.example;

import nl.bstoi.jersey.test.framework.spring.SpringContextJerseyTest;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.SpringLifecycleListener;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.sly.jersey2.spring.example.controller.StatusController;
import pl.sly.jersey2.spring.example.dto.StatusDto;
import pl.sly.jersey2.spring.example.service.StatusService;

import javax.ws.rs.core.Application;

public class StatusControllerTest extends SpringContextJerseyTest {
    public static final String CONTEXT_CONFIG_LOCATION = "contextConfigLocation";
    public static final String TEST_CONTEXT = "classpath:testContext.xml";

    StatusService statusServiceMock;

    @Override
    protected Application configure() {
        ResourceConfig resourceConfig = new ResourceConfig(StatusController.class);
        resourceConfig.register(SpringLifecycleListener.class);
        resourceConfig.register(RequestContextFilter.class);
        resourceConfig.property(CONTEXT_CONFIG_LOCATION, TEST_CONTEXT);

        return resourceConfig;
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        statusServiceMock = (StatusService) getSpringApplicationContext().getBean("statusServiceMock");
    }

    @After
    public void after() throws Exception {
        super.tearDown();
    }

    @Test
    public void testStatus() {
        //given
        Mockito.when(statusServiceMock.getTime()).thenReturn(Long.valueOf(1234));

        //when
        StatusDto response = target("status").request().get(StatusDto.class);

        //then
        Assert.assertNotNull(response);
        Assert.assertEquals(Long.valueOf(1234), response.getStatus());
    }
}