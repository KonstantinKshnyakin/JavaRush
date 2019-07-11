package com.javarush.task.task18.task1818;

/* 
Два в одном

Условие:

Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:

1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream1 = new FileOutputStream(bufferedReader.readLine(), true);
        FileInputStream fileInputStream2 = new FileInputStream(bufferedReader.readLine());
        FileInputStream fileInputStream3 = new FileInputStream(bufferedReader.readLine());
        bufferedReader.close();
        
        while (fileInputStream2.available() > 0) {
            int nextByte = fileInputStream2.read();
            fileOutputStream1.write(nextByte);
        }
        
        while (fileInputStream3.available() > 0) {
            int nextByte = fileInputStream3.read();
            fileOutputStream1.write(nextByte);
        }
        
        fileOutputStream1.close();
        fileInputStream2.close();
        fileInputStream3.close();
    }
}
