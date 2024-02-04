package Clinic;

import java.time.LocalDate;

public class Ostrich extends Bird implements Goable {
    public Ostrich() {super();}

    public Ostrich(String name, LocalDate birthday, Illness illness, String ownerName) {
        super(name, birthday, illness, ownerName);
    }

    @Override //переопределение метода
    public double toSwim() {
        System.out.println(this.getClass().getSimpleName() + " не может плавать");
        return 0;
    }
    @Override
    public double toFly() {
        System.out.println(this.getClass().getSimpleName() + " не может летать");
        return 0;
    }

    @Override
    public double toGo() {
        return 50;
    }
}