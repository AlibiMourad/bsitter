package com.khaled.clientbsitter.model.enums;

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
