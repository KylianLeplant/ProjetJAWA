package JAWA;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Clocking {
    private static int nextId;
    private int idClocking;
    private int idEmployee;
    private LocalDate date;
    private Hours clockingHour;


    public Clocking (int idEmployee , LocalDate date, Hours clockingHour){
        this.idClocking = nextId;
        nextId++;
        this.idEmployee = idEmployee;
        this.date = date;
        this.clockingHour = clockingHour;
    }
    public Clocking (int idClocking,int idEmployee , LocalDate date, Hours clockingHour){
        this.idClocking = idClocking;
        this.idEmployee = idEmployee;
        this.date = date;
        this.clockingHour = clockingHour;
    }

    public String toString(){
        return this.idClocking + ", " + this.getIdEmployee() + ", " + this.getDate() + ", " + this.getClockingHour().toString();
    }

    public static Clocking stringToClocking(String checkInStr) {
        String[] sentence = checkInStr.split(",");

        if (sentence.length != 3) {
            throw new IllegalArgumentException("Invalid check-in string");
        }
        int idClocking = Integer.valueOf(sentence[0]);
        int idEmployee = Integer.valueOf(sentence[1]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(sentence[2], formatter);
        String[] hours = sentence[3].split(":");
        Hours clockingHour = new Hours(Integer.valueOf(hours[0]),Integer.valueOf(hours[1]));

        return new Clocking(idClocking,idEmployee, date, clockingHour);
    }
    public int getIdEmployee() {return idEmployee;}

    public LocalDate getDate() {return date;}

    public Hours getClockingHour() {return clockingHour;}


    public void setClockingHour(Hours clockingHour){this.clockingHour = clockingHour;}


}