package com.ProjectEuler.Utils;

/**
 * Created by deepanshu on 22/05/16, 1:04 PM.
 */
public class TimeLogger {
    private static final String MESSAGE = "%s: %g %s";
    private static final String[] units = {"seconds", "milliseconds", "microseconds", "nanoseconds"};
    private static final double NANO_FAC = 1;
    private static final double MICRO_FAC = 1000;
    private static final double MILLI_FAC = 1000000;
    private static final double SEC_FAC = 1000000000;
    private long nanons = 0;
    private long elapsedSoFar = 0;
    private long elapsedCurrentSprint = 0;
    //defaults
    private String title;
    private TimeUnit unit;

    public TimeLogger() {
        title = "Time to execute testcase: ";
        unit = TimeUnit.SECONDS;
    }

    public TimeLogger(String title, TimeUnit unit) {
        setTitleUnit(title, unit);
    }

    public void setUnit(TimeUnit tu) {
        unit = tu;
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setTitleUnit(String t, TimeUnit tu) {
        setTitle(t);
        setUnit(tu);
    }

    public void reset() {
        nanons = elapsedSoFar = 0;
    }

    public void startTracking() {
        nanons = System.nanoTime();
    }

    public void pauseTracking() {
        long t = System.nanoTime();
        elapsedCurrentSprint = nanons != 0 ? t - nanons : 0;
        nanons = 0;
        elapsedSoFar += elapsedCurrentSprint;
    }

    public void logCurrentSprint() {
        logCurrentSprint(title);
    }

    public void logCurrentSprint(String newTitle) {
        logElapsed(newTitle, elapsedCurrentSprint);
    }

    public void logSoFar() {
        logElapsed(title, elapsedSoFar);
    }

    public void stopTrackingAndLog() {
        pauseTracking();
        logSoFar();
        reset();
    }

    private void logElapsed(String title, long elapsed) {
        double val = elapsed;
        double fac = NANO_FAC;

        switch (unit) {
            case SECONDS:
                fac = SEC_FAC;
                break;
            case MILLI_SECONDS:
                fac = MILLI_FAC;
                break;
            case MICRO_SECONDS:
                fac = MICRO_FAC;
                break;
        }

        val /= fac;

        System.out.println(String.format(MESSAGE, title, val, units[unit.ordinal()]));
    }
}


