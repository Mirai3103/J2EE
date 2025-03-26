package sgu.demo.authorservice.kafka;


import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final StreamBridge streamBridge;

    public MessageService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void sendMessage(String content) {

        streamBridge.send("produceMessage-out-0", content);
    }
}