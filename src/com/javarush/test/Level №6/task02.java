package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Числа по возрастанию

Условие:
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.

Пример ввода:
3
2
15
6
17

Пример вывода:
2
3
6
15
17


Требования:
1. Программа должна считывать 5 чисел с клавиатуры.
2. Программа должна выводить 5 чисел, каждое с новой строки.
3. Выведенные числа должны быть отсортированы по возрастанию.
4. Вывод должен содержать те же числа, что и были введены (порядок не важен).
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] listInt = new int[5];

        for (int i = 0; i < listInt.length; i++) {
            String inputStringInt = reader.readLine();
            int inputInt = Integer.parseInt(inputStringInt);
            listInt[i] = inputInt;
        }

        reader.close();

        for (int i = 0; i < listInt.length; i++) {

            for (int j = 0; j < listInt.length - i - 1; j++) {

                if (listInt[j] > listInt[j + 1]) {
                    int b = listInt[j];
                    listInt[j] = listInt[j + 1];
                    listInt[j + 1] = b;

                }
            }

        }
        for (Integer integer : listInt) {
            System.out.println(integer);
        }
    }
}
