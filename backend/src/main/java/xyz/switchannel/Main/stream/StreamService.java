package xyz.switchannel.Main.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.switchannel.Main.Utils;
import xyz.switchannel.Main.models.StreamSettings;
import xyz.switchannel.Main.models.User;
import xyz.switchannel.Main.repositories.StreamSettingsRepository;

@Service
public class StreamService {

    @Autowired
    StreamSettingsRepository streamSettingsRepository;

    public boolean checkCredentials(User user, String userName, String liveKey) {
        if (liveKey == null || liveKey.strip().equals("") || userName == null || userName.strip().equals("")) {
            return false;
        }
        if (!user.getName().equals(userName)) {
            return false;
        }
        StreamSettings streamSettings = streamSettingsRepository.findStreamSettingsByUserId(user.getId());
        return streamSettings.getLiveKey().equals(liveKey);
    }

    public String resetLiveKey(User user) {
        StreamSettings streamSettings = streamSettingsRepository.findStreamSettingsByUserId(user.getId());
        streamSettings.setLiveKey(Utils.generateId(30));
        streamSettingsRepository.save(streamSettings);
        return streamSettings.getLiveKey();
    }
}
