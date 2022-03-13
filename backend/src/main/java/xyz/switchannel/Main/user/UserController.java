package xyz.switchannel.Main.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.switchannel.Main.exceptions.BadRequestException;
import xyz.switchannel.Main.models.User;
import xyz.switchannel.Main.restModels.RegisterUser;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public User registerUser(@RequestBody RegisterUser user) {
        if (user.name == null || user.email == null || user.password == null) {
            throw new BadRequestException("Cannot register user without all parameters");
        }
        return this.userService.registerUser(user.name, user.password, user.email);
    }

}
