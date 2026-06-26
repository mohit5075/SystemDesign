public class Main {
    public static void main(String[] args) {
//        Address address = new Address("Kota","Station");
//        Person p1 = new Person(address,"Mohit");
//        Person p2 = new Person(p1);
//        p2.address.city = "Blr";
//        System.out.println(p1.address.city);
//        Person p3 = new Person(address,"Temp");
//        p3.address.city = "GGC";
//        System.out.println(p1.address.city);
        Child child = new Child();
        String s = "Hello";
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append("sjs");        System.out.println(stringBuilder.toString());
        s.concat("World");
        System.out.println(s);
    }
}