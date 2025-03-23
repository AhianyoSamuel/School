//import java.util.ArrayList;

//This class
public class Course{
    String courseName;
    int[] blocks = new int[4];
    int[] terms = new int[4];
    int year;

    public Course(String courseName_, int year_,int[] terms_, int[] blocks_){
        int classLength = terms_.length;
        blocks = new int[classLength];
        terms = new int[classLength];
        blocks = blocks_;
        terms = terms_;
        year = year_;
        courseName = courseName_;
    }
}