package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE

Условие:

Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'


Требования:

1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Solution {
    public static void main(String[] args) {
//        HashMap<String, String> where = new LinkedHashMap<>();
//        where.put("name", "Ivanov");
//        where.put("country", "Ukraine");
//        where.put("city", "Kiev");
//        where.put("age", null);
//
//        System.out.println(where);
//
//        System.out.println(getQuery(where));

    }
    public static String getQuery(Map<String, String> params) {
        if (params == null && params.size() == 0) {
            return "";
        }
        StringBuilder whereStrBuild = new StringBuilder();
        for (Map.Entry<String, String> entryParams : params.entrySet()) {
            if (whereStrBuild.length() > 0 && entryParams.getValue() != null) {
                whereStrBuild.append(" and ");
            }
            if (entryParams.getKey() != null && entryParams.getValue() != null) {
                whereStrBuild.append(entryParams.getKey()).append(" = '").append(entryParams.getValue()).append("'");
            }

        }
        return whereStrBuild.toString();
    }
}
