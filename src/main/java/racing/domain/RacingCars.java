package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {
    private final ArrayList<Car> cars;
    private final MovingStrategy movingStrategy;

    public RacingCars(MovingStrategy movingStrategy, Car... args) {
        this.movingStrategy = movingStrategy;
        cars = new ArrayList<>(Arrays.asList(args));
    }

    public RacingCars(MovingStrategy movingStrategy, List<Car> cars) {
        this.movingStrategy = movingStrategy;
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getFirstCars() {
        cars.sort((c1, c2) -> c1.getPosition().compareTo(c2.getPosition()));

        List<Car> result = new ArrayList<>();
        Position max = cars.get(0).getPosition();
        for (int idx = 0; idx < cars.size() && cars.get(idx).getPosition().equals(max); idx++) {
            result.add(cars.get(idx));
        }
        return result;
    }

    public String getFirstWinnersNames() {
        List<Car> firstCars = getFirstCars();
        List<String> names = firstCars.stream().map(car -> car.getName().toString()).collect(Collectors.toList());
        return String.join(", ", names);
    }

    public void move() {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public void print() {
        cars.forEach(System.out::println);
    }
}
