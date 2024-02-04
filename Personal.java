package Clinic;

import java.time.LocalDate;
import java.util.List;

public abstract class Personal {
    protected String position;
    protected String fio;
    protected LocalDate birthDay;

    public Personal (String position, String fio, LocalDate birthDay) {
        this.position = position;
        this.fio = fio;
        this.birthDay = birthDay;
    }

    public Personal (String fio) {
        this.position = "Стажер";
        this.fio = fio;
        this.birthDay = null;
    }

    @Override
    public String toString() {return String.format("position: %s; full name: %s; birthday: %s \n", position, fio, birthDay);}
}
