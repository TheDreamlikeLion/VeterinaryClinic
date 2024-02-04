package Clinic;

public interface Goable {
    double speed = 10;
    default double toGo() {
        System.out.println("Ходит со скоростью " + speed);
        return speed;
    }
}
