package com.example.student_command.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaobao
 */
@Data
@NoArgsConstructor
public class Student {
    private int sId;
    private String sPassword;
    private String sName;
    private int cId;
    private int score;
}
