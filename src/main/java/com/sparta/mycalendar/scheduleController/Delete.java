package com.sparta.mycalendar.scheduleController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Delete {
    @DeleteMapping("/api/schedules/{id}")
    public String delete() {
        return "DELETE Method 요청";
    }
}