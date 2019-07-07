package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
Клубок

Условие: 

1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()


Требования:

1. Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
2. Нити из списка threads не должны стартовать автоматически.
3. Нить 1 из списка threads должна бесконечно выполняться.
4. Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
5. Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
6. Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
7. Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
 */

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new T1());
        threads.add(new T2());
        threads.add(new T3());
        threads.add(new T4());
        threads.add(new T5());
    }

    public static void main(String[] args) {


    }

    static class T1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    static class T2 extends Thread {
        @Override
        public void run() {
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }

        }
    }

    static class T3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class T4 extends Thread implements Message {
        boolean off = false;

        @Override
        public void run() {
            while (!off) {

            }
        }

        @Override
        public void showWarning() {
            off = true;
        }
    }

    static class T5 extends Thread {
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputStrInt;
            int inputInt = 0;
            try {
                while (!(inputStrInt = reader.readLine()).equals("N")) {
                    inputInt += Integer.parseInt(inputStrInt);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(inputInt);
        }
    }
}
