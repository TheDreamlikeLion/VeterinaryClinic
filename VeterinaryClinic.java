package Clinic;

import java.util.ArrayList;
import java.util.List;

public class VeterinaryClinic {
    private List<Personal> personal;
    private List<Animal> patients;

    public VeterinaryClinic() {
        this.personal = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public List<Animal> getPatients() {
        return patients;
    }

    public List<Personal> getPersonal() {
        return personal;
    }

    public void addPatient(Animal animal) {
        patients.add(animal);
    }

    public void addPersonal(Personal person) {
        personal.add(person);
    }

    public void removePatient(Animal animal) {
        patients.remove(animal);
        System.out.println("Пациент выписан.");
    }

    public List<Animal> filterGoable() {
        List<Animal> goables = new ArrayList<>();
        for (Animal animal : patients) {
            if (animal instanceof Goable) {
                goables.add(animal);
            }
        }
        return goables;
    }

    public List<Animal> filterFlyable() {
        List<Animal> flyables = new ArrayList<>();
        for (Animal animal : patients) {
            if (animal instanceof Flyable) {
                flyables.add(animal);
            }
        }
        return flyables;
    }

    public List<Animal> filterSwimable() {
        List<Animal> swimables = new ArrayList<>();
        for (Animal animal : patients) {
            if (animal instanceof Swimable) {
                swimables.add(animal);
            }
        }
        return swimables;
    }
}