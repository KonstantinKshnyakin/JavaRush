package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Самые-самые

Условие:

1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3. Должна быть выведена одна строка.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
5. Должна быть выведена только одна строка.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> arrString= new ArrayList<>();
        ArrayList<Integer> stringLength= new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            String inputString = reader.readLine();
            arrString.add(inputString);

            int a = inputString.length();
            stringLength.add(a);
        }

        reader.close();

        Collections.sort(stringLength);

        int smallString = stringLength.get(0);
        int bigString = stringLength.get(stringLength.size() - 1);

        for (String string : arrString) {

            if (string.length() == smallString) {
                System.out.println(string);
                break;
            }

            if (string.length() == bigString) {
                System.out.println(string);
                break;
            }
        }
    }
}
