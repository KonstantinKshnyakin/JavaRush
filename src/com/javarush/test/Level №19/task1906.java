package com.javarush.task.task19.task1906;

/* 
Четные символы

Условие:

Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод

Требования:

•	Программа должна считывать имена файлов с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна записывать во второй файл все байты из первого файла с четным порядковым номером (используй FileWriter).
•	Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);
        ArrayList<Character> arrChar = new ArrayList<>();
        while (fileReader.ready()) {
            arrChar.add((char)fileReader.read());
        }
        fileReader.close();
        System.out.println(arrChar);
        for (int i = 0; i < arrChar.size(); i++) {
            if (i % 2 == 1) {
                fileWriter.write(arrChar.get(i));
            }

        }
        fileWriter.close();
    }
}
