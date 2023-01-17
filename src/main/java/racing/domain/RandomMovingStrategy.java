package racing.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    @Override
    public boolean canMove() {
        Random random = new Random();
        int rand = random.nextInt(10);
        return rand >= 4;
    }
}
