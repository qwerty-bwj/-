package com.example.student_command.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaobao
 */
@Data
@NoArgsConstructor
public class Teacher {
    private Integer tId;
    private String tPassword;
    private String tName;
}
