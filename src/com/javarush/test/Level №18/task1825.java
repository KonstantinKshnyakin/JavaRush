package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.TreeSet;

/* 
Собираем файл из кусочков.

Условие:
 
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Требования:

1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> setFileName = new TreeSet<>();
        String inputFileName;

        while (!(inputFileName = bufferedReader.readLine()).equals("end")) {
            setFileName.add(inputFileName);
        }
        bufferedReader.close();

        String fileName1 = setFileName.first();
        int indexPartN = fileName1.lastIndexOf('.');
        String outPutFileName = fileName1.substring(0, indexPartN);
        File file = new File(outPutFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(outPutFileName, true);

        for (String fileNameInSet : setFileName) {
            FileInputStream fileInputStream = new FileInputStream(fileNameInSet);
            byte[] buff = new byte[fileInputStream.available()];
            if (buff.length > 0) {
                fileInputStream.read(buff);
                fileOutputStream.write(buff);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
