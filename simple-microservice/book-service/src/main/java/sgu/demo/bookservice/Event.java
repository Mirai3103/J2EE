package sgu.demo.bookservice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Event {
    private String eventType;
    private Book data;
}
