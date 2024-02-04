package Clinic;

import java.time.LocalDate;

public class Dog extends Animal implements Goable,Swimable {
    public Dog(String name, LocalDate birthDay, Illness illness, String ownerName) {
        super(name, birthDay, illness, ownerName);
    }

    public Dog(String name, LocalDate birthday, Illness illness) {
        super(name, birthday, illness, "ничей");
    }

    public Dog(String name, Illness illness) {
        super(name, null, illness, "ничей");
    }

    public Dog (String name) {
        super(name);
    }

    public Dog()  {
        super();
    }

    @Override //переопределение метода
    public double toFly() {
        System.out.println(this.getClass().getSimpleName() + " не может летать");
        return 0;
    }

    @Override
    public double toGo() {
        return 20;
    }

    @Override
    public double toSwim() {
        return 5;
    }
}