package com.javarush.task.task21.task2108;

import java.util.Arrays;

/*
Клонирование растений

Условие:

Класс Plant не должен реализовывать интерфейс Cloneable
Реализуй механизм глубокого клонирования для Tree.


Требования:

1. Класс Plant не должен поддерживать интерфейс Cloneable.
2. Класс Tree должен поддерживать интерфейс Cloneable.
3. Класс Tree должен быть потомком класса Plant.
4. В классе Tree должен быть корректно реализован метод clone.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone =(Tree) tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);




    }

    public static class Plant{
        private String name;


        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable{
        private String[] branches;



        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            Tree cloneTree = new Tree(this.getName(), Arrays.copyOf(this.branches, branches.length));
            return cloneTree;
        }
    }
}
