package com.sparta.mycalendar.scheduleController;

import com.sparta.mycalendar.entity.Schedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/*
 * 얘는 데이터만 줘
 */
@Slf4j
@RestController


public class Post {

    /*
     * ScheduleRestController 에서 스프링에서 만든 DataSource 얘를 쓸수있게 해주는거
     * @Autowired : ScheduleRestController 가  DataSource 를 쓸 수 있게 변수 좀 줘
     *
     */
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*\
     * PostMapping : Post 요청을 받을거야 
     * 근데 어디로 ? -> /schedules 로
     * 
     * @RequestBody Schedule schedule
     * -> Body 에 있는 데이터로 Schedule 객체 만들어줘
     *    그리고 만든 후에 schedule 변수에 담아줘
     *
     * @RequestBody Schedule schedule 만들어주는 과정
     * 1. 기본생성자(new Schedule())로 Schedule 객체를 생성해
     * 2. 요청 Body 에 Schedule 필드 값 이름과 일치하는게 있는지 확인한다.
     * 3. 일치하는게 있다면 set필드명()으로 필드 값을 할당해줌
     */
    @org.springframework.web.bind.annotation.PostMapping("api/schedules")
    public String addSchedule(@RequestBody Schedule schedule) {
        System.out.println(schedule);

        String sql = "INSERT INTO Schedule (author, password, content, createdTime, lastModifiedTime) " +
                "VALUES (?, ?, ?, ?, ?)";

        int result = jdbcTemplate.update(sql, schedule.getAuthor(), schedule.getPassword(),
                schedule.getContent(), schedule.getCreatedTime(),
                schedule.getLastModifiedTime());

        if (result > 0) {
            return "성공했습니다";
        } else {
            return "실패했습니다.";
        }
    }
}
