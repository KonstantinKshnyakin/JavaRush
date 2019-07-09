package com.javarush.task.task17.task1710;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CrUD - Create, Update, Delete.

Условие:

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:

name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990


Требования:

1. Класс Solution должен содержать public static поле allPeople типа List<Person>.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        String s = args[0];
        if (s.equals("-c")) {
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = simpleDateFormat.parse(args[3]);
            simpleDateFormat.applyPattern("dd-MMM-yyyy");
            String date2 = simpleDateFormat.format(date1);
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], new Date(date2)));
                System.out.println(allPeople.size() - 1);
            }
            if (args[2].equals("ж")) {
                allPeople.add(Person.createFemale(args[1], new Date(date2)));
                System.out.println(allPeople.size() - 1);
            }

        } else if (s.equals("-u")) {
            int index = Integer.parseInt(args[1]);
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = simpleDateFormat.parse(args[4]);
            simpleDateFormat.applyPattern("dd-MMM-yyyy");
            String date2 = simpleDateFormat.format(date1);
            if (args[3].equals("м")) {
                allPeople.set(index, Person.createFemale((args[2]), new Date(date2)));
            }
            if (args[3].equals("ж")) {
                allPeople.set(index, Person.createFemale((args[2]), new Date(date2)));
            }

        }else if (s.equals("-d")) {
            int index = Integer.parseInt(args[1]);
            if (!allPeople.isEmpty()){
                allPeople.get(index).setName(null);
                allPeople.get(index).setSex(null);
                allPeople.get(index).setBirthDate(null);

            }
        } else if (s.equals("-i")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
            int index = Integer.parseInt(args[1]);
            String sex;
            if(allPeople.get(index).getSex() == Sex.MALE){
                sex = "м";
            }else{
                sex = "ж";
            }
            System.out.println(allPeople.get(index).getName() + " " + sex + " " + simpleDateFormat.format(allPeople.get(index).getBirthDate()));
        }
    }
}


package com.javarush.task.task17.task1710;

public enum Sex {
    MALE,
    FEMALE
}


package com.javarush.task.task17.task1710;

        import java.util.Date;

public class Person {
    private String name;
    private Sex sex;
    private Date birthDate;

    private Person(String name, Sex sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public static Person createMale(String name, Date birthDate) {
        return new Person(name, Sex.MALE, birthDate);
    }

    public static Person createFemale(String name, Date birthDate) {
        return new Person(name, Sex.FEMALE, birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

