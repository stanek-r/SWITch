package xyz.switchannel.Main.rtmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import xyz.switchannel.Main.exceptions.ForbiddenException;
import xyz.switchannel.Main.models.User;
import xyz.switchannel.Main.stream.StreamService;
import xyz.switchannel.Main.user.UserService;

@RestController
@RequestMapping("rtmp")
public class RTMPAuthController {

    @Autowired
    UserService userService;
    @Autowired
    StreamService streamService;

    @PostMapping("auth")
    public void checkCredentials(@RequestBody MultiValueMap<String, String> userFormData) {
        String userName = userFormData.getFirst("user");
        String liveKey = userFormData.getFirst("key");

        User user = userService.getUserByName(userName);
        if (!streamService.checkCredentials(user, liveKey)) {
            throw new ForbiddenException("Wrong credentials!");
        }
    }
}
