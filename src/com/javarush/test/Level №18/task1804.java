package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты

Условие:
 
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.

Требования:

•	Программа должна считывать имя файла с консоли.
•	Для чтения из файла используй поток FileInputStream.
•	В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
•	Данные в консоль должны выводится в одну строку.
•	Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        HashMap<Integer, Integer> byteMap = new HashMap<>();

        while (fileInputStream.available() > 0) {
            int nextByte = fileInputStream.read();
            if (!byteMap.containsKey(nextByte)) {
                byteMap.put(nextByte, 1);
            } else {
                byteMap.put(nextByte, byteMap.get(nextByte) + 1);
            }
        }
        fileInputStream.close();

        int minRepeatOfByte = Integer.MAX_VALUE;
        for (int repeatOfByte : byteMap.values()) {
            if (repeatOfByte < minRepeatOfByte) {
                minRepeatOfByte = repeatOfByte;
            }
        }

        for (Map.Entry<Integer, Integer> entryByteMap : byteMap.entrySet()) {
            int repeatOfByte = entryByteMap.getValue();
            if (repeatOfByte == minRepeatOfByte) {
                System.out.print(entryByteMap.getKey() + " ");
            }
        }
    }
}
