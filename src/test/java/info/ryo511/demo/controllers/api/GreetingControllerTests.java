package info.ryo511.demo.controllers.api;

import info.ryo511.demo.entities.Greeting;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTests {
    @Autowired
    private TestRestTemplate template;

    @Test
    void greetWithoutName() {
        var entity = template.getForEntity("/api/greeting", Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assertNotNull(response);
        assertEquals("Hello, World!", response.getMessage());
    }

    @Test
    void greetWithName() {
        var response = template.getForObject("/api/greeting?name=Universe", Greeting.class);
        assertEquals("Hello, Universe!", response.getMessage());
    }
}