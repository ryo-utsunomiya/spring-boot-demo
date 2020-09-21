package info.ryo511.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerUnitTest {
    @Test
    public void hello() {
        var SUT = new HelloController();
        var model = new BindingAwareModelMap();
        var viewName = SUT.hello("Universe", model);
        assertEquals("hello", viewName);
        assertEquals("Universe", model.asMap().get("name"));
    }
}
