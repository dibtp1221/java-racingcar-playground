package calculator;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_START = "//";
    private static final String CUSTOM_END = "\n";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = getDelimiter(input);
        input = parseInput(input);

        return addString(input, delimiter);
    }

    private static String getDelimiter(String input) {
        if (!input.startsWith(CUSTOM_START)) {
            return DEFAULT_DELIMITER;
        }

        int idx = input.indexOf(CUSTOM_END);
        if (idx < 0) {
            throw new RuntimeException();
        }
        return input.substring(CUSTOM_START.length(), idx);
    }

    private static String parseInput(String input) {
        if (!input.startsWith(CUSTOM_START)) {
            return input;
        }

        return input.substring(input.indexOf(CUSTOM_END) + 1);
    }

    private static int addString(String input, String delimiter) {
        int result = 0;
        String[] splitted = input.split(delimiter);
        for (String numStr : splitted) {
            int num = validateNum(numStr);
            result += num;
        }
        return result;
    }

    private static int validateNum(String numStr) {
        int num = Integer.parseInt(numStr);
        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }
}
