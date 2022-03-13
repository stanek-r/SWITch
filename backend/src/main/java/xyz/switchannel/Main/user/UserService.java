package xyz.switchannel.Main.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.switchannel.Main.Utils;
import xyz.switchannel.Main.enums.Restrictions;
import xyz.switchannel.Main.enums.StreamCategory;
import xyz.switchannel.Main.enums.Tag;
import xyz.switchannel.Main.exceptions.NotFoundException;
import xyz.switchannel.Main.models.SocialLink;
import xyz.switchannel.Main.models.StreamSettings;
import xyz.switchannel.Main.models.User;
import xyz.switchannel.Main.models.UserSettings;
import xyz.switchannel.Main.repositories.StreamSettingsRepository;
import xyz.switchannel.Main.repositories.UserRepository;
import xyz.switchannel.Main.repositories.UserSettingsRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserSettingsRepository userSettingsRepository;
    @Autowired
    StreamSettingsRepository streamSettingsRepository;

    @Autowired
    WalletService walletService;

    public User registerUser(String name, String password, String email) {
        User user = new User(
                Utils.generateId(10),
                name,
                password,
                email
        );
        UserSettings userSettings = new UserSettings(
                user.getId(),
                name,
                "New inspiring streamer!",
                new SocialLink[0],
                true
        );
        StreamSettings streamSettings = new StreamSettings(
                user.getId(),
                Utils.generateId(30),
                name + "'s stream",
                "en",
                Restrictions.NONE,
                StreamCategory.NONE,
                new Tag[0]
        );

        User createdUser = userRepository.insert(user);
        userSettingsRepository.insert(userSettings);
        streamSettingsRepository.insert(streamSettings);
        this.walletService.createNewWallet(createdUser);
        return createdUser;
    }

    public User getUserById(String userId) {
        User user = this.userRepository.findUserById(userId);
        if (user == null) {
            throw new NotFoundException("User not found!");
        }
        return user;
    }

    public User getUserByName(String userName) {
        User user = this.userRepository.findUserByName(userName);
        if (user == null) {
            throw new NotFoundException("User not found!");
        }
        return user;
    }
}
