package com.daike.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ernesto
 * @date 2019/12/25
 */
public class DemoTest {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("AAAA", 23));
        persons.add(new Person("BBBB", 13));
        persons.add(new Person("CCCC", 24));
        persons.add(new Person("DDDD", 3));
        persons.add(new Person("FFFF", 2));
        persons.add(new Person("EEEE", 1));
        persons.add(new Person("GGGG", 56));
        persons.add(new Person("KKKK", 26));

        List<Person> sortByAgePersons =
            persons.stream().filter((Person p) -> p.getAge() > 20).collect(Collectors.toList());
        System.out.println(Arrays.toString(persons.toArray()));
        System.out.println("*************************************");
        System.out.println(Arrays.toString(sortByAgePersons.toArray()));
        System.out.println("*************************************");
        List<Person> sortByAgePersons2 =
            persons.parallelStream().filter((Person p) -> p.getAge() > 30).collect(Collectors.toList());
        System.out.println(Arrays.toString(sortByAgePersons2.toArray()));

    }
}

class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
