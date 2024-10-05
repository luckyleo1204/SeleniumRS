package javaPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class studentDemo {
    public static void main(String[] args) {
        List<student> al=new ArrayList<>();
        al.add(new student(40,"Aox",666));
        al.add(new student(35,"Raju",250));
        al.add(new student(38,"Murali",850));
        al.add(new student(30,"zeebra", 350));

        nameSort nameSort=new nameSort();

        Collections.sort(al,nameSort);

        for(student i: al)
        {
            System.out.println(i);
        }


    }


}


class student {
    private int id, Marks;
    private String name;

    public student(int id, String name, int marks){
        this.id=id; this.name=name; this.Marks=marks;
    }

    public int getId() {
        return id;
    }

    public student setId(int id) {
        this.id = id;
        return this;
    }

    public int getMarks() {
        return Marks;
    }

    public student setMarks(int marks) {
        Marks = marks;
        return this;
    }

    public String getName() {
        return name;
    }

    public student setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", Marks=" + Marks +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public boolean compare(student o1, student o2) {
//        return  o1.getId()>o2.getId();
//    }

}

class nameSort implements Comparator<student>{

    @Override
    public int compare(student o1, student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}