package racing.domain;

import java.util.*;

public class RacingCars {
    private final ArrayList<Car> cars;

    public RacingCars(Car... args) {
        cars = new ArrayList<>(Arrays.asList(args));
    }

    public List<Car> getFirstCars() {
        cars.sort((c1, c2) -> c1.getPosition().compareTo(c2.getPosition()));

        List<Car> result = new ArrayList<>();
        Position max = cars.get(0).getPosition();
        result.add(cars.get(0));
        int idx = 1;
        while (cars.get(idx).getPosition().equals(max)) {
            result.add(cars.get(idx));
            idx++;
        }
        return result;
    }
}
