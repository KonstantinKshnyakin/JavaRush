package com.javarush.task.task18.task1820;

/* 
Округление чисел

Условие:

Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:

1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(bufferedReader.readLine()));
        bufferedReader.close();

        String dsdfd = bufferedReader1.readLine();
        bufferedReader1.close();

        String[] stringBuff =dsdfd.split(" ");
       
        for (int i = 0; i < stringBuff.length; i++) {
            int valueWrite;
            if (stringBuff[i].contains(".")) {
                double nextDouble = Double.parseDouble(stringBuff[i]);
                 valueWrite = (int) Math.round(nextDouble);
            }else {
                int nextInt = Integer.parseInt(stringBuff[i]);
                valueWrite = (int) Math.round(nextInt);
            }
            bufferedWriter1.write( valueWrite + " ");
        }
        bufferedWriter1.close();



    }
}
