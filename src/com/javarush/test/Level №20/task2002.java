package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush

Условие:

Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для вас и не участвует в тестировании.


Требования:

1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
4. Класс Solution.JavaRush должен быть публичным.
5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("C:\\Users\\Светлана\\Desktop\\Java Test\\input.txt");
            InputStream inputStream = new FileInputStream("C:\\Users\\Светлана\\Desktop\\Java Test\\input.txt");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            JavaRush javaRush = new JavaRush();

            User user1 = new User();
            user1.setFirstName("Ivan");
            user1.setLastName("Petrov");
            user1.setMale(true);
            user1.setBirthDate(simpleDateFormat.parse("10 12 1988"));
            user1.setCountry(User.Country.UKRAINE);

            User user2 = new User();
            user2.setFirstName("Ivan12");
            user2.setLastName("Petrov12");
            user2.setMale(true);
            user2.setBirthDate(simpleDateFormat.parse("10 11 1981"));
            user2.setCountry(User.Country.RUSSIA);

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();
            outputStream.close();


            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.users.get(0).equals(loadedObject.users.get(0)));

            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("E dd MM yyyy HH:mm:ss:SS z");

            for (User user : users) {
                outputStreamWriter.write(user.getFirstName() + "\r\n");
                outputStreamWriter.write(user.getLastName() + "\r\n");
                outputStreamWriter.write(simpleDateFormat1.format(user.getBirthDate()) + "\r\n");
                outputStreamWriter.write(user.isMale() + "\r\n");
                outputStreamWriter.write(user.getCountry() + "\r\n");
            }
            outputStreamWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("E dd MM yyyy HH:mm:ss:SS z");


            while (bufferedReader.ready()) {
                User user = new User();
                user.setFirstName(bufferedReader.readLine());
                user.setLastName(bufferedReader.readLine());
                user.setBirthDate(simpleDateFormat2.parse(bufferedReader.readLine()));
                user.setMale(Boolean.parseBoolean(bufferedReader.readLine()));
                switch (bufferedReader.readLine()) {
                    case "UKRAINE" : {
                        user.setCountry(User.Country.UKRAINE);
                        break;
                    }
                    case "RUSSIA" : {
                        user.setCountry(User.Country.RUSSIA);
                        break;
                    }
                    case "OTHER" : {
                        user.setCountry(User.Country.OTHER);
                        break;
                    }

                }
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}


package com.javarush.task.task20.task2002;

        import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private boolean isMale;
    private Country country;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public static enum Country {
        UKRAINE("Ukraine"),
        RUSSIA("Russia"),
        OTHER("Other");

        private String name;

        private Country(String name) {
            this.name = name;
        }

        public String getDisplayName() {
            return this.name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isMale != user.isMale) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (birthDate != null ? !birthDate.equals(user.birthDate) : user.birthDate != null) return false;
        return country == user.country;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (isMale ? 1 : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
