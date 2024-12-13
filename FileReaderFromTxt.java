
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;

public class FileReaderFromTxt {

    public static double FileReadingNum() {
        double numb = 0;
        //String filePath = "C:\\Users\\stud\\Desktop\\untitled\\src\\my_file.txt";
        String filePath = "H:\\ООП\\Лаба 3\\Laba3\\src\\number.txt";
        //String filePath = "C:\\Users\\Макс\\IdeaProjects\\Laba3\\src\\number.txt";

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    numb = Double.parseDouble(line.trim()); // trim() удаляет пробелы
                    System.out.println("Прочитанное число: " + numb);
                    
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка: некорректный формат числа в строке : " + line);
                }
            }
        } catch (FileNotFoundException ignored){
            System.err.println("Файл не найден. Проверьте путь к файлу.");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return numb;
    }

    public static List<Integer> FileReadingArray() throws IOException, NumberFormatException {
        String filePath = "H:\\ООП\\Лаба 3\\Laba3\\src\\array.txt";
        List<Integer> array = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            if (line != null) {
                String[] numbers = line.trim().split("\\s+");
                for (String number : numbers) {
                    array.add(Integer.parseInt(number));
                }
            }
        }
        return array;
    }

    public static void writeArrayToFile() {
        String filePath = "H:\\ООП\\Лаба 3\\Laba3\\src\\outputArray.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (int num : taskArray.newArray) {
                writer.println(num);
            }
            System.out.println("Массив успешно записан в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void writeNumberToFile(double numb) {
        numberWord.findNumber(numb);
        String filePath = "H:\\ООП\\Лаба 3\\Laba3\\src\\outputNumber.txt";
        String numberInWords = numberWord.thousand + numberWord.hundred + numberWord.dozen + numberWord.unit + "руб. " + numberWord.dozenFloat + numberWord.unitFloat + "коп.";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("Заданное число: " + numb);
            writer.println("Заданное число словами: " + numberInWords);
            System.out.println("Число успешно записано в файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void writeNumberToBinaryFile(double numb) {
        numberWord.findNumber(numb);
        String numberInWords = numberWord.thousand + numberWord.hundred + numberWord.dozen + numberWord.unit + "руб. " + numberWord.dozenFloat + numberWord.unitFloat + "коп.";
        String filePath = "H:\\ООП\\Лаба 3\\Laba3\\src\\outputNumberBinary.bin";
        try (FileOutputStream fos = new FileOutputStream(filePath);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             OutputStreamWriter osw = new OutputStreamWriter(bos, "UTF-16");
             PrintWriter writer = new PrintWriter(osw)) {

            // Запись числа как строки с явной кодировкой
            writer.println(numb);
            writer.println(numberInWords);

            System.out.println("Число успешно записано в бинарный файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в бинарный файл: " + e.getMessage());
        }
    }

    public static void writeArrayToBinaryFile(int size, taskArray newArray) {
        String filePath = "H:\\ООП\\Лаба 3\\Laba3\\src\\outputArrayBinary.bin";
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            // Сначала записываем размер массива
            dos.writeInt(size);
            // Затем записываем все элементы массива
            for (int value : taskArray.newArray) {
                dos.writeInt(value);
            }
            System.out.println("Массив успешно сохранен в бинарный файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
