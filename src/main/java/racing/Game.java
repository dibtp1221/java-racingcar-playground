package racing;

import racing.domain.Car;
import racing.domain.RacingCars;
import racing.domain.RandomMovingStrategy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    public void play() {
        RacingCars racingCars = makeCars();

        int trial = askTrial();

        play(racingCars, trial);

        showResult(racingCars);
    }

    private RacingCars makeCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();

        String[] nameArr = names.split(",");
        return new RacingCars(new RandomMovingStrategy(),
                Arrays.stream(nameArr).map(name -> new Car(name, 0)).collect(Collectors.toList()));
    }

    private int askTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    private void play(RacingCars racingCars, int trial) {
        System.out.println("실행 결과");
        for (int i = 1; i < trial; i++) {
            turn(racingCars);
        }
    }

    private void turn(RacingCars racingCars) {
        racingCars.move();
        racingCars.print();
        System.out.println();
    }

    private void showResult(RacingCars racingCars) {
        System.out.println(racingCars.getFirstWinnersNames() + "가 최종 우승했습니다.");
    }
}
