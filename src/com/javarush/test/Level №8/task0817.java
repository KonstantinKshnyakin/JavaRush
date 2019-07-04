package com.javarush.task.task08.task0817;

import java.util.*;

/*

Условие:

Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.


Требования:

1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей.
4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Смирнов", "Павел");
        map.put("Аронов", "Андрей");
        map.put("Краков", "Алексей");
        map.put("Каштаян", "Петр");
        map.put("Обручев", "Константин");
        map.put("Мичурин", "Павел");
        map.put("Сахаров", "Антон");
        map.put("Сухой", "Владимир");
        map.put("Шухов", "Петр");
        map.put("Микоян", "Анатолий");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copy = new HashMap<>(map);

        for (Map.Entry<String, String> entryMap1 : copy.entrySet()) {
            int count = 0;
            for (Map.Entry<String, String> entryMap2 : copy.entrySet()) {
                if (entryMap1.getValue().equals(entryMap2.getValue())) {
                    count++;
                    if (count == 2) {
                        removeItemFromMapByValue(map, entryMap1.getValue());
                    }
                }

            }
        }
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);

        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }

    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);

    }
}
