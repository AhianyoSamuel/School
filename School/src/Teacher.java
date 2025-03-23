public class Teacher {
    public String name;
    public int teacherId;

    // Constructor
    public Teacher(String newName, int newteacherID) {
        name = newName;
        teacherId = newteacherID;
    }

    // display the stuff once we get it from the teacher
    public void displayDetails() {
        System.out.println("Now loading for:");
        System.out.println("Name: " + name);
        System.out.println("Teacher ID: " + teacherId);
    }
}
