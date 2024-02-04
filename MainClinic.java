package Clinic;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainClinic {
    public static void main(String[] args) {
        VeterinaryClinic clinic = new VeterinaryClinic();
        System.out.println(clinic.getPatients());

        Personal doctor = new Doctor("Аркадий Паровозов");
        Personal nurse = new Nurse("Елена Перова");

        clinic.addPersonal(doctor);
        clinic.addPersonal(nurse);
        clinic.addPatient(new Cat("Васька"));
        clinic.addPatient(new Cat("Мурзик", null));
        clinic.addPatient(new Duck("Скрудж", null, new Illness("Сломано крыло"), null));
        clinic.addPatient(new Dog("Трезор"));
        clinic.addPatient(new Ostrich("Мими", null, new Illness("Сломана нога"), null));
        clinic.addPatient(new Dog("Пушистик"));
        clinic.addPatient(new Bird("Поночка", null, new Illness("Птичий гриб"), null));
        clinic.addPatient(new Cat("Баюн", null));
        clinic.addPatient(new Dog("Цербер", null));

        System.out.println("Работники клиники:");
        System.out.println(clinic.getPersonal());
        System.out.println("Пациенты клиники:");
        System.out.println(clinic.getPatients());

        System.out.println("Из них ходящие:");
        System.out.println(clinic.filterGoable());
        System.out.println();
        System.out.println("Из них плавающие:");
        System.out.println(clinic.filterSwimable());
        System.out.println();
        System.out.println("Из них летающие:");
        System.out.println(clinic.filterFlyable());
        System.out.println();

        System.out.println("--------------------\nНачинаем обход.\n--------------------\n");
        ArrayList<Animal> toRemove = new ArrayList<>();
        ArrayList<Animal> toCure = new ArrayList<>();

        for (Animal animal : clinic.getPatients()) {
            ((Nurse) nurse).checkPatient(animal);
            if (animal.getIllness() != null) {
                toCure.add(animal);
            } else {toRemove.add(animal);}
        }
        System.out.println("--------------------\nОбход закончен.\n--------------------\n");

        if (!toCure.isEmpty()) {
            System.out.println("\nПришел доктор. Начинаем лечить.\n--------------------\n");
            for (Animal animal : toCure) {
                System.out.println(animal);
                ((Doctor) doctor).curePatient(animal);
                System.out.println("Пациент оставлен в клинике - понаблюдаем.\n");
            }
        }

        if (!toRemove.isEmpty()) {
            System.out.println("--------------------\nНачинаем выписку.\n--------------------\n");
            for (Animal animal : toRemove) {
                System.out.println(animal);
                clinic.removePatient(animal);
            }
        }

        System.out.println("--------------------\nОставшиеся пациенты клиники:");
        System.out.println(clinic.getPatients());
    }
}
