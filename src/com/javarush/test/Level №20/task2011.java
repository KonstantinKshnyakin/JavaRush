package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов

Условие:

Реализуй интерфейс Externalizable в классе Apartment.


Требования:

1. Класс Solution.Apartment должен поддерживать интерфейс Externalizable.
2. В классе Solution.Apartment должен быть реализован метод writeExternal с одним параметром типа ObjectOutput.
3. В классе Solution.Apartment должен быть реализован метод readExternal с одним параметром типа ObjectInput.
4. В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeObject с параметром address.
5. В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeInt с параметром year.
6. Метод readExternal должен корректно восстанавливать из ObjectInput значение поля address.
7. Метод readExternal должен корректно восстанавливать из ObjectInput значение поля year.
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.address);
            out.writeInt(this.year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.address = (String)in.readObject();
            this.year = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Apartment apartment = new Apartment();
//        apartment.address = "SOlol";
//        apartment.year = 2019;
//
//        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Кот\\Desktop\\Java Test\\input.txt");
//        ObjectOutput objectOutput = new ObjectOutputStream(fileOutputStream);
//        apartment.writeExternal(objectOutput);
//        fileOutputStream.flush();
//        objectOutput.flush();
//
//
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Кот\\Desktop\\Java Test\\input.txt");
//        ObjectInput objectInput = new ObjectInputStream(fileInputStream);
//
//        Apartment apartment1 = new Apartment();
//        apartment1.readExternal(objectInput);
//
//        fileOutputStream.close();
//        objectOutput.close();
//        fileInputStream.close();
//        objectInput.close();
//
//        System.out.println(apartment);
//        System.out.println(apartment1);
    }
}
