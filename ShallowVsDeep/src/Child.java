public class Child extends Parent{
    public Child(){
        this(20);
        System.out.println("child defalut constructor called");
    }
    public Child(int age) {
        System.out.println("child param constructor called");
    }
}
