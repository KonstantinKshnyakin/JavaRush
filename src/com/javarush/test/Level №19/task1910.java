package com.javarush.task.task19.task1910;

/* 
Пунктуация

Условие:

Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

Закрыть потоки.


Требования:

1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName1));
        ArrayList<String> inputStr = new ArrayList<>();
        while (bufferedReader1.ready()) {
            inputStr.add(bufferedReader1.readLine());
        }
        bufferedReader1.close();

        for (int i = 0; i < inputStr.size(); i++) {
            inputStr.set(i, inputStr.get(i).replaceAll("\\pP",""));
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        for (String str : inputStr) {
            bufferedWriter.write(str);
        }
        bufferedWriter.close();

    }
}
