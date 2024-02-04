package Clinic;

import java.time.LocalDate;

public class Cat extends Animal implements Goable,Swimable {
    public Cat(String name) {
        super(name);
    }

    public Cat(String name, LocalDate birthday, Illness illness) {
        super(name, birthday, illness, "ничей");
    }

    public Cat(String name, Illness illness) {
        super(name, null, illness, "ничей");
    }

    @Override //переопределение метода
    public double toFly() {
        System.out.println(this.getClass().getSimpleName() + " не может летать");
        return 0;
    }

    @Override
    public double toGo() {
        return 10;
    }

    @Override
    public double toSwim() {
        return 5;
    }
}