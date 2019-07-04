package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 

Условие:

Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("February 19 2012"));
        map.put("Шварцнегер", dateFormat.parse("January  8 2007"));
        map.put("Брюс Виллис", dateFormat.parse("June 30 2003"));
        map.put("Фриман", dateFormat.parse("July 4 2002"));
        map.put("Джон Уокер", dateFormat.parse("August 19 2001"));
        map.put("Вашингтон", dateFormat.parse("March 17 2016"));
        map.put("Траволта", dateFormat.parse("April 28 2015"));
        map.put("Кейси", dateFormat.parse("May 25 2014"));
        map.put("Снуп Дог", dateFormat.parse("September 2 2013"));
        map.put("Канеман", dateFormat.parse("November 13 2011"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
       Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

       while (iterator.hasNext()){
           Date temp = iterator.next().getValue();

           if(temp.toString().contains("Jul") || temp.toString().contains("Jun") || temp.toString().contains("Aug")){
               iterator.remove();
           }

       }


    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map = createMap();
        removeAllSummerPeople(map);

    }
}
