package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки

Условие:

В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.


Требования:

1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(args[0]);
             FileOutputStream fileOutputStream = new FileOutputStream(args[1])){
            
            byte[] buff = new byte[fileInputStream.available( )];
            fileInputStream.read(buff);
            String inputStrForFile = new String(buff, "Windows-1251");
            fileOutputStream.write(inputStrForFile.getBytes("UTF-8"));
            
        } catch (IOException e) {
            e.getMessage();
        }
        
    }
}
