package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {
    private String name;
    private int happiness = 0;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    abstract void feed();
    abstract void play(int hours);
}
