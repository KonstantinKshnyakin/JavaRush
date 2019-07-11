package com.javarush.task.task18.task1819;

/* 
Объединение файлов

Услвоие:

Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:

1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
6. Сначала должно идти содержимое второго файла, затем содержимое первого.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileInputStream fileInputStream2 = new FileInputStream(bufferedReader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);


        byte[] buff1 = new byte[fileInputStream1.available()];
        if (fileInputStream1.available() > 0) {
           int count = fileInputStream1.read(buff1);
        }

        byte[] buff2 = new byte[fileInputStream2.available()];
        if (fileInputStream2.available() > 0) {
            int count = fileInputStream2.read(buff2);
        }

        if (buff1.length > 0 && buff2.length > 0) {
            fileOutputStream.write(buff2);
            fileOutputStream.write(buff1);
        }

        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();
    }
}
