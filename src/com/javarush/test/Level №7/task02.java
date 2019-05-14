package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка

Условие:

1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран. Если таких строк несколько, выведи каждую с новой строки.


Требования:
1. Инициализируй существующее поле strings класса Solution новым ArrayList<>
2. Программа должна считывать 5 строк с клавиатуры и записывать их в поле strings класса Solution.
3. Программа должна выводить самую длинную строку на экран.
4. Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            strings.add(reader.readLine());
        }

        int bigString = strings.get(0).length();

        for (int i = 0; i < strings.size() - 1; i++) {

            int lengthString1 = strings.get(i).length();
            int lengthString2 = strings.get(i + 1).length();

            if (lengthString2 > lengthString1){

                bigString = lengthString2;
            }
        }

        for (int i = 0; i < strings.size(); i++) {

            if (strings.get(i).length() == bigString){

                System.out.println(strings.get(i));
            }
        }
    }
}
