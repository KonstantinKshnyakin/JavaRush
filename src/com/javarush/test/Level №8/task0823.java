package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 
Условие:

Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
мама мыла раму.

Пример вывода:
Мама Мыла Раму.


Требования:

1. Программа должна выводить текст на экран.
2. Программа должна считывать строку с клавиатуры.
3. Класс Solution должен содержать один метод.
4. Программа должна заменять в тексте первые буквы всех слов на заглавные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String [] arrString = string.split("\\b");
        String [] newArrString = new String[arrString.length];

        for (int i = 0; i < arrString.length; i++) {
            char[] arrChar = arrString[i].toCharArray();
            arrChar[0] = Character.toUpperCase(arrChar[0]);
            String newStringFirstCharToUpperCase = new String(arrChar);
            newArrString[i] = newStringFirstCharToUpperCase;
        }

        for (int i = 0; i < newArrString.length; i++) {
            System.out.print(newArrString[i]);
        }


    }
}
