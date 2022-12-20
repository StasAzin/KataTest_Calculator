import java.util.Scanner;

public class Main {
    public static String calc(String input) throws Exception {
        String[] rimskie = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] args = input.split(" ");

        if (args.length > 3) {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (args.length < 3) {
            throw new Exception("т.к. строка не является математической операцией");
        }

        int first = 0;
        int second = 0;
        int rim = 0;
        int param1 = 0;
        try {
            first = Integer.parseInt(args[0]);
            param1 = 1;
            second = Integer.parseInt(args[2]);
        } catch (Exception e) {
            try {
                Integer.parseInt(args[2]);
                throw new Exception("т.к. используются одновременно разные системы счисления");
            } catch (Exception ee) {
            }
            if (param1 == 1) {
                throw new Exception("т.к. используются одновременно разные системы счисления");
            }
            rim = 1;
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < 10; i++) {
                    if (j == 0) {
                        if (args[0].equals(rimskie[i])) {
                            first = i + 1;
                        }
                    } else {
                        if (args[2].equals(rimskie[i])) {
                            second = i + 1;
                        }
                    }
                }
            }
            if (first < second & args[1].equals("/")) {
                throw new Exception();
            } else if (first <= second & args[1].equals("-")) {
                throw new Exception("т.к. в римской системе нет отрицательных чисел");
            }
        }
        if (first == 0 | second == 0) {
            throw new Exception("т.к. введенные числа должны быть арабские или римские");
        }
        if (first < 1 | first > 10 | second < 1 | second > 10) {
            throw new Exception("т.к. числа должны быть в диапазоне от 1 до 10 включительно");
        }
        Integer result = 0;

        if (args[1].equals("+")) {
            result = first + second;
        } else if (args[1].equals("-")) {
            result = first - second;
        } else if (args[1].equals("*")) {
            result = first * second;
        } else if (args[1].equals("/")) {
            result = first / second;
        }
        if (rim == 1) {
            int result2 = result;
            String sl = "";
            if (result >= 10) {
                int desatok = result / 10;
                result2 -= desatok * 10;

                if (desatok == 1) {
                    sl += "X";
                } else if (desatok == 2) {
                    sl += "XX";
                } else if (desatok == 3) {
                    sl += "XXX";
                } else if (desatok == 4) {
                    sl += "XL";
                } else if (desatok == 5) {
                    sl += "L";
                } else if (desatok == 6) {
                    sl += "LX";
                } else if (desatok == 7) {
                    sl += "LXX";
                } else if (desatok == 8) {
                    sl += "LXXX";
                } else if (desatok == 9) {
                    sl += "XC";
                } else if (desatok == 10) {
                    sl += "C";
                }
            }
            if (result2 != 0) sl += rimskie[result2 - 1];
            return sl;
        } else {
            return (result.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
}
