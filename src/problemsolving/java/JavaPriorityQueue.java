import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Arrays;
/*
 * Create the Student and Priorities classes here.
 */

class Student implements Comparable<Student>{
    private int id;
    private String name;
    private double cgpa;
    
    public Student(String name, double cgpa, int id ){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    @Override
    public int compareTo(Student s) {
        int cmp = Double.compare(s.cgpa, this.cgpa);
        if( cmp == 0 ){
            if(this.name.equals(s.name)) return this.id - s.id;
            else return this.name.compareTo(s.name);
        }
        return cmp;
    }
    
    @Override
    public String toString() {
        return ""+id+" "+name+" "+ cgpa;
    }
    
    public int getId(){ return this.id; }
    public String getName(){ return this.name; }
    public double getCGPA(){ return this.cgpa; }
}

class Priorities{
    private PriorityQueue<Student> queue = new PriorityQueue<>();
    
    public List<Student> getStudents(List<String> events){
        LinkedList<Student> ret = new LinkedList<>();
        for (String s : events) {
            String[] event = s.split("\\s");
            if(event[0].equals("ENTER")){
                queue.add(
                    new Student(
                        event[1],
                        Double.parseDouble(event[2]),
                        Integer.parseInt(event[3]))
                );
                
            }
            else if(event[0].equals("SERVED")){
                queue.poll();
            }
            else return null;
        }
        while(!queue.isEmpty()){
            /* 
            NOTE: In a priority queue, the only guarantee you have is that the head is the lowest                (or greatest, depending on your comparison). The internal structure is not necessarily a             sorted list. Actually, in Java, it's a heap:
            */
            ret.addLast(queue.poll());
        }
        return ret;
    }
}

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}