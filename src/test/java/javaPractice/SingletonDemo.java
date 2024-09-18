package javaPractice;

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton s=Singleton.getInstance();
        s.display();
    }
}


class Singleton{
    private static Singleton sinlgeton=null;

    private Singleton(){

    }

    synchronized public  static Singleton getInstance(){
        if(sinlgeton==null){
           sinlgeton=new Singleton();
        }
        return sinlgeton;
    }

    public void display(){
        System.out.println(Singleton.class.getDeclaredMethods());
    }

}