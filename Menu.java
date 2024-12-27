package ui;

import domain.NumberWord;
import domain.TaskArray;
import io.FileReaderFromTxt;

import java.io.IOException;
import java.util.List;

public class Menu {
    private static int size;
    private static double numb;
    private static NumberWord number;
    private static TaskArray newArray;
    private static int choice;
    private static void mainMenu() {
        System.out.println("====Главное меню====");
        System.out.println("Для работы с массивом введите (1)");
        System.out.println("Для работы с числом введите (2)");
        System.out.println("Для выхода введите (0)");
    }

    public static void printMenu() throws IOException {
        boolean runMain = true;
        while (runMain) {
            mainMenu();
            System.out.print("Введите команду: ");
            choice = ReadNum.readIntNum();
            switch (choice) {
                case 1:
                    printArrayMenu();
                    break;
                case 2:
                    printNumberMenu();
                    break;
                case 0:
                    runMain = false;
                    System.out.print("Вы вышли из программы.");
                    break;
                default:
                    System.out.println("Команды с таким номером нет. Введите команду заново.");
            }
        }
    }

    private static void arrayMenu() {
        System.out.println("====Меню работы с массивом====");
        System.out.println("Для создания массива введите (1)");
        System.out.println("Для вывода первых членов массива на экран введите (2)");
        System.out.println("Для нахождения среднего значения всех элементов массива введите (3)");
        System.out.println("Для записи массива в файл введите (4)");
        System.out.println("Для записи массива в бинарный файл введите (5)");
        System.out.println("Для возвращения в главное меню введите (0)");
    }

    private static void printArrayMenu() throws IOException {
        boolean runArray = true;
        int firstElements;
        while (runArray) {
            arrayMenu();
            System.out.print("Введите команду: ");
            choice = ReadNum.readIntNum();
            switch (choice) {
                case 1:
                    printArrayCinMenu();
                    break;
                case 2:
                    if (Menu.checkArray()) {
                        System.out.print("Введите желаемое количество первых элементов, которые вы хотите вывести на экран: ");
                        firstElements = ReadNum.readIntNum();
                        newArray.printFirstNumbers(firstElements);
                    }
                    break;
                case 3:
                    if (Menu.checkArray()) {
                        newArray.printMiddle();
                    }
                    break;
                case 4:
                    if (Menu.checkArray()) {
                        FileReaderFromTxt.writeArrayToFile(newArray, size);
                    }
                    break;
                case 5:
                    if (Menu.checkArray()) {
                        FileReaderFromTxt.writeArrayToBinaryFile(size, newArray);
                    }
                    break;
                case 0:
                    runArray = false;
                    System.out.println("===Вы вышли из меню работы с массивом===");
                    break;
                default:
                    System.out.println("Команды с таким номером нет. Введите команду заново.");
            }
        }
    }
    private static void arrayCinMenu() {
        System.out.println("====Меню работы с выбором заполнения массива====");
        System.out.println("Для ввода элементов массива вручную введите (1)");
        System.out.println("Для чтения массива из файла введите (2)");
        System.out.println("Для создания массива Фиббоначи введите (3)");
        System.out.println("Для заполнения массива рандомными числами введите (4)");
        System.out.println("Для вывода массива на экран введите (5)");
        System.out.println("Для выхода в меню работы с массивом введите (0)");
    }
    private static void printArrayCinMenu() throws IOException {
        boolean runCinArray = true;
        while (runCinArray) {
            arrayCinMenu();
            System.out.print("Введите команду: ");
            choice = ReadNum.readIntNum();
            switch (choice) {
                case 1:
                    System.out.print("Введите желаемый размер массива: ");
                    size = ReadNum.readIntNum();
                    int[] newArrayHeand = new int[size];
                    for (int i = 0; i < size; i++) {
                        System.out.print("Введите число: ");
                        newArrayHeand[i] = ReadNum.readIntNum();
                    }
                    newArray = new TaskArray (newArrayHeand);
                    break;
                case 2:
                    try {
                        List<Integer> Array = FileReaderFromTxt.FileReadingArray();
                        size = Array.size();
                        newArray = new TaskArray(size);
                        System.out.println("Массив из файла:");
                        for (int i = 0; i < Array.size(); i++) {
                            newArray.set(i, Array.get(i));
                        }
                    } catch (IOException e) {
                        System.err.println("Ошибка: ввода-вывода: " + e.getMessage());
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка: Некорректный формат данных в файле.");
                    }
                    break;
                case 3:
                    System.out.print("Введите желаемый размер массива: ");
                    size = ReadNum.readIntNum();
                    newArray = new TaskArray(size);
                    newArray.generateFibbonachi();
                    break;
                case 4:
                    System.out.print("Введите желаемый размер массива: ");
                    size = ReadNum.readIntNum();
                    newArray = new TaskArray(size);
                    System.out.print("Введите минимальное число, которое будет содержаться в массиве: ");
                    int minNum = ReadNum.readIntNum();
                    System.out.print("Введите максимальное число, которое будет содержаться в массиве: ");
                    int maxNum = ReadNum.readIntNum();
                    newArray.generateRandom(minNum, maxNum);
                    break;
                case 5:
                    System.out.println("Исходный массив чисел: ");
                    System.out.println(newArray.getArrayAsString());
                    break;
                case 0:
                    runCinArray = false;
                    break;
                default:
                    System.out.println("Команды с таким номером нет. Введите команду заново.");
            }
        }
    }

