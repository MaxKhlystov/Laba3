import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class taskArray {
    private static int size;
    public static int [] newArray;
    public taskArray(int size){
        size=size;
        newArray  = new int[size];
    }
    private static Random random = new Random();
    public static void printNumbers(int choice, int min, int max, int size){
        newArray  = new int[size];
            if (choice == 3) {
                System.out.println("Исходный массив чисел Фиббоначи: ");
                for (int i = 0; i < size; i++) {
                    if (i < 2) {
                        newArray[i] = 1;
                    } else newArray[i] = newArray[i - 1] + newArray[i - 2];
                    System.out.println(newArray[i]);
                }
            } else if (choice == 4) {
                System.out.println("Исходный массив рандомных чисел: ");
                for (int i = 0; i < size; i++) {
                    newArray[i] = random.nextInt(max + 1 - min) + min;
                    System.out.println(newArray[i]);
                }
            } else if (choice == 1) {
                for (int i = 0; i < size; i++) {
                    System.out.print("Введите число: ");
                    newArray[i] = Menu.readNum();
                }
                System.out.println("Исходный массив чисел, записанных вручную: ");
                for (int i = 0; i < size; i++) {
                    System.out.println(newArray[i]);
                }
            }
    }
    public static void printFirstNumbers(int numberFirstElements){
        try {
            System.out.println("Первые " + numberFirstElements + " чисел массива: ");
            for (int i = 0; i < numberFirstElements; i++) {
                if (newArray[i] % 2 == 0) {
                    System.out.println(newArray[i] + "-*");
                } else System.out.println(newArray[i]);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
            System.out.println("Вы ввели число первых чисел больше, чем содержится в массиве.");
        }
    }
    public static void set(int i, int value) {
        if (i >= 0 && i < newArray.length) {
            newArray[i] = value;
            System.out.println(newArray[i]);
        } else {
            throw new IndexOutOfBoundsException("Индекс вне границ массива");
        }
    }
    public static void printMiddle(int size){
        float sumNumbers = 0;
            for (int i = 0; i < size; i++) {
                sumNumbers = sumNumbers + newArray[i];
            }
        System.out.println("Среднее значение одномерного массива: " + (sumNumbers/size));
    }

}
