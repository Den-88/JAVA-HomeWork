import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Реализовать консольное приложение - телефонный справочник.
 * У одной фамилии может быть несколько номеров.
 * Пользователь может вводить команды:
 * 1. ADD Ivanov 88005553535 - добавить в справочник новое значение. Первый
 * аргумент - фамилия, второй - номер телефона
 * 2. GET Ivanov - получить список всех номеров по фамилии
 * 3. REMOVE Ivanov - удалить все номера по фамилии
 * 4. LIST - Посмотреть все записи
 * 5. EXIT - Завершить программу
 * Если при GET или REMOVE нужной фамилии нет, вывести информацию об этом
 *
 * Пример взаимодействия (=> - это вывод на консоль):
 * ADD Ivanov 8 800 555 35 35
 * ADD Ivanov 8 800 100 10 10
 * GET Ivanov => [8 800 555 35 35, 8 800 100 10 10]
 * ADD Petrov 8 555 12 34
 * LIST => Ivanov = [8 800 5553535, 8 800 100 10 10], Petrov = [8 555 12 34]
 * REMOVE Ivanov
 * LIST => Petrov = [8 555 12 34]
 * GET NoName => Не найдена запись с фамилией "NoName"
 * REMOVE NoName => Не найдена запись с фамилией "NoName"
 */

public class Homework {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<String>> subs = new HashMap<>();
        while (true) {
            String input = scanner.nextLine();
            String[] command = input.split(" ");
            if (command[0].toUpperCase().equals("ADD")) {
                addSub(subs, input);
            } else if (command[0].toUpperCase().equals("GET")) {
                getSub(subs, command);
            } else if (command[0].toUpperCase().equals("REMOVE")) {
                removeSub(subs, command);
            } else if (command[0].toUpperCase().equals("LIST")) {
                listSub(subs);
            } else if (command[0].toUpperCase().equals("EXIT")) {
                System.exit(0);
            } else {
                printError();
            }
        }
    }

    private static void addSub(HashMap<String, List<String>> subsMap, String inputCommands) {
        String[] commands = inputCommands.split(" ");
        if (commands.length > 2) {
            String phone = inputCommands.substring(5 + commands[1].length());
            if (subsMap.containsKey(commands[1])) {
                List<String> phones = subsMap.get(commands[1]);
                phones.add(phone);
                subsMap.put(commands[1], phones);
            } else {
                subsMap.put(commands[1], new ArrayList<>(Arrays.asList(phone)));
            }
        } else {
            printError();
        }
    }

    private static void getSub(HashMap<String, List<String>> subsMap, String[] commands) {
        if (commands.length == 2) {
            if (subsMap.containsKey(commands[1])) {
                System.out.println(subsMap.get(commands[1]));
            } else {
                printNotFound(commands[1]);
            }
        } else {
            printError();
        }
    }

    private static void removeSub(HashMap<String, List<String>> subsMap, String[] commands) {
        if (commands.length == 2) {
            if (subsMap.containsKey(commands[1])) {
                subsMap.remove(commands[1]);
            } else {
                printNotFound(commands[1]);
            }
        } else {
            printError();
        }
    }

    private static void listSub(HashMap<String, List<String>> subsMap) {
        System.out.println(subsMap);
    }

    private static void printError() {
        System.out.println("Команда введена неверно! Повторите ввод");
    }

    private static void printNotFound(String surname) {
        System.out.println("Не найдена запись с фамилией \"" + surname + "\"");
    }
}
