package carRacing;

import carRacing.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {

    private static final int NAME_MAX_LEN = 5;
    List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] names = parseNames(input);
        Game game = new Game(makeCars(names));

        System.out.println("시도할 회수는 몇회인가요?");
        int count = scanner.nextInt();

        System.out.println("실행 결과");
        for (int i=0; i<count; i++) {
            game.driveAndPrintCars();
        }

        System.out.println(game.getWinnerNames() + "가 최종 우승했습니다.");
    }

    public static String[] parseNames(String input) {
        String[] splitted = input.split(",");
        Arrays.stream(splitted).forEach(Game::validateName);
        return splitted;
    }

    private static void validateName(String name) {
        if (name.length() > NAME_MAX_LEN) {
            throw new RuntimeException();
        }
    }

    public static List<Car> makeCars(String[] names) {
        return Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getWinner() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getLocation());
        }

        int finalMax = max;
        return cars.stream().filter(car -> car.getLocation() == finalMax).collect(Collectors.toList());
    }

    public String getWinnerNames() {
        List<Car> winner = getWinner();
        return winner.stream().map(Car::getName).collect(Collectors.joining(","));
    }

    private void driveAndPrintCars() {
        for (Car car : cars) {
            car.drive();
            System.out.println(car.getStatMsg());
        }
        System.out.println();
    }
}
