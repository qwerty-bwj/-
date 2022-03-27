package com.example.student_command.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaobao
 */
@Data
@NoArgsConstructor
public class Record {
    private int rNum;
    private int sId;
    private String tName;
    private String sName;
    private String detail;
    private Date time;

    public String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String dateString = formatter.format(this.time);
        return dateString;
    }
}
