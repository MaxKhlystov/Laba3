package domain;

import java.util.Random;

public class TaskArray {
    private int size;
    private int [] newArray;

    public TaskArray(int size){
        this.size=size;
        newArray  = new int[size];
    }

    public TaskArray(int [] newArray){
        this.size = newArray.length;
        this.newArray = newArray;
    }

    public String getArrayAsString(){
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < size; i++) {
            str.append(newArray[i]+" ");
        }
        return str.toString();
    }
    public void generateRandom(int minNum, int maxNum){
        Random random = new Random();
        try {
            for (int i = 0; i < size; i++) {
                newArray[i] = random.nextInt(maxNum + 1 - minNum) + minNum;
            }
        }catch(IllegalArgumentException e){
            System.out.println("Ошибка: Максимальный элемент должен быть больше минимального");
        }
    }
    public void generateFibbonachi(){
        for (int i = 0; i < size; i++) {
            if (i < 2) {
                newArray[i] = 1;
            } else newArray[i] = newArray[i - 1] + newArray[i - 2];
        }
        System.out.println("Массив чисел Фиббоначи успешно сгенерирован.");
    }
    public void printFirstNumbers(int numberFirstElements){
        try {
            System.out.println("Первые " + numberFirstElements + " чисел массива: ");
            for (int i = 0; i < numberFirstElements; i++) {
                if (newArray[i] % 2 == 0) {
                    System.out.println(newArray[i] + "-*");
                } else System.out.println(newArray[i]);
            }
        }catch (ArrayIndexOutOfBoundsException ignored){
            System.out.println("Ошибка: Вы ввели число первых чисел больше, чем содержится в массиве.");
        }
    }
    public void set(int i, int value) {
        if (i >= 0 && i < newArray.length) {
            newArray[i] = value;
            System.out.println(newArray[i]);
        } else {
            throw new IndexOutOfBoundsException("Ошибка: Индекс вне границ массива");
        }
    }

    public void setToWrite(int i, int [] printArray){
        if (i >= 0 && i < size) {
            printArray[i]=newArray[i];
        } else {
            throw new IndexOutOfBoundsException("Ошибка: Индекс вне границ массива");
        }
    }
    public void printMiddle(){
        float sumNumbers = 0;
        for (int i = 0; i < size; i++) {
            sumNumbers = sumNumbers + newArray[i];
        }
        System.out.println("Среднее значение одномерного массива: " + (sumNumbers/size));
    }
}
