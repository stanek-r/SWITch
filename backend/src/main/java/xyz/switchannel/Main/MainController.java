package xyz.switchannel.Main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping
    public String getTest() {
        return "Test";
    }

    @GetMapping("test")
    public String getTest2() {
        return "Test 2";
    }
}
