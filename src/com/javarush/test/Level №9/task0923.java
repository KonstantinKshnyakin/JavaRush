package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 

Условие:

Гласные и согласные
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы из введённой строки.
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
Пример ввода:
Мама мыла раму.

Пример вывода:
а а ы а а у
М м м л р м .


Требования:

1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить две строки.
3. Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
4. Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
5. Каждая строка должна заканчиваться пробелом.
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
    public static List<Character> arrVowels = new ArrayList<>();
    public static List<Character> arrConsonants = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        char[] stringToChar = inputString.toCharArray();

        for (int i = 0; i < stringToChar.length; i++) {
            boolean vowelsOrConsonants = isVowel(stringToChar[i]);
            if(vowelsOrConsonants == true){
                arrVowels.add(stringToChar[i]);
            }else {
                if (stringToChar[i] != '\u0020') {
                    arrConsonants.add(stringToChar[i]);
                }
            }
        }

        print(arrVowels, arrConsonants);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        for (char d : vowels) {
            if (d == c) {
                return true;
            }
        }
        return false;


    }
    public static void print(List<Character> arrVowels, List<Character> arrConsonants){
        for (char c : arrVowels){
            System.out.print(c + " ");
        }
        System.out.println();
        for (char c : arrConsonants){
            System.out.print(c + " ");
        }
    }
}
