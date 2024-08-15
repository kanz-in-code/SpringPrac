package com.sparta.mycalendar.scheduleController;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

/*
 * 얘 역활 : 페이지만 반환해
 */
@Getter
@Setter
@Controller
public class Get {

    @org.springframework.web.bind.annotation.GetMapping("api/schedules")
    public String sql() {
        return "api/schedules";
    }



}
