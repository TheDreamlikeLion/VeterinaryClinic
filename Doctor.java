package Clinic;

import java.time.LocalDate;

public class Doctor extends Personal {

    public Doctor(String fio, LocalDate birthDay) {
        super("Doctor", fio, birthDay);
    }

    public Doctor(String fio) {
        super("Doctor", fio, null);
    }

    public void curePatient (Animal animal) {
        System.out.println("Доктор излечил зверушку. Слава докторам!");
        animal.setIllness(null);
    }

}