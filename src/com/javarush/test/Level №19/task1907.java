package com.javarush.task.task19.task1907;

/* 
Считаем слово

Условие:

Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Требования:

1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(fileName);

        String inputWords = "";
        while (fileReader.ready()) {
            inputWords += (char) fileReader.read();
        }
        fileReader.close();

        String[] wordSeparation = inputWords.split("\\W");

        int countWorld = 0;
        for (int i = 0; i < wordSeparation.length; i++) {
            if (wordSeparation[i].equals("world")) {
                countWorld++;
            }
        }
        System.out.println(countWorld);

    }
}
