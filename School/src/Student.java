import java.util.ArrayList;
import java.util.Random;

//This class is for the students. It will hold all of their information and grades.
public class Student {
    public String name;
    public int year;
    public int grade;
    public ArrayList<String> attendanceRecords = new ArrayList<String>();
    Schedule sch = new Schedule();

    public Student(String newName, int gradYear) {
        name = newName;
        year = gradYear;
        switch (gradYear) {
            case 2025:
                grade = 12;
                break;
            case 2026:
                grade = 11;
                break;
            case 2027:
                grade = 10;
                break;
            case 2028:
                grade = 9;
                break;
            case 2029:
                grade = 8; //this is only here so 8th graders can sign up for their first classes
                break;
            default:
                grade = 0;
                break;
        }
    }
    public int getYear() {
        return grade;
    }

    public int generatestudentId(Student user) {
        Random random = new Random();
        int userId = random.nextInt(2000);
        return userId;
    }

    

    
    // everything past here is for attendance
    public void addAttendance(int id, String reason, String date) {
        String attendanceRecord = "The student with the ID: " + id + " has been recorded as '" + reason + "' on "
                + date;
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
            System.out.println("Attendance record not found for ID: " + id);
        }
    }
}