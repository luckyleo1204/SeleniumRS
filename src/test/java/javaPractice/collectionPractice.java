package javaPractice;

import org.testng.annotations.Test;

import java.util.*;

public class collectionPractice {

    @Test
    public void StringToInt(){
        Set<String> setOfString = new HashSet<>(
                Arrays.asList("1", "2", "3", "4", "5"));
        setOfString.stream().map(n->Integer.parseInt(n)).forEach(System.out::println);

    }

    @Test
    public void StringtoChar(){
        String str = "HelloGeeks";
       for(char i: str.toCharArray()){
           System.out.print(i+"\t");
       }

        System.out.println("\n=====================\n");
       char[] arr = new char[str.length()];
       for(int i=0;i<str.length();i++){
             arr[i]= str.charAt(i);
       }
        System.out.println(arr);
    }


    @Test
    public void ListOfMap(){
        Map<String, List<String>> m = Collections.singletonMap(
                "list1", Arrays.asList("s1", "s2", "s3"));

        for (Map.Entry<String, List<String>> me : m.entrySet()) {
            String key = me.getKey();
            List<String> valueList = me.getValue();
            System.out.println("Key: " + key);
            System.out.print("Values: ");
            for (String s : valueList) {
                System.out.print(s + " ");
            }
        }

        System.out.println("\n====================================\n");

        m.entrySet().forEach(me -> {
            System.out.println("Key: " + me.getKey());
            System.out.print("Values: ");
            me.getValue().forEach(s -> System.out.print(s + " "));
        });
    }
}
