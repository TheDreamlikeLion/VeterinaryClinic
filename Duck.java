package Clinic;

import java.time.LocalDate;

public class Duck extends Bird implements Goable, Swimable, Flyable {
    public Duck() {super();}

    public Duck(String name, LocalDate birthday, Illness illness, String ownerName) {
        super(name, birthday, illness, ownerName);
    }

    @Override //переопределение метода
    public double toSwim() {
        System.out.println(this.getClass().getSimpleName() + " может плавать");
        return 10;
    }

    @Override
    public double toFly() {
        return 30;
    }

    @Override
    public double toGo() {
        return 5;
    }
}