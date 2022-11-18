package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private static final int DISTANCE_INDEX = 0;
    private static final int DIRECTION_INDEX = 1; // up or down
    private static final int UP = 1;
    private static final int DOWN = 0;

    private final List<Integer> position = new ArrayList<>();

    public Position(int pos, String answer) {
        position.add(pos);
        position.add(getAnswer(answer));
    }

    private Integer getAnswer(String answer) {
        if (answer.equals("U")) {
            return UP;
        }
        return DOWN;
    }

    public String getDirection() { // TODO: getter 사용 자제... 메시지를 보내기
        int direction = position.get(DIRECTION_INDEX);
        if (direction == UP) {
            return "U";
        }
        return "D";
    }

    public int getDistance() { // TODO: getter 사용 자제... 메시지를 보내기
        return position.get(DISTANCE_INDEX);
    }
}
