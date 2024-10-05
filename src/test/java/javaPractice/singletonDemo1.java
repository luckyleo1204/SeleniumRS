package javaPractice;

 class singleton1 {
    public static singleton1 singleton1;

    private singleton1(){}

   synchronized public static singleton1 getinstnance(){
        if(singleton1==null){
            singleton1= new singleton1();
        }
        return  singleton1;
    }

    public void display(){
        System.out.println(singleton1.getClass().getName());
    }
}

public class singletonDemo1 {

    public static void main(String[] args) {
        singleton1 singleton= singleton1.getinstnance();
        singleton.display();

    }
}