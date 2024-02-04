package Clinic;

import java.time.LocalDate;

public class Nurse extends Personal{

    public Nurse (String fio, LocalDate birthDay) {
        super("Nurse", fio, birthDay);
    }

    public Nurse (String fio) {
        super("Nurse", fio, null);
    }

    public void checkPatient (Animal animal) {
        System.out.println(animal);
        if (animal.getIllness() != null) {
            System.out.println("Бедная зверушка. Доктор должен посмотреть.\n");
        } else {
          System.out.println("Зверушка здорова. Надо выписывать!\n");
        }
    }
}