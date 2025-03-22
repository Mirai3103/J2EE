package sgu.demo.bookservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("test")
@RefreshScope
public class DefaultController {
    @Value("${app.version:none}")
    private String version;
    @GetMapping
    public String hello() {
        String instanceId = System.getenv().getOrDefault("INSTANCE_ID", "unknown");
        System.out.println("Instance ID: " + instanceId);
        return String.format("<h1>Hello from Books instance %s at %s version %s</h1>", instanceId, LocalDate.now(), version);
    }
}