    private static void NumberMenu() {
        System.out.println("==== Меню работы с числом ====");
        System.out.println("Для ввода числа вручную введите (1)");
        System.out.println("Для считывания числа из файла введите (2)");
        System.out.println("Для вывода числа словами введите (3)");
        System.out.println("Для записи числа словами в файл введите (4)");
        System.out.println("Для записи числа словами в бинарный файл введите (5)");
        System.out.println("Для возвращения в главное меню введите (0)");
    }

    private static void printNumberMenu() {
        String numberInWords = "";
        boolean runNum = true;
        while (runNum) {
            NumberMenu();
            System.out.print("Введите команду: ");
            choice = ReadNum.readIntNum();
            switch (choice) {
                case 1:
                    System.out.print("Введите число, которое хотите записать словами (разделитель '.'): ");
                    numb = ReadNum.readDoubleNum();
                    number = new NumberWord(numb);
                    try {
                        numberInWords = number.findNumber();
                    }catch(ArrayIndexOutOfBoundsException e) {
                        System.out.println("Ошибка: Вы ввели отрицательное число.");
                    }
                    break;
                case 2:
                    numb = FileReaderFromTxt.FileReadingNum();
                    number = new NumberWord(numb);
                    numberInWords = number.findNumber();
                    break;
                case 3:
                    if (Menu.checkNumber()){
                        number.writeNumber();
                    }
                    break;
                case 4:
                    if (Menu.checkNumber()) {
                        FileReaderFromTxt.writeNumberToFile(numb, numberInWords);
                    }
                    break;
                case 5:
                    if (Menu.checkNumber()) {
                        FileReaderFromTxt.writeNumberToBinaryFile(numb, numberInWords);
                    }
                    break;
                case 0:
                    runNum = false;
                    break;
                default:
                    System.out.println("Команды с таким номером нет. Введите команду заново.");
            }
        }
    }

    private static boolean checkArray(){
        if (newArray == null) {
            System.out.println("Ошибка: Для работы с массивом надо его ввести: (пункт 1)");
            return false;
        }
        else return true;
    }

    private static boolean checkNumber(){
        if (number == null) {
            System.out.println("Ошибка: Для работы с числом надо его ввести: (пункт 1) или (пункт 2)");
            return false;
        }
        else return true;
    }
}