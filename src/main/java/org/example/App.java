package org.example;

/*

 {
    "name": "Vsevolod",
    "surname": "Ievgiienko",
    "phones": ["3834543534", "1233543435"],
    "age": 38,
    "address": {
        "country": "UA",
        "city": "Kyiv"
    }
 }

 [
    {"file": "xxx.txt", "size": 234534543},
    {"file": "yyyy.dat", "size": 3454}
 ]

 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

class Address {
    String country;
    String city;

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class Person {
    String name;
    String surname;
    int age;
    String[] phones;
    Address address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phones=" + Arrays.toString(phones) +
                ", address=" + address +
                '}';
    }
}

class File {
    String name;
    int size;
    String type;

    @Override
    public String toString() {
        return "Files{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}
class Files {
    int count;
    File[] files;

    public int getCount() {
        return count;
    }

    public File[] getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return "Files{" +
                "count=" + count +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}

public class App
{
    static final String JSON = """
        {
            "name": "Vsevolod",
            "surname": "Ievgiienko",
            "phones": ["3834543534", "1233543435"],
            "age": 38,
            "address": {
                "country": "UA",
                "city": "Kyiv"
            }
        }
    """;
    static final String JSON_2 = """
    [
       {"name": "hello.txt", "size": 1223, "type": "txt"},
       {"name": "image.png", "size": 546234, "type": "png"}
    ]
""";
    static final String JSON_3 = """
    [
        { "count": 2, "files": [ { "name": "1.txt", "size": 1234, "type": "txt" }, 
        { "name": "2.png", "size": 456, "type": "png" } ] }
    ]
""";

    public static void main( String[] args) {
/*        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Person person = gson.fromJson(JSON, Person.class);
        System.out.println(person);

        person.age = 15;

        String json = gson.toJson(person);
        System.out.println(json);

        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        File[] files = gson2.fromJson(JSON_2, File[].class);
        System.out.println(Arrays.toString(files));
 */
        Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
        Files[] filesAndCount = gson3.fromJson(JSON_3, Files[].class);
        System.out.println(compareCountWithRealNumber(filesAndCount));
    }
    public static boolean compareCountWithRealNumber(Files[] files){
        int count = files[0].getCount();
        int realNumber = files[0].getFiles().length;
        return count == realNumber;
    }
}