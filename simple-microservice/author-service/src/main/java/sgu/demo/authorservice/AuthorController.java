package sgu.demo.authorservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class AuthorController {
    @GetMapping
    public Map<String,String> hello() {
        String instanceId = System.getenv().getOrDefault("INSTANCE_ID", "unknown");
        System.out.println("Instance ID: " + instanceId);
//        return String.format("<h1>Hello from Author instance %s at %s</h1>", instanceId, java.time.LocalDate.now());?
        return Map.of("instanceId", instanceId,"time", java.time.LocalDate.now().toString(),"message","Hello from Author instance");
    }
}
