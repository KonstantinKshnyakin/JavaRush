package com.javarush.task.task19.task1920;

/* 
Самый богатый

Условие:

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:

1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String , Double> mapSalaries = new TreeMap<>();

        String inputStr;
        while ((inputStr = bufferedReader.readLine()) != null) {
            String[] arrInputStr = inputStr.split(" ");
            if (!mapSalaries.containsKey(arrInputStr[0])) {
                mapSalaries.put(arrInputStr[0], Double.parseDouble(arrInputStr[1]));
            } else {
                double sumSalaries = mapSalaries.get(arrInputStr[0]) + Double.parseDouble(arrInputStr[1]);
                mapSalaries.put(arrInputStr[0], sumSalaries);
            }
        }
        bufferedReader.close();

        double maxSalaries = 0;
        for (Map.Entry<String, Double> entryMapSalaries : mapSalaries.entrySet()) {
            if (entryMapSalaries.getValue() > maxSalaries) {
               maxSalaries = entryMapSalaries.getValue();
            }
        }

        for (Map.Entry<String, Double> entryMapSalaries : mapSalaries.entrySet()) {
            if (entryMapSalaries.getValue().equals(maxSalaries)) {
                System.out.println(entryMapSalaries.getKey());
            }
        }
    }
}
