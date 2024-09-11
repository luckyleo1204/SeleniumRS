import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaPractice {
    @Test
    public void findNumberOfOccurance(){
        String str="TESTING";
        char[] chars=str.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        for(Character i : chars){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(Character i: map.keySet()){
            if(map.get(i)>1)
            System.out.print(i+":"+map.get(i));
        }

    }

    @Test
    public void AAABBCCDDAB(){
        String str="AABBCCDDAB ";
        char[] chars=str.toCharArray();
        String finalString=" ";
        int count=1;
        for(int i=0;i<chars.length-1;i++){
            if(chars[i]==chars[i+1]){
                count++;
            }else{
                finalString+=chars[i]+""+count;
                count=1;
            }
        }
        System.out.println(finalString);
    }

    @Test
    public void findNthMax(){
        //String array[] = { "Geeks", "forGeeks", "A computer Portal" };

        Integer array[]={10,20,30,40,15,12};

        // Print the Array
        System.out.println("Array: "
                + Arrays.toString(array));

        // convert the Array to List
//        List<T> list = convertArrayToList(array);
//        list.stream().forEach(n-> System.out.println(n));
    }

    public static <T> List<T> convertArrayToList(T array[])
    {
        // create a list from the Array
        return Arrays.stream(array).collect(
                Collectors.toList());
    }

    @Test
    public void reverseString(){
        String str="Hello this is Java";
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(str.length()-1-i)+"");
        }
    }

    @Test
    public void LearnearSearch(){
        List<Integer> al=Arrays.asList(10,20,30,40,50);
        Integer m=40;
        Optional<Integer> result=al.stream().filter(n->n.equals(m)).findAny();
       if(result.isPresent())
           System.out.println("Item is found");
        else
           System.out.println("item is not found");

        Assert.assertTrue(result.isPresent(),"Item is found");
    }

    @Test
    public void findDuplicateString(){
        String sentence = "alex brian charles alex charles david eric david";
        List<String> wordsList = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
        Set<String> tempSet = new HashSet<>();
        List<String> duplicateWords = wordsList.stream()
                .filter(w -> !tempSet.add(w))
                .collect(Collectors.toList());
        System.out.println(duplicateWords);
        System.out.println("\n===============================================\n");
        List<String> l=Arrays.asList("Murali","Mohan","Murali","Kushi");
        Set<String> tempSet2 = new HashSet<>();
        l.stream().filter(n->!tempSet2.add(n)).forEach(System.out::println);
        System.out.println("\n===============================================\n");
        Map<String, Integer> ma=l.stream().collect(Collectors.toMap(Function.identity(),word->1,Math::addExact));
        System.out.println(ma);

    }

    @Test
    public void fileDemo1() throws IOException {
        Path filePath = Paths.get("c:/Personal/", "TestData.txt");

        try (Stream<String> lines = Files.lines( filePath )) {
            lines.forEach(System.out::println);
        }

    }

    @Test
    public void fileDemo2(){
        Path filePath = Paths.get("c:/Personal/", "TestData.txt");
        try (Stream<String> lines = Files.lines(filePath)) {

            List<String> filteredLines = lines
                    .filter(s -> s.contains("password"))
                    .collect(Collectors.toList());

            filteredLines.forEach(System.out::println);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileDemo3() throws IOException {
        Path filePath = Paths.get("c:/Personal/", "TestData.txt");
        List<String> lines = Files.readAllLines(filePath);

        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("\n===============================\n");

        File file =new File("c:/Personal/TestData.txt");
        try {
            List<String> lines1 = FileUtils.readLines(file,Charset.defaultCharset());
            lines1.stream().forEach(s-> System.out.println(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void foreachDemo1(){
        List<String> list = Arrays.asList("Alex", "Brian", "Charles");

        list.forEach(System.out::println);

        System.out.println("\n===============================\n");
        Consumer<String> makeUpperCase = new Consumer<String>() {
            @Override
            public void accept(String t) {
                //More statements if needed
                System.out.println(t.toUpperCase());
            }
        };
        list.forEach(makeUpperCase);

    }

    @Test
    public void forEachDemo2(){
        Map<String, String> map = Map.of("A", "Alex", "B", "Brian", "C", "Charles");
        map.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));

        System.out.println("\n===============================\n");

        BiConsumer<String, String> action = (a, b) -> {

            System.out.println("Key is : " + a);
            System.out.println("Value is : " + b);
        };
        map.forEach(action);

    }

    @Test
    public void foreachDemo3(){
        List<Integer> numberList = List.of(1,2,3,4,5);

        Consumer<Integer> action = System.out::println;

        numberList.stream()
                .filter(n -> n%2  == 0)
                .forEach( action );

        numberList.stream()
                .filter(n -> n%2  != 0)
                .parallel()
                .forEachOrdered( action );
    }

    @Test
    public void findDuplicateChar(){
        String input="AUTOMATION";
        HashMap<Character, Integer> hm=new HashMap<Character,Integer>();
        char[] charArray=input.toCharArray();
        for(char c:charArray)
        {
            if(hm.containsKey(c))
            {
                hm.put(c, hm.get(c)+1);
            }
            else
            {
                hm.put(c,1);
            }
        }

        for(char i:hm.keySet())
        {
            System.out.println(i+":"+hm.get(i));
        }

        System.out.println("\n===========================\n");

        Map<Character, Long> mp=input.chars()  // Convert the string to an IntStream of character codes
                .mapToObj(c -> (char) c)  // Convert character codes to characters
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        mp.forEach((character, count) -> System.out.println(character + ": " + count));

    }

    @Test
    public void isPalornot(){
        String str="MALAYALAM";
        boolean ispal=true;
        int n= str.length();
        for(int i=0;i<n/2;i++){
            if(str.charAt(i)!=str.charAt(n-i-1)){
                ispal=false;
                break;
            }
        }
        if(ispal==true)
            System.out.println("String is Palindrome");
        else
            System.out.println("String is not Palindrome");

        System.out.println("\n=====================Approach 2==========================\n");

        String reverse=new StringBuilder(str).reverse().toString();
        if(!str.equals(reverse))
             System.out.println("is not pal");
        else
            System.out.println("is pal string");
    }

    @Test
    public void FirstNonRepatative(){

        String str="swiss";
        Map<Character, Integer> map=new LinkedHashMap<>();
        for(char i: str.toCharArray()){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Character,Integer> j: map.entrySet()){
            if(j.getValue()==1) {
                System.out.println(j.getKey());
                break;
            }
        }
    }
}


