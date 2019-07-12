package com.javarush.task.task19.task1908;

/* 
Выделяем числа

Условие:

Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:

1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
//        String fileName1 = "C:\\Users\\Светлана\\Desktop\\Java Test\\input.txt";
//        String fileName2 = "C:\\Users\\Светлана\\Desktop\\Java Test\\output.txt";
        bufferedReader.close();
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName1));
        ArrayList<String> inputStr = new ArrayList<>();
        while (bufferedReader1.ready()) {
            inputStr.add(bufferedReader1.readLine());
        }
        bufferedReader1.close();

        String[] strSeparation = inputStr.get(0).split(" ");
        

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        for (int i = 0; i < strSeparation.length; i++) {
            if (strSeparation[i].matches("\\d+")) {
                bufferedWriter.write(strSeparation[i] + " ");
            }
        }
        bufferedWriter.close();
        
    }
}
