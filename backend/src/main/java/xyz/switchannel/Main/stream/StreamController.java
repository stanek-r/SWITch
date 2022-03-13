package xyz.switchannel.Main.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stream")
public class StreamController {

    @Autowired
    StreamService streamService;

    @PostMapping("reset-key")
    public String resetLiveKey() {
        return streamService.resetLiveKey(null); // TODO: auth
    }

}
