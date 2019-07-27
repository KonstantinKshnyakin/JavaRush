package com.javarush.task.task23.task2303;

/* 
Запрети создание экземпляров класса Listener.

Требования:
•	Класс Listener должен быть создан внутри класса Solution.
•	Класс Listener должен быть публичным.
•	Класс Listener должен быть статическим.
•	Должна быть запрещена возможность создавать экземпляры класса Listener.
*/
public class Solution {

    public static abstract class Listener {

        private Listener() {

        }
        public void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }
    }

    public static void main(String[] args) {

    }
}
