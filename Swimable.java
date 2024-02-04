package Clinic;

public interface Swimable {
    double speed = 10;
    default double toSwim() {
        System.out.println("Плывет со скоростью " + speed);
        return speed;
    }
}