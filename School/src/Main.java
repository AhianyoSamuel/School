import java.io.*;
import java.util.Scanner;

//This is the main class that runs the program. It will be used to call other classes and methods.
public class Main {
    static String line = "--------------------------------------";
    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(System.in);
    
        printWithLines("       Welcome to Earthbound");
        int teacherCode = 1290;
        System.out.println("");
        boolean RUN = true;
        
        printWithLines("Are you a Student or a Teacher? \n"+line+"\n[Press 1] for Student\n[Press 2] for Teacher ");
        while (RUN){
            int userType = reader.nextInt();
            switch (userType) {
                case 1:
                    studentLoop();
                    RUN = false;
                    break;
                case 2:
                    printWithLines("Please input the teacher code");
                    int codeAttempt = reader.nextInt();
                    if (codeAttempt == teacherCode) {
                        teacherLoop();
                        RUN = false;
                    } else {
                        printWithLines("That is not the teacher code; please try again.");
                    }
                    break;
                default:
                    printWithLines("Please choose between student or teacher");
                    break;
            }
        } 
        reader.close();     
    }

    public static void printWithLines(String str){
        System.out.println("\n"+line+"\n"+ str +"\n"+line);
    }

    public static void studentLoop() throws IOException { 
        Scanner reader = new Scanner(System.in);
        printWithLines("Welcome new Student! What is your full name?");
        String name = reader.nextLine();
        printWithLines("What is your Graduation Year?");
        int gradYear = reader.nextInt();
        System.out.println(gradYear);
        Student student = new Student(name, gradYear);

        // test to see what the student id is System.out.print(studentID);

        //This a a preset for the student video
        //test the attendance system
        student.addAttendance(student.getStudentID(), "2023-09-01", "Present");
        student.addAttendance(student.getStudentID(), "2023-09-02", "Absent");
        //test the schedule system
        
    
        if (student.name.equals("Matthew Nienstedt")){

        int[] terms1 = { 1, 2 ,3};
        int[] blocks1 = { 1, 1, 1};
        Course c1 = new Course("AP United States History", 2, terms1, blocks1);
        int[] terms2 = { 2, 3, 4 };
        int[] blocks2 = { 2, 2, 2 };
        Course c2 = new Course("Wind Ensemble", 2, terms2, blocks2);
        int[] terms3 = { 3, 4 };
        int[] blocks3 = { 3, 3 };
        Course c3 = new Course("AP Computer Science", 2, terms3, blocks3);
        int[] terms4 = { 3, 4 };
        int[] blocks4 = { 4, 4 };
        Course c4 = new Course("Enriched Chemistry", 2, terms4, blocks4);
        int[] terms5 = { 1,2};
        int[] blocks5 = { 4,4 };
        Course c5 = new Course("Accellerated Precalculus", 2, terms5, blocks5);
        int[] terms6 = { 1, 2 };
        int[] blocks6 = { 3, 3 };
        Course c6 = new Course("American Literature", 2, terms6, blocks6);
        int[] terms7 = { 1 };
        int[] blocks7 = { 2 };
        Course c7 = new Course("Marching Band", 2, terms7, blocks7);
        int[] terms8 = { 4 };
        int[] blocks8 = { 1 };
        Course c8 = new Course("Music Production", 2, terms8, blocks8);

        student.sch.addCourse(c1);
        student.sch.addCourse(c2);
        student.sch.addCourse(c3);
        student.sch.addCourse(c4);
        student.sch.addCourse(c5);
        student.sch.addCourse(c6);
        student.sch.addCourse(c7);
        student.sch.addCourse(c8);
        student.sch.addGrade(97,2,1,1);
        student.sch.addGrade(98,2,1,2);
        student.sch.addGrade(95,2,1,3);
        student.sch.addGrade(96,2,1,4);
        student.sch.addGrade(95,2,2,1);
        student.sch.addGrade(99,2,2,2);
        student.sch.addGrade(93,2,2,3);
        student.sch.addGrade(93,2,2,4);
        student.sch.addGrade(94,2,3,1);
        student.sch.addGrade(99,2,3,2);
        student.sch.addGrade(98,2,3,3);
        student.sch.addGrade(95,2,3,4);

        }
        


        skibidi: 
        while (true) {
            printWithLines("What would you like to do?\n"+line+"\n[Press 1] to show your Schedule and Grades\n[Press 2] to Display your Attendence\n[Press 3] to get your GPA\n[Press 4] to register for next years class\n[Press 5] to quit");
            int option = reader.nextInt();
            reader.nextLine();
            switch (option) {
                case 1:
                    printWithLines("What year's grades do you want to see?   [9, 10, 11, 12]");
                    int showGradesYear = reader.nextInt();
                    student.sch.showSchedule(showGradesYear-9); // make it so the user enters in a grade that makes sense but we get a grade from 0-3
                    break;
                case 2:
                    student.displayAttendance(student.getStudentID());
                    break;
                case 3:
                    float gpa = student.sch.getGPA();
                    printWithLines("[GPA]   "+ gpa);
                    break;
                case 4:
                    //registrationLoop:
                    printWithLines("What classes would you like to register?\n"+line+"\n[Press ENTER] to see the list of classes\n[Enter a class ID] to apply\n[Press X] to go back");
                    boolean registering = true;
                    while(registering){  
                        
                        String x = reader.nextLine();
                        if (x.toUpperCase().equals("X")){
                            registering = false;
                        }else if (x.equals("")){
                            displayClassIDs();
                        } else {
                            int classID = Integer.parseInt(x);
                            Course newClass = findCourse(classID);
                            newClass.year = student.getYear()-9;
                            int classLength = newClass.blocks.length;
                            boolean space = false;
                            for (int i=0;i<4;i++){
                                int firstEmpty = 100;
                                for (int j=0;j<4;j++){
                                    if (student.sch.schedule[newClass.year+1][j][i].length() < 1){
                                        firstEmpty = j;
                                        break;
                                    }
                                }
                                if (5-firstEmpty > classLength){
                                    for (int k=0; k<classLength; k++){
                                        newClass.terms[k] = firstEmpty+k+1;
                                        newClass.blocks[k] = i+1;
                                    }
                                    student.sch.addCourse(newClass);
                                    space = true;
                                    break;
                                }
                            }
                            if (space){
                                student.sch.showSchedule(newClass.year);
                                System.out.println("Registered: " + newClass.courseName);
                            } else {
                                System.out.println("[Error: no space in schedule]");
                                System.out.println("[Try again]");
                            }
                        }
                    }
                    break;
                case 5:
                    break skibidi;
            }
        }
        reader.close();
    }

    
    public static void teacherLoop() {
        // Create students
        Student student1 = new Student("Samuel Ahianyo", 2026);
        System.out.println(student1.getStudentID());
        Student student2 = new Student("Jishnu Satapathy", 2027);
        System.out.println(student2.getStudentID());
        Student student3 = new Student("Matthew Niesntedt", 2026);
        System.out.println(student3.getStudentID());
        Student student4 = new Student("Nikola Momtchev", 2025);
        System.out.println(student4.getStudentID());

        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome Teacher! What is your full name?");
        String teacherName = reader.nextLine();
        System.out.println("What is your teacher ID.");
        int teacherID = reader.nextInt();

        Teacher teacher = new Teacher(teacherName, teacherID);
        teacher.displayDetails();

        sigma: while (true) {
            System.out.println("What would you like to do?\nPress 1 to enter in a student's grades");
            int teacherChoice = reader.nextInt();
            switch (teacherChoice) {
                case 1:
                    System.out.print("What is the student ID you are making a grade for? ");
                    int teacherInputID = reader.nextInt();

                    // Retrieve the student object based on the ID
                    Student targetStudent = findStudentById(teacherInputID);
                    if (targetStudent == null) {
                        printWithLines("Student not found. Please try again.");
                        break;
                    }

                    boolean gradeSetting = true;
                    while (gradeSetting) {
                        printWithLines("What grade did the student get?");
                        int teacherSetGrade = reader.nextInt();
                        printWithLines("What term did the student take your class?");
                        int teacherTermGrade = reader.nextInt();
                        printWithLines("What block did the student take your class?");
                        int teacherBlockGrade = reader.nextInt();

                        // Add the grade to the student's schedule
                        targetStudent.sch.addGrade(teacherSetGrade, teacherTermGrade, teacherBlockGrade, teacherID);

                        printWithLines("Do you want to add another grade? [yes/no]");
                        String continueInput = reader.next();
                        gradeSetting = continueInput.equalsIgnoreCase("yes");
                    }
                    break;
                case 4:
                    break sigma;
            }
        }
    }

    public static void displayClassIDs()  throws IOException {
        Scanner fileReader = new Scanner(new File("classes.txt"));
        String testStr = "";
        int x, y;
        System.out.println(line);
        while (true){
            testStr = fileReader.nextLine();
            if (testStr.equals("END")){
                break;
            } else {
                x = testStr.indexOf(']');
                y = testStr.indexOf('\\');
                System.out.println(testStr.substring(0,x+1)+"    "+testStr.substring(x+1,y));
            }
        }
        System.out.println(line);
        System.out.println("");
        fileReader.close();
    }
    public static Course findCourse(int classID)  throws IOException {
        Scanner fileReader = new Scanner(new File("classes.txt"));
        boolean search = true;
        int x, y;
        int classLength = 0;
        String idStr, testStr; 
        String className ="";
        while (search){
            testStr = fileReader.nextLine();
            x = testStr.indexOf(']');
            if (x != -1){
                idStr = testStr.substring(1,x);
                if (idStr.equals(classID+"")){
                    search = false; 
                    y = testStr.indexOf("\\");
                    className = testStr.substring(x+1,y);
                    classLength = Integer.parseInt(testStr.charAt(y+1)+"");
                }        
            }
            if (testStr.equals("END")){
                search = false;
            }     
        }
        int[] terms = new int[classLength];
        int[] blocks = new int[classLength];
        Course newClass = new Course(className,-1,terms,blocks);   
        fileReader.close();
        return newClass;
    }

    
    public static Student findStudentById(int studentID) {
    for (Student student : Student.studentList) {
        if (student.getStudentID() == studentID) {
            return student;
        }
    }
    return null; //return null if there is no student
}
}
