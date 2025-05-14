package JAWA;

import java.time.LocalDate;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.ArrayList;

public class TimeClockEmulator {
    private ArrayList<Clocking> clockingList;
    private Serializer serialize;

    public TimeClockEmulator(String filename){
        this.clockingList = new ArrayList<Clocking>();
        System.out.println("Time ");
        Serializer serialize = new Serializer(filename);
    }

    //PEUT ETRE A SUPPRIMER
    //ajouter un pointage a la liste  //PEUT ETRE A SUPPRIMER
    //public void addClocking(Clocking clocking){         //PEUT ETRE A SUPPRIMER
    //    this.clockingList.add(clocking);   //PEUT ETRE A SUPPRIMER
    //}//PEUT ETRE A SUPPRIMER


    public void clockIn(int idEmployee , LocalDate date, Hours clockingHour){
        Clocking clocking = new Clocking(idEmployee, date, clockingHour);
        this.clockingList.add(clocking);
    }

    public void clockIn(Clocking clocking){
        this.clockingList.add(clocking);
    }

    public void removeClocking (Clocking clocking){
        clockingList.remove( clocking);
    }

    //envoyer la liste des pointages:
    public void sendClocking() {
        for (Clocking clocking: clockingList){
            System.out.println("Envoi du pointage : " + clocking.getIdEmployee()+" - " + clocking.getClockingHour());
        }
    }

    public ArrayList<Clocking> getClockingList() {
        return clockingList;
    }

    public void clearClockinglist(){
        clockingList.clear();
    }
}