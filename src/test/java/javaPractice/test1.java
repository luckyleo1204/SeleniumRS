package javaPractice;

public class test1 {
    public static void main(String[] args) {
//        A1 a=new A1(); a.display();
//        A1 b=new B1(); b.display();
//        A1b1=new B(); b1.displayed();b1.display();
    }
}

class A1{
    void display(){
        System.out.println("PArent class A");
    }
}

class B1 extends A{
    void displayed(){
        System.out.println("Child class method");
    }
}
