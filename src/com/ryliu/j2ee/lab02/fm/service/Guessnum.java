package com.ryliu.j2ee.lab02.fm.service;

public class Guessnum {

    /**
     * The winning value.
     */
    private static final int WIN_VALUE = 70;

    public Guessnum() {
        times = 10;
    }

    private int times;

    public void setTimes(int times) {
        this.times = times;
    }

    public int getTimes() {
        return times;
    }

    public boolean guess(int value) {
        --times;
        return WIN_VALUE == value;
    }
}
