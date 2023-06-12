
/**
 * Пусть дан произвольный список целых чисел.
 *
 * 1) Нужно удалить из него чётные числа (void removeEven(ArrayList<Integer>
 * list))
 * 2) Найти минимальное значение (Integer findMin(ArrayList<Integer> list))
 * 3) Найти максимальное значение
 * 4) Найти среднее значение
 *
 * То есть, нужно реализовать 4 метода, каждый из которых принимает список целых
 * чисел, и делает свою работу.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Homework {
    public static void main(String[] args) {
        ArrayList<Integer> list = genArray(10);
        System.out.println("Сгенерирован список целых чисел:\n" + list);
        removeEven(list);
        System.out.println("Удалены четные числа:\n" + list);
        System.out.println("Минимальное значение: " + findMin(list));
        System.out.println("Максимальное значение: " + findMax(list));
        System.out.println("Среднее значение: " + findAve(list));
    }

    private static ArrayList<Integer> genArray(int lenght) {
        ArrayList<Integer> newList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < lenght; i++) {
            newList.add(random.nextInt(10));
        }
        return newList;
    }

    private static void removeEven(ArrayList<Integer> list) {
        list.removeIf(next -> next % 2 == 0);
    }

    private static Integer findMin(ArrayList<Integer> list) {
        return Collections.min(list);
    }

    private static Integer findMax(ArrayList<Integer> list) {
        return Collections.max(list);
    }

    private static Double findAve(ArrayList<Integer> list) {
        double sum = 0;
        for (Integer next : list) {
            sum += next;
        }
        return sum / list.size();
    }
}