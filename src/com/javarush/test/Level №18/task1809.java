package com.javarush.task.task18.task1809;

/* 
Реверс файла

Условие:

Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.


Требования:

1. Программа должна два раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
3. Во второй файл нужно записать все байты из первого в обратном порядке.
4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        
        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        
        byte[] inputArrByte = new byte[fileInputStream.available()];
        byte[] outputArrByte = new byte[fileInputStream.available()];
        fileInputStream.read(inputArrByte);

        for (int i = 0, j = outputArrByte.length - 1; i < inputArrByte.length; i++, j--) {
            outputArrByte[j] = inputArrByte[i];
        }

        fileOutputStream.write(outputArrByte);
        
        fileInputStream.close();
        fileOutputStream.close();

    }
}
