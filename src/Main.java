import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(calc(s));
    }
    public static String calc(String input) {
        char[] chars = input.toCharArray();

        if (chars.length > 7 || chars.length < 5 || (chars[1] != '0' && chars[1] != ' ')) {
            try {
                throw new IOException();
            } catch (IOException e) {
                return "Неверный формат данных";
            }
        }

        int a;
        int sd = 0;

        if (chars[0] == '1' && chars[1] == '0') {
            a = 10;
            sd++;
        } else a = Character.getNumericValue(chars[0]);

        char oper = chars[2 + sd];

        if (chars[1 + sd] != ' ' || (oper != '+' && oper != '-' &&
                oper != '/' && oper != '*') || chars[3 + sd] != ' ')
            try {
                throw new IOException();
            } catch (IOException e) {
                return "Неверный формат данных";
            }

        if ((chars.length == 7 && (chars[6] != '0' || chars[5] != '1')) || (a != 10 &&
                chars.length == 6 && (chars[5] != '0' || chars[4] != '1')) ||
                (chars.length == 7 && a != 10))
            try {
                throw new IOException();
            } catch (IOException e) {
                return "Неверный формат данных";
            }

        int b;

        if (chars.length == 7 || chars.length == 6 && a != 10) b = 10;
        else b = Character.getNumericValue(chars[4 + sd]);

        if ((a < 1 || a > 10) || (b < 1 || b > 10))
            try {
                throw new IOException();
            } catch (IOException e) {
                return "Неверный формат данных";
            }

        int res = 0;

        if (oper == '+') res = a + b;
        if (oper == '-') res = a - b;
        if (oper == '*') res = a * b;
        if (oper == '/') res = a / b;

        return Integer.toString(res);
    }
}
