package ui;

import java.util.Scanner;

public class ReadNum {
    public static int readIntNum(){
        Scanner scanner = new Scanner(System.in);
        int readed;
        try {
            readed = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.print("Ошибка: Похоже, вы ввели не число или его неправильный формат. Введите число заново: ");
            readed = readIntNum();
        }
        return readed;
    }

    public static double readDoubleNum(){
        Scanner scanner = new Scanner(System.in);
        double readed;
        try {
            readed = Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e){
            System.out.print("Ошибка: Похоже, вы ввели не число или его неправильный формат. Введите число заново: ");
            readed = readDoubleNum();
        }
        return readed;
    }
}
