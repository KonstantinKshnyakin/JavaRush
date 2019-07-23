package com.javarush.task.task22.task2202;

/* 
Найти подстроку

Условие:

Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
"JavaRush - лучший сервис обучения Java."

Результат:
"- лучший сервис обучения"

Пример:
"Амиго и Диего лучшие друзья!"

Результат:
"и Диего лучшие друзья!"

На некорректные данные бросить исключение TooShortStringException (сделать исключением).

Требования:

•	Класс TooShortStringException должен быть потомком класса RuntimeException.
•	Метод getPartOfString должен принимать строку в качестве параметра.
•	В случае, если в метод getPartOfString были переданы некорректные данные, должно возникнуть исключение TooShortStringException.
•	Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова, которое следует после 4-го пробела.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и"));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }

        String[] splitStr = string.split(" ");
        StringBuilder partStr = new StringBuilder();

        try {
            for (int i = 1; i <= 4; i++) {
                partStr.append(splitStr[i]).append(" ");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new TooShortStringException();
        }
        partStr.deleteCharAt(partStr.lastIndexOf(" "));
        return partStr.toString();
    }

    public static class TooShortStringException extends RuntimeException{
        
    }
}
