public class SingletonClass {
    private static SingletonClass singletonClassobj = null;
    private SingletonClass(){
    }
    public static SingletonClass getInstance(){
        if(singletonClassobj==null){
            synchronized (SingletonClass.class) {
                if(singletonClassobj==null) {
                    singletonClassobj = new SingletonClass();
                }
            }
        }
        return singletonClassobj;
    }
}
