package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки

Условие:

Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
А Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова - подходит, выводим
Д А А Д //2 слова - подходит, выводим


Требования:

1. Класс Solution должен содержать публичное статическое поле words типа List<String>, которое должно быть сразу проинициализировано.
2. Класс Solution должен содержать статический блок, в котором добавляются три или больше слов в список words.
3. Программа должна считывать имя файла с консоли (используй BufferedReader).
4. BufferedReader для считывания данных с консоли должен быть закрыт.
5. Программа должна считывать содержимое файла (используй FileReader).
6. Поток чтения из файла (FileReader) должен быть закрыт.
7. Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words.
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
//        words.add("А");
//        words.add("Б");
//        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReaderFileName = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReaderFile = new BufferedReader(new FileReader(bufferedReaderFileName.readLine()));
        bufferedReaderFileName.close();
//        BufferedReader bufferedReaderFile = new BufferedReader(new FileReader("C:\\Users\\Кот\\Desktop\\Java Test\\input.txt"));
        String inputStr;
        while ((inputStr = bufferedReaderFile.readLine()) != null) {
            String[] splitInputStr = inputStr.split(" ");
            int countEqualsWords = 0;
            
            for (int i = 0; i < splitInputStr.length; i++) {
                for (String listWords : words) {
                    if (splitInputStr[i].equals(listWords)) {
                        countEqualsWords++;
                    }
                }
            }

            if (countEqualsWords == 2) {
                System.out.println(inputStr);
            }

        }
        bufferedReaderFile.close();
    }
}
