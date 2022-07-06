package model.entities;

import model.enums.DaysOfTheWeek;

public class SchoolGrade {
    
    private String classes;
    private String initialHour;
    private String lastHour;
    private DaysOfTheWeek daysOfTheWeek;

    public SchoolGrade() {

    }

    public SchoolGrade(String classes, String initialHour, String lastHour, DaysOfTheWeek daysOfTheWeek) {
        this.classes = classes;
        this.initialHour = initialHour;
        this.lastHour = lastHour;
        this.daysOfTheWeek = daysOfTheWeek;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getInitialHour() {
        return initialHour;
    }

    public void setInitialHour(String initialHour) {
        this.initialHour = initialHour;
    }

    public String getLastHour() {
        return lastHour;
    }

    public void setLastHour(String lastHour) {
        this.lastHour = lastHour;
    }

    public DaysOfTheWeek getDaysOfTheWeek() {
        return daysOfTheWeek;
    }

    public void setDaysOfTheWeek(DaysOfTheWeek daysOfTheWeek) {
        this.daysOfTheWeek = daysOfTheWeek;
    }

    public void removeInform() {
        this.classes = null;
        this.initialHour = null;
        this.lastHour = null;
        this.daysOfTheWeek = null;
    }

    public Double totalHours() {
        return Double.parseDouble(lastHour.replace(':', '.')) - Double.parseDouble(initialHour.replace(':', '.')) - 0.4;
    }
    
    @Override
    public String toString() {
       return daysOfTheWeek + ", " + classes + ": " + initialHour + "-" + lastHour + ". Total hours: " + String.format("%.2f", totalHours());
    }
}