package com.javarush.task.task19.task1925;

/* 
Длинные слова

Условие:

В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:

1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReaderFIle_1 = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriterFIle_2 = new BufferedWriter(new FileWriter(args[1]));

//        BufferedReader bufferedReaderFIle_1 = new BufferedReader(new FileReader("C:\\Users\\Кот\\Desktop\\Java Test\\input.txt"));
//        BufferedWriter bufferedWriterFIle_2 = new BufferedWriter(new FileWriter("C:\\Users\\Кот\\Desktop\\Java Test\\output.txt"));

        StringBuilder stringBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = bufferedReaderFIle_1.readLine()) != null) {
            String[] splitInputStr = inputStr.split(" ");
            for (int i = 0; i < splitInputStr.length; i++) {
                if (splitInputStr[i].length() > 6) {
                    stringBuilder.append(splitInputStr[i] ).append(",");
                }
            }
        }
//        System.out.println(stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        bufferedWriterFIle_2.write(stringBuilder.toString());

        bufferedReaderFIle_1.close();
        bufferedWriterFIle_2.close();



    }
}
