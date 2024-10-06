package javaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class employeeGroupingDemo {
    public static void main(String[] args) {

        List<Employee> al=new ArrayList<>();
        al.add(new Employee("Murali",1,"Banagalore",30));
        al.add(new Employee("Anand",5,"Banagalore",29));
        al.add(new Employee("Kushi",2,"California",25));
        al.add(new Employee("Kavitha",3,"New York",28));
        al.add(new Employee("Harshi ",4,"Banagalore",22));

      Map<String, List<Employee>> map=  al.stream().collect(Collectors.groupingBy(Employee::getPlace));

      map.forEach((key,value)-> System.out.println("City:"+key+"\tEmployess data:"+value));

        System.out.println("\nEmployee List Before Sorting\n");
        al.forEach(n-> System.out.println(n.getName()+"\t:"+n.getPlace()));
        System.out.println("\nEmployee List After Sorting\n");
        al.sort(Comparator.comparing(Employee::getName));
        al.forEach(n-> System.out.println(n.getName()+"\t:"+n.getPlace()));
        System.out.println("\nEmployee List After reverse Sorting\n");
        al.sort(Comparator.comparing(Employee::getName).reversed());
        al.forEach(n-> System.out.println(n.getName()+"\t:"+n.getPlace()));
        System.out.println("\nEmployee List After Grouping Sort(Sort by City, Name) Sorting\n");
         Comparator<Employee> groupComp= Comparator.comparing(Employee::getPlace)
                            .thenComparing(Employee::getName);
         al.sort(groupComp);
        al.forEach(n-> System.out.println(n.getName()+"\t:"+n.getPlace()));

        System.out.println("\nFilter Employee who's age is less than 27\n");

        List<Employee> emplistAgeGreater=al.stream().filter(n->n.getAge()<27).collect(Collectors.toList());
        emplistAgeGreater.forEach(emp-> System.out.println(emp));

        System.out.println("\n Print All the employee Names\n");

        List<String> empName=al.stream().map(Employee::getName).collect(Collectors.toList());
        empName.forEach(emp-> System.out.println(emp));














    }
}


class Employee{
    private String name;
    private int id;
    private String place;

    public int getAge() {
        return age;
    }

    public Employee setAge(int age) {
        this.age = age;
        return this;
    }

    private int age;

    public Employee(String name, int id, String place, int age) {
        this.name = name;
        this.id = id;
        this.place = place;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public Employee setPlace(String place) {
        this.place = place;
        return this;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", place='" + place + '\'' +
                ", age=" + age +
                '}';
    }
}