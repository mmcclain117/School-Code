package Other;


/**
 *
 * @author Master
 */
public class Main {

    public static void main(String[] args) {
        Animal an = new Animal();
        an.setAge(16); // Set age
        System.out.println(an);
        Animal dog = new Mammal("dog", 15);
        dog.setAge(11); // Uses setAge of Animal
        System.out.println(dog.age); // Public part of animal
        Mammal cat = new Mammal("Cat", 50);
        cat.setAge(10); // Animal Set age and drops to other one
//        System.out.println(cat.age);
        System.out.println("ab".compareTo("ac"));
        System.out.println(6 >> 2);
        System.out.println(12 << 3);

    }
}

class Animal {

    public int age;

    public Animal() {
        age = 5;
    }

    public Animal(int a) {
        age = a;
    }

    public void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Age: " + age;
    }
}

class Mammal extends Animal {

    private String species;
    private int age;

    public Mammal(String s, int a) {
        species = s;
        age = a;
    }

    public String getSpecies() {
        return species;
    }

//    @Override
    public int getAge() {
        return age;
    }

    public void setAge() {
        age = 20;
    }

    public String toString() {
        return "Age: " + this.age + " Species:" + this.species;
    }
}
