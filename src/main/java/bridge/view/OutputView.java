package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.PassingPositions;
import bridge.domain.Result;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START = " [ ";
    private static final String END = " ] ";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String TOTAL_ATTEMPT = "총 시도한 횟수: ";

    private static final String ERROR_PREFIX = "[ERROR] ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static List<String> printMap(Result result) {
        List<String> compares = result.makeCompares();
        List<List<String>> resultsGroup = result.getResultsGroup();

        for (List<String> results : resultsGroup) {
            System.out.print(START);
            for (String res : results) {
                System.out.print(res);
            }
            System.out.println(END);
        }
        System.out.println();
        return compares;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Result result, int attempt) {
        List<String> compares = result.makeCompares();

        System.out.println(FINAL_RESULT);
        printMap(result);

        System.out.print(GAME_SUCCESS_OR_NOT);
        if (compares.contains("X")) {
            System.out.println(FAIL);
        }
        if (!compares.contains("X")) {
            System.out.println(SUCCESS);
        }

        System.out.print(TOTAL_ATTEMPT);
        System.out.println(attempt);

    }

    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
