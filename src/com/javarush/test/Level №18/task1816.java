package com.javarush.task.task18.task1816;

/* 
Английские буквы

Услдовие:

В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.


Требования:

1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        FileInputStream fileInputStream  = new FileInputStream(args[0]);
        ArrayList<String> arrayListStr = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            int inputButy = fileInputStream.read();
            String ByteToString = "" + (char)inputButy;

            if (ByteToString.matches("[A-Za-z]")){
                arrayListStr.add(ByteToString);
            }
        }

        System.out.println(arrayListStr.size());
        fileInputStream.close();
    }
}
