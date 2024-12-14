import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class Menu {
    private static int size=0;
    private static double numb;
    private static taskArray newArray = new taskArray(size);

    public static int readNum(){
        Scanner scanner = new Scanner(System.in);
        int readed;
        try {
            readed = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.print("Пожалуйста, вводите только целочисленное число. Введите число заново: ");
            readed = readNum();
        }
        return readed;
    }

    private static double readDoubleNum(){
        Scanner scanner = new Scanner(System.in);
        double readed;
        try {
            readed = Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.print("Похоже, вы ввели не число или его неправильный формат. Введите число заново: ");
            readed = readDoubleNum();
        }
        return readed;
    }

    private static void mainMenu() {
        System.out.println("====Главное меню====");
        System.out.println("Для работы с массивом введите (1)");
        System.out.println("Для работы с числом введите (2)");
        System.out.println("Для выхода введите (0)");
    }

    public static void printMenu() throws IOException {
        boolean runMain = true;
        int choice;
        while (runMain) {
            mainMenu();
            System.out.print("Введите команду: ");
            choice = readNum();
            switch (choice) {
                case 1:
                    printArrayMenu();
                    break;
                case 2:
                    printNumberMenu();
                    break;
                case 0:
                    runMain = false;
                    System.out.println("Вы вышли из программы.");
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
        int g=0;
        boolean runArray = true;
        int choice;
        while (runArray) {
                arrayMenu();
                System.out.print("Введите команду: ");
                choice = readNum();
                switch (choice) {
                    case 1:
                        g+=1;
                        printArrayCinMenu();
                        break;
                    case 2:
                        if (checkArray(g)) {
                            System.out.print("Введите желаемое количество первых элементов, которые вы хотите вывести на экран: ");
                            int firstElements = readNum();
                            taskArray.printFirstNumbers(firstElements);
                        }
                        break;
                    case 3:
                        if (checkArray(g)){
                            taskArray.printMiddle(size);
                        }
                        break;
                    case 4:
                        if (checkArray(g)){
                            FileReaderFromTxt.writeArrayToFile();
                        }
                        break;
                    case 5:
                        if (checkArray(g)){
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
        System.out.println("Для выхода в меню работы с массивом введите (0)");
    }

    private static void printArrayCinMenu() throws IOException {
        int g=0;
        boolean runCinArray = true;
        while (runCinArray) {
                arrayCinMenu();
                System.out.print("Введите команду: ");
                int choice = readNum();
                switch (choice) {
                    case 1:
                        System.out.print("Введите желаемый размер массива: ");
                        size = readNum();
                        taskArray.printNumbers(choice, 0, 0, size);
                        break;
                    case 2:
                        try {
                            List<Integer> Array = FileReaderFromTxt.FileReadingArray(g);
                            size = Array.size();
                            taskArray newArray = new taskArray(size);
                            System.out.println("Массив из файла:");
                            for (int i = 0; i < Array.size(); i++) {
                                taskArray.set(i, Array.get(i));
                            }
                        } catch (IOException e) {
                            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
                        } catch (NumberFormatException e) {
                            System.err.println("Ошибка: Некорректный формат данных в файле.");
                        }
                        break;
                    case 3:
                        System.out.print("Введите желаемый размер массива: ");
                        size = readNum();
                        taskArray.printNumbers(choice, 0, 0, size);
                        break;
                    case 4:
                        System.out.print("Введите желаемый размер массива: ");
                        size = readNum();
                        System.out.print("Введите минимальное число, которое будет содержаться в массиве: ");
                        int minNum = readNum();
                        System.out.print("Введите максимальное число, которое будет содержаться в массиве: ");
                        int maxNum = readNum();
                        taskArray.printNumbers(choice, minNum, maxNum, size);
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
        int i = 0;
        boolean runNum = true;
        while (runNum) {
                NumberMenu();
                System.out.print("Введите команду: ");
                int choice = readNum();
                switch (choice) {
                    case 1:
                        i+=1;
                        System.out.print("Введите число, которое хотите записать словами (разделитель '.'): ");
                        numb = readDoubleNum();
                        try {
                            numberWord.findNumber(numb);
                        }catch(ArrayIndexOutOfBoundsException e)
                        {
                            System.out.println("Ошибка: Вы ввели отрицательное число.");
                        }
                        break;
                    case 2:
                        i+=1;
                        numb=FileReaderFromTxt.FileReadingNum(i);
                        numberWord.findNumber(numb);
                        break;
                    case 3:
                        if (checkNum(i)){
                            numberWord.writeNumber(numb);
                        }
                        break;
                    case 4:
                        if (checkNum(i)) {
                            FileReaderFromTxt.writeNumberToFile(numb);
                        }
                        break;
                    case 5:
                        if (checkNum(i)) {
                            FileReaderFromTxt.writeNumberToBinaryFile(numb);
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

    private static boolean checkNum(int i) {
        if (i<1) {
            System.out.println("Сначала введите число (пункт 1) или (пункт 2)");
            return false;
        }
        return true;
    }

    private static boolean checkArray(int g) {
        if (g<1) {
            System.out.println("Сначала создайте и заполните массив (пункт 1)");
            return false;
        }
        return true;
    }
}