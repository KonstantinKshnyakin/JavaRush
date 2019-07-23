package com.javarush.task.task22.task2203;

/* 
Между табуляциями

Условие:

Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.


Требования:

1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException( );
        }

        int countTab = 0;
        for (Character charInString : string.toCharArray( )) {
            if (charInString.equals('\t')) {
                countTab++;
            }
        }
        if (countTab < 2) {
            throw new TooShortStringException( );
        }
        
        
        String[] stringSplit = string.split("\t");
        return stringSplit[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
