package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты

Услолвие:

Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.


Требования:

1. Класс Solution должен поддерживать интерфейс Cloneable.
2. Класс User должен поддерживать интерфейс Cloneable.
3. В классе User должен быть корректно реализован метод clone.
4. В классе Solution должен быть корректно реализован метод clone.
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);
//            clone.users.put("Zapp", new User(41, "Habr"));

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        solution.users.putAll(this.users);
        return solution;

    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;
        User(){

        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            User user = new User();
            user.age = this.age;
            user.name = this.name;
            return user;

        }

        @Override
        public int hashCode() {
            int result = this.age != 0 ? Integer.hashCode(age) : 0;
            result = 31 * result * age + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof User)) {
                return false;
            }

            User user = (User) obj;

            if (this.age != user.age) {
                return false;
            }
            if (this.name != null ? !this.name.equals(user.name) : user.name != null) {
                return false;
            }
            return true;
        }
    }
}
