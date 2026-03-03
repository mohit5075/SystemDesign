public class LockExample {
    public synchronized void func1(){
        try{
            Thread.sleep(5000);
            System.out.println("Inside func1");
        }catch (InterruptedException e){
            // handle exception
        }
    }

    public void func2(){
        System.out.println("Inside func2 before lock");
        synchronized (this){
            System.out.println("Inside func1 after lock");
        }
    }

    public void func3(){
        System.out.println("Inside func3");
    }
}
