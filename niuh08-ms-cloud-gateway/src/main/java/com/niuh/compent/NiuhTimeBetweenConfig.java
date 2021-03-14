package com.niuh.compent;

import lombok.Data;

import java.time.LocalTime;
import java.time.ZonedDateTime;

/**
 * Created by hejianhui on 2019/12/16.
 */
@Data
public class NiuhTimeBetweenConfig {

    private LocalTime startTime;

    private LocalTime endTime;

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now());
    }

}
