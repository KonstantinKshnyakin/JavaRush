package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person

Условие:

Класс Person должен сериализовываться с помощью интерфейса Externalizable.
Исправь ошибку сериализации.
Сигнатуры методов менять нельзя.


Требования:

1. В классе Solution.Person должен быть создан публичный конструктор без параметров.
2. В классе Solution.Person должен быть создан конструктор с тремя параметрами (String firstName, String lastName, int age).
3. Класс Solution.Person должен поддерживать интерфейс Externalizable.
4. Методы readExternal и writeExternal должны позволять корректно сериализовывать и десериализовывать объекты типа Person.
*/
public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){

        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.firstName);
            out.writeObject(this.lastName);
            out.writeObject(this.mother);
            out.writeObject(this.father);
            out.writeObject(this.children);
            out.writeInt(this.age);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.firstName = (String)in.readObject();
            this.lastName = (String)in.readObject();
            this.mother = (Person)in.readObject();
            this.father = (Person)in.readObject();
            this.children = (List)in.readObject();
            this.age = in.readInt();
        }

        @Override
        public String toString() {
            return this.firstName + " " + this.lastName + " " + this.age;
        }
    }

    public static void main(String[] args) throws Exception{
        Person person = new Person("Petr", "Ivanov", 32);
        person.setChildren(new ArrayList<>());
        person.setFather(new Person("Aleksandr", "Ivanov", 68));
        person.setMother(new Person("Aleksandra", "Ivanova", 64));

        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Светлана\\Desktop\\Java Test\\input.txt"));
        person.writeExternal(objectOutput);
        objectOutput.flush();


        ObjectInput objectInput = new ObjectInputStream(new FileInputStream("C:\\Users\\Светлана\\Desktop\\Java Test\\input.txt"));
        Person person1 = new Person();
        person1.readExternal(objectInput);

        objectOutput.close();
        objectInput.close();

        System.out.println(person);
        System.out.println(person1);

    }
}
