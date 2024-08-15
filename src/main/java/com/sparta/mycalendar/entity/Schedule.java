package com.sparta.mycalendar.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.geom.AffineTransform;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Schedule {

    private int id; // 고유 아이디
    private String author = ""; // 작성자 : 담당자 명
    private String password = ""; // 패스워드
    private String content; // 내용
    private final LocalDateTime createdTime = LocalDateTime.now(); // 생성일
    private LocalDateTime lastModifiedTime; // 마지막 수정일

    public void setContent(String content) {
        this.content = content;
        this.lastModifiedTime = LocalDateTime.now();
    }

}
