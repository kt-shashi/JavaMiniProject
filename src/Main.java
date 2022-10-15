import java.util.Date;

class Student {
    String name;
    int roll;
    String branch;
    Date date;
    boolean isPresent;

    Student(String n, int r, String b, boolean p) {
        name = n;
        roll = r;
        branch = b;
        date = new Date();
        isPresent = p;
    }

}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


    }
}