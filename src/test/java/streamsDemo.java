import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamsDemo {

    @Test(enabled = false)
    public void streamFilterDemo(){
        List<String> al= Arrays.asList("Aman","Albert","Don","Mohan","Anand");
        System.out.println(al.stream().filter(n->n.startsWith("A")).count());
        al.stream().filter(n->n.length()>4).forEach(n-> System.out.println(n));
        al.stream().filter(n->n.length()>4).limit(1).forEach(n-> System.out.println(n));
    }

    @Test(enabled = true)
    public void mapDemo(){
        //Manipulate your stream, E.g: filter name ending letter d and convert them to uppercase
        List<String> al= Arrays.asList("Bhavan","Zeea","Don","Amad","Zeebra");
        List<String> al1= Arrays.asList("Amad","Albert","Don Boss","Mohan","Anand");
        al1.stream().filter(n->n.endsWith("d")).map(n->n.toUpperCase())
                .forEach(n-> System.out.println(n));
        System.out.println("\n===============================================\n");

        //Manipulate your stream, E.g:  convert your list them to uppercase
        al1.stream().map(n->n.toUpperCase()).forEach(n-> System.out.println(n));

        System.out.println("\n===============================================\n");
        // filter name start with a and sorted.
        al1.stream().filter(n->n.startsWith("A")).sorted().map(n->n.toUpperCase()).forEach(n-> System.out.println(n));

        System.out.println("\n===============================================\n");
        //mergeing 2 stream.
        Stream<String> newStream= Stream.concat(al1.stream(),al.stream());
        //newStream.map(n->n.toUpperCase()).sorted().forEach(n-> System.out.println(n));

        System.out.println("\n===============================================\n");

        boolean isPresent=newStream.anyMatch(s->s.equalsIgnoreCase("Don"));
        System.out.println(isPresent);
        System.out.println("\n===============================================\n");

        List<Integer> uniqueElement= Arrays.asList(1,2,2,3,4,5,5);
        uniqueElement.stream().distinct().forEach(s-> System.out.println(s));
        System.out.println("\n===============================================\n");
        //sort and provide 3rd index
        List<Integer> li=uniqueElement.stream().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
        System.out.println("\n===============================================\n");

    }
}