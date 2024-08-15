package com.sparta.mycalendar.scheduleController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Put {
    @PutMapping("/api/schedules/{id}")
    @ResponseBody
    public String put(){
return "ok";
    }
}
