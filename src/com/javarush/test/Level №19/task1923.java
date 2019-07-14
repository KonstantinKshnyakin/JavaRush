package com.javarush.task.task19.task1923;

/* 
Слова с цифрами

Условие:

В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:

1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException{
//        ArrayList<String> arrInputStr = new ArrayList<>();
        BufferedReader bufferedReaderFile = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriterFile = new BufferedWriter(new FileWriter(args[1]));
//        BufferedReader bufferedReaderFile = new BufferedReader(new FileReader("C:\\Users\\Кот\\Desktop\\Java Test\\input.txt"));
//        BufferedWriter bufferedWriterFile = new BufferedWriter(new FileWriter("C:\\Users\\Кот\\Desktop\\Java Test\\output.txt"));
        String inputStr;
        while ((inputStr = bufferedReaderFile.readLine()) != null) {
            String[] splitInputStr = inputStr.split(" ");
            for (int i = 0; i < splitInputStr.length; i++) {
                if (splitInputStr[i].matches(".*\\d+.*")) {
                    bufferedWriterFile.write(splitInputStr[i] + " ");
//                    System.out.println(splitInputStr[i] + " ");
                }
            }
        }
        bufferedReaderFile.close();
        bufferedWriterFile.close();


    }
}
