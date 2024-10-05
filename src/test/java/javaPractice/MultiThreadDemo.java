package javaPractice;

public class MultiThreadDemo {

    /* Notes:
    If we extend the Thread class, our class cannot extend any other class
    because Java doesn’t support multiple inheritance.
    But, if we implement the Runnable interface, our class can still extend other base classes.
We can achieve basic functionality of a thread by extending Thread class
because it provides some inbuilt methods like yield(), interrupt() etc.
that are not available in Runnable interface.
Using runnable will give you an object that can be shared amongst multiple threads.
     */

    public static void main(String[] args) {

        int n=8;
        for(int i=0;i<n;i++) {
            Multithread obj=new Multithread();
            obj.start();
        }

        for(int i=0;i<n;i++){
            Thread obj=new Thread(new threadByRunnable());
            obj.start();
        }
    }

}


class Multithread extends Thread{
    public void run(){
        try {
            System.out.println(
                    "Thread " + Thread.currentThread().getName()
                            + " is running");
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}

class threadByRunnable implements  Runnable{

    @Override
    public void run() {
        try {
            System.out.println(
                    "Thread " + Thread.currentThread().getName()
                            + " is running");
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
    }
}