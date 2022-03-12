package xyz.switchannel.Main.RTMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import xyz.switchannel.Main.exceptions.ForbiddenException;
import xyz.switchannel.Main.repositories.UserRepository;

@RestController
@RequestMapping("rtmp")
public class RTMPAuthController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("auth")
    public void checkCredentials(@RequestBody MultiValueMap<String, String> userFormData) {
        System.out.println(userRepository.findUserByName(userFormData.getFirst("user")));
        throw new ForbiddenException("This key does not exist!");
    }
}
