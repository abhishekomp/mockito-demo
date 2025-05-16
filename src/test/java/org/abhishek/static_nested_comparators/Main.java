package org.abhishek.static_nested_comparators;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Create Person objects
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Charlie", 35);

        // Print the persons
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);

        Comparator<Person> nameComparator = new Person.NameComparator();
        Comparator<Person> ageComparator = new Person.AgeComparator();

        // Compare persons by name and age using static nested classes
        System.out.println("Compare by name: " + nameComparator.compare(person1, person2));
        System.out.println("Compare by age: " + ageComparator.compare(person1, person2));

        // Compare persons by name and age using lambda expressions
        Comparator<Person> nameComparatorLambda = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Comparator<Person> ageComparatorLambda = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
        System.out.println("Compare by name (lambda): " + nameComparatorLambda.compare(person1, person2));
        System.out.println("Compare by age (lambda): " + ageComparatorLambda.compare(person1, person2));

        // Sort persons by name and age using static nested classes
        Person[] persons = {person1, person2, person3};
        Arrays.sort(persons, nameComparator);
        System.out.println("Sorted by name:");
        for (Person person : persons) {
            System.out.println(person);
        }

        Arrays.sort(persons, ageComparator);
        System.out.println("Sorted by age:");
        for (Person person : persons) {
            System.out.println(person);
        }
        // Sort persons by name and age using lambda expressions
        Arrays.sort(persons, nameComparatorLambda);
        System.out.println("Sorted by name (lambda):");
        for (Person person : persons) {
            System.out.println(person);
        }

/*        // Compare persons by name
        System.out.println("Comparing by name:");
        System.out.println(new Person.NameComparator().compare(person1, person2));
        System.out.println(new Person.NameComparator().compare(person2, person3));
        System.out.println(new Person.NameComparator().compare(person3, person1));

        // Compare persons by age
        System.out.println("Comparing by age:");
        System.out.println(new Person.AgeComparator().compare(person1, person2));
        System.out.println(new Person.AgeComparator().compare(person2, person3));
        System.out.println(new Person.AgeComparator().compare(person3, person1));*/
    }
}
