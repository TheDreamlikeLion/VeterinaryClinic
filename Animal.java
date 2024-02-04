package Clinic;

import java.time.LocalDate;

public abstract class Animal {
    protected String name;
    protected LocalDate birthDay;
    protected Illness illness;
    protected String ownerName;

    public Animal(String name, LocalDate birthDay, Illness illness, String ownerName){
        this.name = name; 
        this.birthDay = birthDay;
        this.illness = illness;
        this.ownerName = ownerName;
    }

    public Animal(String name, LocalDate birthDay, Illness illness){
        this.name = name;
        this.birthDay = birthDay;
        this.illness = illness;
        this.ownerName = "ничей";
    }

    public Animal(String name){
        this.name = name;
        this.birthDay = LocalDate.now();
        this.illness = new Illness("Чумка");
        this.ownerName = null;
    }

    public Animal(){
        this("Вася", LocalDate.now(), new Illness("Болезнь"), "Ничей");
    }

//    public Animal(String name){
//        this(name, LocalDate.now(), new Illness("Болезнь"), "Ничей");
//    }

    public double toGo() {
        System.out.println(getType() + " может ходить");
        return 10.0;
    }

    public double toFly() {
        System.out.println(getType() + " может летать");
        return 15.0;
    }

    public double toSwim() {
        System.out.println(getType() + " может плавать");
        return 15.0;
    }
    
    private void wakeUp(){
        System.out.println(getType() + " проснулся");
    }

    private void wakeUp(String time){
        System.out.println(getType() + " проснулся в " + time);
    }

    private void hunt(){
        System.out.println(getType() + " охотится");
    }

    private void eat(){
        System.out.println(getType() + " кушает");
    }
    
    private void slip(){
        System.out.println(getType() + " спит");
    }

    public void lifeCycle(){
        wakeUp();
        hunt();
        eat();
        slip();
    }

    public void setIllness(Illness illness){
        this.illness = illness;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
    public LocalDate getBirthDay() {
        return birthDay;
    }

    public Illness getIllness() {
        return illness;
    }
    
    public String getType(){
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return String.format("Кличка: %s, Дата рождения: %s, Хозяин: %s, Болезни: %s \n", name, birthDay, ownerName, illness);
    }
}