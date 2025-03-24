import java.util.ArrayList;
import java.util.Random;

//This class is for the students. It will hold all of their information and grades.
public class Student {
    public String name;
    public int year;
    public int grade;
    public int studentID; //store the student id hre
    public ArrayList<String> attendanceRecords = new ArrayList<>();
    Schedule sch = new Schedule();

    public static ArrayList<Student> studentList = new ArrayList<>();

    public Student(String newName, int gradYear) {
        name = newName;
        year = gradYear;
        grade = switch (gradYear) {
            case 2025 -> 12;
            case 2026 -> 11;
            case 2027 -> 10;
            case 2028 -> 9;
            case 2029 -> 8; // this is only here so 8th graders can sign up for their first classes
            default -> 0;//ERROR
        };
        this.studentID = generateStudentID(); // Generate and store the student ID
        studentList.add(this);
    }

    public int getYear() {
        return grade;
    }

    // Generate a random student ID
    private int generateStudentID() {
        Random random = new Random();
        return random.nextInt(2000); // Generate a random ID between 0 and 1999
    }

    // Getter for the student ID
    public int getStudentID() {
        return studentID;
    }

    // Attendance methods
    public void addAttendance(int id, String reason, String date) {
        String attendanceRecord = "The student with the ID: " + id + " has been recorded as '" + reason + "' on " + date;
        attendanceRecords.add(attendanceRecord);
        System.out.println("You have added: " + attendanceRecord);
    }

    public void displayAttendance(int id) {
        boolean recordFound = false;
        for (String record : attendanceRecords) {
            if (record.contains("ID: " + id)) {
                System.out.println(record);
                recordFound = true;
            }
        }
        if (!recordFound) {
            System.out.println("Attendance record not found for ID: " + id); //ERROR
        }
    }
}