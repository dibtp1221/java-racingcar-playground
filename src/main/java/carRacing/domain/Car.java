package carRacing.domain;

public class Car {
    private static final int STANDARD = 4;
    private final String name;
    private int location = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void drive() {
        if (getRand() >= STANDARD) {
            location++;
        }
    }

    private int getRand() {
        return (int) (Math.random() * 8) + 1;
    }
}
