package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Самые частые байты

условие:

Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:

1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        HashMap<Integer, Integer> byteCount = new LinkedHashMap<>();
        while (fileInputStream.available() > 0) {
            int inputByte1 = fileInputStream.read();
            if (!byteCount.containsKey(inputByte1)) {
                byteCount.put(inputByte1, 1);
            }else {
                byteCount.put(inputByte1, byteCount.get(inputByte1) + 1);
            }
        }
        
        fileInputStream.close();

        int maxRepetOfBytes = 0;
        for (int repeat : byteCount.values()){
            if (repeat > maxRepetOfBytes){
                maxRepetOfBytes = repeat;
            }
        }


        for (Map.Entry<Integer, Integer> entryByteCount : byteCount.entrySet()){
            int valueRepeat = entryByteCount.getValue();
            if (valueRepeat == maxRepetOfBytes){
                System.out.print(entryByteCount.getKey() + " ");
            }
        }

    }
}
