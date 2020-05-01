/*
 * To change this license header,
 choose License Headers in Project Properties.
 * To change this template file,
 choose Tools | Templates
 * and open the template in the editor.
 */
package com.khaled.bsitter.model.enums;

/**
 *
 * @author alibi
 */
public enum Days {
MONDAY("Monday"),
TUESDAY("Tuesday"),
WEDNESDAY("Wednesday"),
THURSDAY("Thursday"),
FRIDAY("Friday"),
SATURDAY("Saturday"),
SUNDAY("Sunday");

private String days;

    private Days(String days) {
        this.days = days;
    }

    public String getDays() {
        return days;
    }

}
