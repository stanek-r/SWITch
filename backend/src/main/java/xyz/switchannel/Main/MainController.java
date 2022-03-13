package xyz.switchannel.Main;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @GetMapping()
    public String getTest() {
        return "Test";
    }

}
