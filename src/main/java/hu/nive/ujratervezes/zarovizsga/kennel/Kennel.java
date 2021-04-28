package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    private final List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog : dogs) {
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        Dog foundDog = null;
        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(name)) {
                foundDog = dog;
            }
        }
        if (foundDog == null) {
            throw new IllegalArgumentException("Can't find dog with this name.");
        }

        return foundDog;
    }

    public void playWith(String name, int hours) {
        //for (Dog dog : dogs) {
            //if (dog.getName().equalsIgnoreCase(name)) {
            //    dog.play(hours);
            //}
        //}
        if (findByName(name) != null){
            findByName(name).play(hours);
        }
    }

    public List<String> getHappyDogNames(int minHapiness) {
        List<String> happyDogNames = new ArrayList<>();

        for (Dog dog : dogs){
            if(dog.getHappiness() >= minHapiness){
                happyDogNames.add(dog.getName());
            }
        }

            return happyDogNames;
    }
}
