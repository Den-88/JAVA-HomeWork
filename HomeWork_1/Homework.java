import java.util.Arrays;
import java.util.Random;

public class Homework {

    public static void main(String[] args) {
        System.out.println(isSumBetween10And20(5, 10)); // true
        System.out.println(isSumBetween10And20(5, 15)); // true
        System.out.println(isSumBetween10And20(7, 15)); // false
        System.out.println(isSumBetween10And20(2, 6)); // false
        System.out.println();

        System.out.println(isPositive(5)); // true
        System.out.println(isPositive(0)); // false
        System.out.println(isPositive(-3)); // false
        System.out.println();

        printString("abcd", 5); // abcdabcdabcdabcdabcd
        System.out.println('\n');

        System.out.println(isLeapYear(2000)); // true
        System.out.println(isLeapYear(1900)); // false
        System.out.println(isLeapYear(2008)); // true
        System.out.println(isLeapYear(2005)); // false
        System.out.println();

        int[] arr = createArray(5, 10);
        System.out.println(Arrays.toString(arr)); // [10, 10, 10, 10, 10]
        System.out.println();

        int[] arr2 = revArray();
        System.out.println(Arrays.toString(arr2)); // [0, 0, 1, 1, 0, 1, 0, 0, 1, 1]
        System.out.println();

        int[] arr3 = mulArray();
        System.out.println(Arrays.toString(arr3)); // [2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2]
        System.out.println();

        int size = 7;
        int[][] arr4 = genArray(size);
        System.out.println("Создан рандомный квадратный двумерный массив:");
        printArray(arr4);
        System.out.println("Диагонали заменены единицами:");
        printArray(diagArray(arr4));
    }

    /**
     * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть
     * true, в противном случае – false.
     */

    private static boolean isSumBetween10And20(int a, int b) {
        // проверить, что сумма a и b лежит между 10 и 20
        if (10 <= a + b && a + b <= 20)
            return true;
        return false;
    }

    private static boolean isPositive(int x) {
        // проверить, что х положительное
        if (x > 0)
            return true;
        return false;
    }

    private static void printString(String source, int repeat) {
        // напечатать строку source repeat раз
        for (int i = 0; i < repeat; i++) {
            System.out.print(source);
        }
    }

    private static boolean isLeapYear(int year) {
        // проверить, является ли год високосным. если да - return true
        // год является високосным, если он делится на 4, но не делится на 100, но
        // делится на 400
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return true;
        return false;
    }

    private static int[] createArray(int len, int initialValue) {
        // должен вернуть массив длины len, каждое значение которого равно initialValue
        int[] gen_arr = new int[len];
        for (int i = 0; i < len; i++) {
            gen_arr[i] = initialValue;
        }
        return gen_arr;
    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия
    // заменить 0 на 1, 1 на 0;
    
    private static int[] revArray() {
        int[] my_arr = new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < my_arr.length; i++) {
            if (my_arr[i] == 0)
                my_arr[i] = 1;
            else
                my_arr[i] = 0;
        }
        return my_arr;
    }

    // 2. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему
    // циклом, и числа меньшие 6 умножить на 2;

    private static int[] mulArray() {
        int[] my_arr = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < my_arr.length; i++) {
            if (my_arr[i] < 6)
                my_arr[i] *= 2;
        }
        return my_arr;
    }

    // 3. Создать квадратный двумерный целочисленный массив (количество строк и
    // столбцов одинаковое),
    // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно
    // только одну из диагоналей, если обе сложно).
    // Определить элементы одной из диагоналей можно по следующему принципу: индексы
    // таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    // * Также заполнить элементы побочной диагонали

    private static int[][] genArray(int size) {
        Random random = new Random();
        int[][] gen_arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gen_arr[i][j] = random.nextInt(10);
            }
        }
        return gen_arr;
    }

    private static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] diagArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - 1 - i] = 1;
        }
        return arr;
    }

    // 4. Подготовить вопросы к следующему уроку.
}
