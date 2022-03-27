package com.example.student_command.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaobao
 */
@Data
@NoArgsConstructor
public class Course {

    private Integer cId;

    private Integer grade;

    private Integer classes;

    private String courseName;
}
