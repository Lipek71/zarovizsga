package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    public Beagle(String name) {
        super(name);
    }

    @Override
    void feed() {
        happiness += 2;
    }

    @Override
    void play(int hours) {
        happiness += 2 * hours;
    }
}
