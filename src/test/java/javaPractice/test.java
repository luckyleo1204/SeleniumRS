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

    @Test
    public void testPrractice(){
        List<Integer> al=Arrays.asList(10,20,30,40,50);
        int m=42;
        Optional<Integer> result=al.stream().filter(n->n.equals(m)).findAny();
        if(result.isPresent())
            System.out.println("No is found");
        else
            System.out.println("No is not found");

    }

    @Test
    public void testPracticr2(){
        String sentence = "alex brian charles alex charles david eric david";
        List<String> al=Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
        Set<String> set=new HashSet<>();
        List<String> duplist=al.stream().filter(n->!set.add(n)).collect(Collectors.toList());
        System.out.println(duplist);

    }

    @Test
    public void testPractice3(){
        List<String> l=Arrays.asList("Murali","Mohan","Murali","Kushi");
        Set<String> set=new HashSet<>();
        l.stream().filter(n->!set.add(n)).forEach(n-> System.out.println(n));

       Map<String, Integer> map=l.stream().collect(Collectors.toMap(Function.identity(),word->1,Math::addExact));
        System.out.println(map);

        System.out.println("\n===================================\n");
        String input="TESTING";
        Map<String, Long> output = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Output : "+output);
        System.out.println("\n===================================\n");

    }


    @Test
    public void AAABBCCDDAB(){
        String str="AAABBCCDDAB ";
        StringBuilder sb=new StringBuilder();
        int count=1;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                count++;
            }else{
                sb= sb.append(str.charAt(i)).append(count);
                count=1;
            }
        }
        System.out.println(sb);
    }

    @Test
    public void palindrom1(){
        String str="MALAYALAM";
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        if(str.equals(sb.toString()))
            System.out.println("String is pal");
        else
            System.out.println("String is not pal");

    }

    @Test
    public void palsecondApproach2(){
        String str="MALAYALAM"; boolean ispal=true;
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                ispal=false;
                break;
            }
        }
        if(ispal==true)
            System.out.println("String is pal");
        else
            System.out.println("String is not pal");
    }

    @Test
    public void countNumberChars(){
        String input="TESTING";
        char[] c=input.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(char i: c){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.put(i, map.get(i)+1);
            }
        }

        for(Map.Entry<Character, Integer> i: map.entrySet()){
            if(i.getValue()>1)
                System.out.println(i.getKey()+":"+i.getValue());

            }
        }

        @Test
    public void approach2(){
            String str="TESTING";
            Map<Character, Integer> map=new HashMap<>();

            for(char i: str.toCharArray()){
                map.put(i,map.getOrDefault(i, 0)+1);
            }

            for(Map.Entry<Character,Integer> i: map.entrySet()){
                if(i.getValue()>1){
                    System.out.println(i.getKey()+":"+i.getValue());
                }
            }
        }

        @Test
    public void highestProduct(){
            int[] arr={-40,20,10,5,8,25,30,8};
            int maxProduct=0; int x=0,y=0;
            for(int i=0;i<arr.length;i++){
                for(int j=i+1;j<arr.length;j++){
                    if(arr[i]*arr[j]>maxProduct){
                        maxProduct=arr[i]*arr[j];
                        x=arr[i];
                        y=arr[j];
                    }
                }
            }
            System.out.println(x+":"+y+":"+maxProduct);

        }

        @Test
    public void intToRoman(){
        Map<Character,Integer> map=new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            int result=0;
            String s="MDCCLX";
            for (int i = 0; i < s.length(); i++) {

                // Checking that current element
                // is not smaller then previous
                if (i > 0
                        && map.get(s.charAt(i))
                        > map.get(s.charAt(i - 1))) {
                    result += map.get(s.charAt(i))
                            - 2 * map.get(s.charAt(i - 1));
                }
                else {
                    result += map.get(s.charAt(i));
                }
            }
            System.out.println(result);


        }


        @Test
        public void findEvenNosAndSort(){
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        list.stream().filter(n->n%2==0).sorted().forEach(System.out::println);
    }

    @Test
    public void CountNoofChars(){
       // String s = "string data to count each character";
        String s="TESTING";
        Map map = Arrays.stream(s.split("")) .map(String::toLowerCase)
                .collect(Collectors .groupingBy(str -> str, LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);

    }

    @Test
    public void test2(){
        String str="Kushi";
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(str.length()-i-1)+"\t");
        }
    }

    @Test
    public void commonElement(){
        int[] arr1={4,3,7,9,2};
        int[] arr2={5,9,3,7,4};

        for(int i=0;i< arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr1[i]==arr2[j]){
                    System.out.print(arr1[i]+"\t");
                }
            }
        }
    }


    @Test
    public void reverseSort(){
        ArrayList<String> al=new ArrayList<>();
        al.add("ABC");al.add("XYZ");al.add("MNP");
        Comparator<String> com=(o1,o2)->o1.compareTo(o2);
        Collections.sort(al,com);
        for(String i: al)
            System.out.println(i);
        System.out.println("\n==========================================\n");
        al.stream().sorted().forEach(System.out::println);
        System.out.println("\n==========================================\n");
        al.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

    }




    }


