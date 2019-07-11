package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты

Условие:

Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:

1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = bufferedReader.readLine();
            if (fileName.equals("exit")) {
                break;
            }
            new ReadThread(fileName).start();

        }
        bufferedReader.close();
    }


    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            HashMap<Integer, Integer> quantityByte = new HashMap<>();

            try (FileInputStream fileInputStream = new FileInputStream(fileName)) {

                while (fileInputStream.available() > 0) {
                    int nextByte = fileInputStream.read();
                    if (quantityByte.containsKey(nextByte)) {
                        quantityByte.put(nextByte, quantityByte.get(nextByte) + 1);
                    } else {
                        quantityByte.put(nextByte, 1);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


            int maxQuantity = 0;
            int maxByte = -1;
            for (Map.Entry<Integer, Integer> entryQuantityByte : quantityByte.entrySet()) {
                if (maxQuantity < entryQuantityByte.getValue()) {
                    maxQuantity = entryQuantityByte.getValue();
                    maxByte = entryQuantityByte.getKey();
                }
            }

            resultMap.put(fileName, maxByte);
        }

    }

}
