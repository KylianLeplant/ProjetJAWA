package JAWA;

import java.time.LocalTime;

public class Hours {
    private int hours;
    private int minutes;

    public Hours() {
        hours = 0;
        minutes = 0;
    }

    public Hours(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHour() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setHour(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int[] GetHoursMinutes(LocalTime time) {
        return new int[]{time.getHour(), time.getMinute()};
    }

    @Override
    public String toString() {
        return String.format("%d:%02d", hours, minutes);
    }

    public void roundTime() {
        int roundedMinutes = Math.round(minutes / 15.0f) * 15;
        if (roundedMinutes == 60) {
            hours++;
            minutes = 0;
        } else {
            minutes = roundedMinutes;
        }
    }

    public void addTime(Hours time) {
        hours = (hours + time.getHour()) + (minutes + time.getMinutes()) / 60;
        minutes = (minutes + time.getMinutes()) % 60;
    }

    public void removeTime(Hours time) {
        minutes -= time.getMinutes();
        hours -= time.getHour();

        if (minutes < 0) {
            minutes += 60;
            hours -= 1;
        }
    }

    /*public static void main(String[] args) {
        Hours hour = new Hours();
        hour.setHour(1);
        hour.setMinutes(50);
        System.out.println(hour);

        Hours hour2 = new Hours(15, 23);
        System.out.println(hour2);
        hour2.addTime(hour);
        System.out.println(hour2);
        hour2.removeTime(new Hours(1, 15));
        System.out.println(hour2);


    }*/
}
