// Exception khusus untuk usia hewan negatif
class NegativeAgeException extends Exception {
    public NegativeAgeException(String message) {
        super(message);
    }
}

// Interface untuk perilaku hewan peliharaan
interface PetBehavior {
    void eat();
    void play();
}

// Kelas abstrak hewan peliharaan
abstract class Pet {
    // Atribut
    private String name;
    private int age;

    // Constructor
    public Pet(String name, int age) throws NegativeAgeException {
        if (age < 0) {
            throw new NegativeAgeException("Age cannot be negative.");
        }
        this.name = name;
        this.age = age;
    }

    // Getter dan setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws NegativeAgeException {
        if (age < 0) {
            throw new NegativeAgeException("Age cannot be negative.");
        }
        this.age = age;
    }

    // Metode abstrak yang harus diimplementasikan oleh kelas turunan
    public abstract void makeSound();

    // Metode yang diwarisi oleh kelas turunan
    public void sleep() {
        System.out.println("Zzz...");
    }
}

// Kelas anjing yang merupakan turunan dari Pet
class Dog extends Pet implements PetBehavior {
    // Constructor
    public Dog(String name, int age) throws NegativeAgeException {
        super(name, age);
    }

    // Implementasi metode abstrak
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof woof!");
    }

    // Implementasi metode dari interface
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void play() {
        System.out.println("Dog is playing.");
    }
}

// Kelas kucing yang merupakan turunan dari Pet
class Cat extends Pet implements PetBehavior {
    // Constructor
    public Cat(String name, int age) throws NegativeAgeException {
        super(name, age);
    }

    // Implementasi metode abstrak
    @Override
    public void makeSound() {
        System.out.println("Cat meows: Meow meow!");
    }

    // Implementasi metode dari interface
    @Override
    public void eat() {
        System.out.println("Cat is eating.");
    }

    @Override
    public void play() {
        System.out.println("Cat is playing.");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Membuat objek anjing
            Pet dog = new Dog("Buddy", 3);
            System.out.println("Dog name: " + dog.getName());
            System.out.println("Dog age: " + dog.getAge());
            dog.makeSound();
            ((Dog) dog).eat();
            ((Dog) dog).play();
            dog.sleep();

            System.out.println();

            // Membuat objek kucing
            Pet cat = new Cat("Whiskers", 2);
            System.out.println("Cat name: " + cat.getName());
            System.out.println("Cat age: " + cat.getAge());
            cat.makeSound();
            ((Cat) cat).eat();
            ((Cat) cat).play();
            cat.sleep();
        } catch (NegativeAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
