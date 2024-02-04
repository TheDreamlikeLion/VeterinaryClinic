# VeterinaryClinic
Java OOP


## Задание:
1. Создать класс Doctor и подумать над его состоянием и поведением.
2. Создать класс Nurse(медсестра) и подумать над его состоянием и поведением.
3. Создайте интерфейсы Goable, Flyable, Swimable. У интерфейсов должны быть методы получения скорости заданного действия: double run(), double fly(), double swim()
4. Добавьте наследников этим интерфейсам, но таким образом, чтобы у каждого интерфейса было минимум по два наследника (при необходимости, добавьте в приложение новые классы)
5. Создать класс ВетеринарнаяКлиника (VeterinaryClinic)
6. У ветеринарной клиники добавьте методы получения всех бегающих, всех плавающих и всех летающих, а также методы для работы с персоналом клиники.

## Решение:
## 1-2.
Создаем абстрактный класс Пероснал:

## Класс Personal:
package Clinic;
import java.time.LocalDate;
import java.util.List;

public abstract class Personal {
    protected String position;
    protected String fio;
    protected LocalDate birthDay;

    public Personal (String position, String fio, LocalDate birthDay) {
        this.position = position;
        this.fio = fio;
        this.birthDay = birthDay;
    }
    public Personal (String fio) {
        this.position = "Стажер";
        this.fio = fio;
        this.birthDay = null;
    }
    @Override
    public String toString() {return String.format("position: %s; full name: %s; birthday: %s \n", position, fio, birthDay);}
}

## Его наследуют классы Доктор и Медсестра;
Они отличаются состоянием (поле "position") и поведением (метод curePatient у врача и checkPatient у медсестры).

## Класс Doctor:
package Clinic;
import java.time.LocalDate;

public class Doctor extends Personal {
    public Doctor(String fio, LocalDate birthDay) {
        super("Doctor", fio, birthDay);
    }
    public Doctor(String fio) {
        super("Doctor", fio, null);
    }
    public void curePatient (Animal animal) {
        System.out.println("Доктор излечил зверушку. Слава докторам!");
        animal.setIllness(null);
    }
}

## Класс Nurse:
package Clinic;
import java.time.LocalDate;

public class Nurse extends Personal{
    public Nurse (String fio, LocalDate birthDay) {
        super("Nurse", fio, birthDay);
    }
    public Nurse (String fio) {
        super("Nurse", fio, null);
    }
    public void checkPatient (Animal animal) {
        System.out.println(animal);
        if (animal.getIllness() != null) {
            System.out.println("Бедная зверушка. Доктор должен посмотреть.\n");
        } else {
          System.out.println("Зверушка здорова. Надо выписывать!\n");
        }
    }
}

## 3.
Созданы интерфейсы. Например, Flyable:

## Итнерфейс Flyable:
package Clinic;

public interface Flyable {
double speed = 20;
    default double toFly() {
        System.out.println("Летит со скоростью " + speed);
        return speed;
    }
}

## 4.
Созданные интерфейсы применяются созданными классами животных.
Например:

## Класс Duck:
package Clinic;

import java.time.LocalDate;

public class Duck extends Bird implements Goable, Swimable, Flyable {
    public Duck() {super();}
...
}

## 5-6.
##  Создан класс VeterinaryClinic:
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

// Поиск по интерфейсам:
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

### Проблема:
В созданной реализации есть решаемая проблема с наследованием класса Bird. Класс Ostrich, являясь наследником класса Bird, сам не применяет интерфейс Flyable.
Но за счет наследования от Bird данный класс попадает в выборку интерфейса Flyable.
### Решение проблемы:
Лучшим решением проблемы станет переделка иерархии классов, чтобы экземпляры конечных классов были на одном уровне наследования. А все классы выше необходимо будет сделать абстрактными. Интерфейсам будут следовать только конечные классы, что снимет проблему с неправильным наследованием.
