package search;

public class Person implements Comparable<Person>{
    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    int age;

    public Person(int age) {
        this.age = age;
    }
}
