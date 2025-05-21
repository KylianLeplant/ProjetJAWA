package JAWA;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Hours pointage1 = new Hours(8,5);
        Hours pointage2 = new Hours(18,20);

        Employee employeur = new Employee();
        employeur.setName("Paul");

        Clocking heureArrivee = new Clocking(employeur.getId() , LocalDate.now(),pointage1);
        Clocking heureDepart = new Clocking(employeur.getId(),LocalDate.now(),pointage2);


        TimeClockEmulator emul = new TimeClockEmulator("src/main/java/JAWA/test.txt");

        emul.clockIn(heureArrivee);
        emul.clockIn(heureDepart);

        System.out.println("liste des pintages");
        emul.sendClocking();

        




    }
}
