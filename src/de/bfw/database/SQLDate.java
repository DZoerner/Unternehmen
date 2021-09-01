package de.bfw.database;

public class SQLDate implements Comparable{
    private int year;
    private int month;
    private int day;

    public SQLDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return  String.format("%d-%02d-%02d", year, month, day);
    }

    @Override
    public int compareTo(Object o) {
        if(! (o instanceof SQLDate)){
            return 0;
        }
        SQLDate other = (SQLDate) o;

        int c = Integer.compare(year, other.year);
        if(c != 0){
            return c;
        }
        c = Integer.compare(month, other.month);
        if(c != 0){
            return c;
        }
        return Integer.compare(day, other.day);
    }
}
