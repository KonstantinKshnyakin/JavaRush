package com.javarush.task.task21.task2109;

/* 
Запретить клонирование

Условие:

Разреши клонировать класс А
Запрети клонировать класс B
Разреши клонировать класс C
Не забудь о методах equals и hashCode!


Требования:

1. Класс A должен поддерживать интерфейс Cloneable.
2. Класс B должен быть потомком класса A.
3. При объявлении класса B не должно быть явно указано implements Cloneable.
4. Метод clone в классе B должен быть переопределен таким образом, чтобы при попытке клонирования объекта класса B возникало исключение CloneNotSupportedException.
5. Класс C должен быть потомком класса B.
6. Клонирование объектов класса C должно завершаться успешно.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return new A(this.i, this.j);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            A a = (A) obj;
            if (this.getI() != a.getI()) return false;
            return this.getJ( ) == a.getJ( );
        }

        @Override
        public int hashCode() {
            int result = this.getI() != 0 ? this.getI() * 77 : 0;
            result = 31 * result + (this.getJ() != 0 ? this.getJ() * 42 : 0);
            return result;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
        @Override
        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass()) return false;
            C c = (C) obj;
            if (this.getI() != c.getI()) return false;
            if (this.getName() != null ? !this.getName().equals(c.getName()) : c.getName() != null) return false;
            return this.getJ( ) == c.getJ( );
        }

        @Override
        public int hashCode() {
            int result = this.getI() != 0 ? this.getI() * 77 : 0;
            result = result + (this.getName() != null ? this.getName().hashCode()  : 0);
            result = 31 * result + (this.getJ() != 0 ? this.getJ() * 42 : 0);
            return result;
        }
    }

    public static class C extends B  implements Cloneable{
        public C(int i, int j, String name)  {
            super(i, j, name);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return new C(this.getI(), this.getJ(), this.getName());
        }

    }

    public static void main(String[] args) throws CloneNotSupportedException{
//        C c1 = new C(2, 5, "NoN");
//        C c2 = (C) c1.clone();
//        System.out.println(c1);
//        System.out.println(c2);
//        A a1 = new A(2, 5);
//        A a2 = (A) a1.clone();
//        System.out.println(a1);
//        System.out.println(a2);
//        B b1 = new B(2, 5, "NoN");
//        B b2 = (B) b1.clone();
//        System.out.println(b1);
//        System.out.println(b2);
    }
}
