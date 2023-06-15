/*
 * Реализовать консольное приложение, которое:
 * 1. Принимает от пользователя и “запоминает” строки.
 * 2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
 * 3. Если введено revert, удаляет предыдущую введенную строку из памяти.
 * 4. Если введено exit, то программа завершается
 *
 *
 *
 * > - ввод в консоль (stdin), < - вывод на консоль (stdout)
 * > java
 * > python
 * > c#
 * > print
 * < [c#, python, java]
 * > revert
 * > print
 * < [python, java]
 * > revert
 * > revert
 * > print
 * < []
 * > revert -> throw new NoSuchElementException
 */

import java.util.Scanner;
import java.util.Stack;

public class HomeWork {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Stack<String> myStack = new Stack<>();
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("print")) {
                Stack<String> temp = new Stack<>();
                temp.addAll(myStack);
                System.out.print("[");
                while (!myStack.isEmpty()) {
                    System.out.print(myStack.pop());
                    if (!myStack.isEmpty()) {
                        System.out.print(", ");
                    }
                }
                myStack.addAll(temp);
                System.out.println("]");
            } else if (command.equals("revert")) {
                myStack.pop();
            } else if (command.equals("exit")) {
                System.exit(0);
            } else {
                myStack.push(command);
            }
        }

    }

}
