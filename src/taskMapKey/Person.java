package taskMapKey;

import java.util.HashMap;

public class Person {
    String name;

    public String getName() {
        return name;
    }

    Person(String name){
        this.name=name;
    }

    @Override
    public int hashCode(){
        return name.toLowerCase().hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return person.name.toLowerCase().equals(name.toLowerCase());
    }

    public static void main(String[] args) {
        Person p1 = new Person("Вася");
        Person p2 = new Person("вася");
        HashMap<Person, String> person = new HashMap<>();
        person.put(p1, "Крутой");
        System.out.println(person.get(p2));
    }
}
