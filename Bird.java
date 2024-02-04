package Clinic;

import java.time.LocalDate;

public class Bird extends Animal implements Flyable, Goable {
    public Bird() {super();}

    @Override
    public double toFly() {
        return 20;
    }

    public Bird(String name, LocalDate birthday, Illness illness, String ownerName) {
        super(name, birthday, illness, ownerName);
    }

    @Override //переопределение метода
    public double toSwim() {
        System.out.println(this.getClass().getSimpleName() + " не может плавать");
        return 0;
    }

    @Override
    public double toGo() {
        return 5;
    }
}