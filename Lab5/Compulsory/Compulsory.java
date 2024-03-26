package Compulsory;

public class Compulsory {
    public static void main(String[] args) {
        DocumentRepository repository = new DocumentRepository("D:\\facultate\\3E4-2\\Java\\Lab5");

        Person person1 = new Person("Person1", "1");
        Person person2 = new Person("Person2", "2");
        Person person3 = new Person("Person3", "3");
        Person person4 = new Person("Person4", "4");
        Person person5 = new Person("Person5", "5");
        Person person6 = new Person("Person6", "6");
        Person person7 = new Person("Person7", "7");

        repository.addPerson(person1);
        repository.addPerson(person2);
        repository.addPerson(person3);
        repository.addPerson(person4);
        repository.addPerson(person5);
        repository.addPerson(person6);
        repository.addPerson(person7);

        repository.displayRepositoryContents();
    }
}

