package carRacing;

import carRacing.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private static final int NAME_MAX_LEN = 5;

    public String[] parseNames(String input) {
        String[] splitted = input.split(",");
        Arrays.stream(splitted).forEach(this::validateName);
        return splitted;
    }

    private void validateName(String name) {
        if (name.length() > NAME_MAX_LEN) {
            throw new RuntimeException();
        }
    }

    public List<Car> makeCars(String[] names) {
        return Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }
}
