package javaPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.text.html.HTML.Tag.MAP;

public class Inter {

    public static void main(String[] args) {
//        Map<String,String> map=new HashMap<>();
//        map.put("A","one");
//        map.put("B","two");
//        List<MAP.Entry<String, String>> list=new ArrayList<>();
//        list.add(map);
//        int i=5;
//        Object obj=new Object();

        A a=new A();  a.doit(); /// A
        B b=new B();  b.doti();// B
        A c=new B();  c.doit();//A


    }

}


class A{
    public void doit(){
        System.out.println("A");
    }
}
class B extends A{
    public void doti(){
        System.out.println("B");
    }
}