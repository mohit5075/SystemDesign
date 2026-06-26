public class Person {
    public Address address;
    public String name;
    public Person(Address address, String name){
        this.address = address;
        this.name = name;
    }
    public Person(Person person){
        this.name=person.name;
        this.address = new Address(person.address);
    }
}
