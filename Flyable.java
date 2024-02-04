package Clinic;

public interface Flyable {
double speed = 20;
    default double toFly() {
        System.out.println("Летит со скоростью " + speed);
        return speed;
    }
}