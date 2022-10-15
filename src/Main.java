import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

class Student {
    String name;
    int roll;
    Date date;
    boolean isPresent;

    Student(String n, int r) {
        name = n;
        roll = r;
        isPresent = false;
    }

}

class AttendanceManagement {

    ArrayList<Student> studentArrayList = new ArrayList<>();

    void putStudentData(Student student) {
        studentArrayList.add(student);
        sort(studentArrayList);
    }

    void takeAttendance() {
        if (isEmpty()) {
            System.out.println("No data available");
            return;
        }

        System.out.println("Attendance on " + (new Date()));

        for (Student s : studentArrayList) {
            s.date = new Date();

            System.out.println("Is roll " + s.roll + " present? y:yes,n:no");

            Scanner sc = new Scanner(System.in);
            char ch = sc.next().charAt(0);

            if (ch == 'y') {
                s.isPresent = true;
            } else
                s.isPresent = false;
        }
    }

    void viewAttendance() {
        if (isEmpty()) {
            System.out.println("No data available");
            return;
        }

        for (Student s : studentArrayList) {
            System.out.println("Name: " + s.name);
            System.out.println("Roll: " + s.roll);
            System.out.println("Date: " + s.date.toString());
            System.out.println("Present: " + ((s.isPresent == true) ? "Yes" : "NO"));
        }
    }

    boolean isEmpty() {
        return studentArrayList.size() == 0 ? true : false;
    }

    public static void sort(ArrayList<Student> list) {

        list.sort(Comparator.comparing(o -> o.date));

    }
}
