package javaPractice;

import org.testng.annotations.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class test {
    @Test
    public void p1(){
        List<String> l= Arrays.asList("Murali","Mohan","Murali","Kushi");
        Set<String> st1=new HashSet<>();
        l.stream().filter(n->!st1.add(n)).forEach(System.out::println);

    }

    @Test
    public void p2(){

        List<String> l= Arrays.asList("Murali","Mohan","Murali","Kushi","Mohan","Kushi12");
        Set<String> st1=new HashSet<>();
        for(String i: l){
            if(!st1.add(i)){
                System.out.println(i);
            }
        }
    }

    @Test
    public void p3(){
        List<String> l= Arrays.asList("Murali","Mohan","Murali","Kushi","Mohan","Kushi12");
        Map<String, Integer> ma=l.stream().collect(Collectors.toMap(Function.identity(), word->1,Math::addExact));
        System.out.println(ma);
    }


    @Test
    public void biConsumer(){
        //BiConsumer is functional Interface,
        BiConsumer<Integer,Integer> biConsumer=(a,b)-> System.out.println(a+b);
        biConsumer.accept(5,4);
    }
}
