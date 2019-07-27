package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы 

Условие:

Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.


Требования:

1. В классе Solution должен быть создан класс Constants содержащий строковые константы.
2. Класс Constants должен быть публичным.
3. Класс Constants должен быть объявлен с модификатором, запрещающим наследование от этого класса.
4. В классе Constants должна существовать константа SERVER_IS_CURRENTLY_NOT_ACCESSIBLE со значением "The server is not currently accessible.".
5. В классе Constants должна существовать константа USER_IS_NOT_AUTHORIZED со значением "The user is not authorized.".
6. В классе Constants должна существовать константа USER_IS_BANNED со значением "The user is banned.".
7. В классе Constants должна существовать константа ACCESS_IS_DENIED со значением "Access is denied.".
*/
public class Solution {

    public static final class Constants {
        public static final String SERVER_IS_CURRENTLY_NOT_ACCESSIBLE = "The server is not currently accessible.";
        public static final String USER_IS_NOT_AUTHORIZED = "The user is not authorized.";
        public static final String USER_IS_BANNED = "The user is banned.";
        public static final String ACCESS_IS_DENIED = "Access is denied.";
    }

    public static void main(String[] args) {

    }
}
