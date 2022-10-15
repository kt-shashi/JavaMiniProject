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
    }

    void viewStudentlist() {
        if (isEmpty()) {
            System.out.println("No data available");
            return;
        }

        for (Student s : studentArrayList) {
            System.out.println("Name: " + s.name);
            System.out.println("Roll: " + s.roll);
        }
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
        if (isEmpty() || studentArrayList.get(0).date == null) {
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

}

public class Main {
    public static void main(String[] args) {

        AttendanceManagement attendanceManagement = new AttendanceManagement();

        int loop = 1;
        while (loop != 0) {

            Scanner inputHelper = new Scanner(System.in);

            System.out.println();
            System.out.println("Choose: ");
            System.out.println("1. Input student data");
            System.out.println("2. View student list");
            System.out.println("3. Take Attendance");
            System.out.println("4. View Attendance record");
            System.out.println("5. Exit");

            int choice = inputHelper.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter student name: ");
                    String name = inputHelper.next();
                    System.out.println("Enter student roll: ");
                    int roll = inputHelper.nextInt();

                    attendanceManagement.putStudentData(new Student(name, roll));
                }
                break;
                case 2: {
                    attendanceManagement.viewStudentlist();
                }
                break;
                case 3: {
                    attendanceManagement.takeAttendance();
                }
                break;
                case 4: {
                    attendanceManagement.viewAttendance();
                }
                break;
                case 5:
                    loop = 0;
                    break;
                default:
                    System.out.println("Invalid input. Please try again");

            }

        }

    }
}