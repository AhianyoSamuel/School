//Creates a class that holds the schedule of courses for each year

public class Schedule {
    String[][][] schedule = new String[4][4][4];
    public Schedule(){   
        for (int i = 0;i<4;i++){
            for (int j=0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    schedule[i][j][k] = "";
                }
            }
        }
    }
    public void addCourse(Course course) {
        for (int i : course.terms) {
            for (int j : course.blocks) {
                schedule[course.year][i - 1][j - 1] = course.courseName;
            }
        }
    }

    public void addGrade(int grade, int year, int term, int block) {        
        schedule[year][term - 1][block - 1] += ": "+grade+" %   ";
    }   
    public int getGrades(int year, int term, int block) {        
        String str = schedule[year][term - 1][block - 1];   
        if (str != null){
            if (str.contains("%")){
            int x = str.indexOf(":");
            int y = str.indexOf("%");
            return Integer.parseInt(str.substring(x+2,y-1));
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    } 
    public float getGPA(){
        int n = 0;
        float grade = 0; 
        for (int i=1;i<5;i++){      
            for (int j=1;j<5;j++){
                for (int k=0;k<4;k++){
                    int g = getGrades(k,j,i);
                    if (g != -1) {
                        n++;
                        grade += getGrades(k,j,i);
                    }                       
                }
            }
        }
        return grade /= 25*n;

    }  
    public void showSchedule(int year) {
        int maxLength = 0;
        int x;
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                x = schedule[year][i][j].length();
                if (x > maxLength) {
                    maxLength = x;
                }
            }
        }
        for (int i=0;i<4*(maxLength+3)+8;i++){
            System.out.print("-");
        }
        System.out.println("");
       
        for (int i = -1; i < 4; i++) {
            if (i>=0){
                System.out.print("[TERM " + (i+1) +"]    ");
            } else {
                System.out.print("              ");
            }
            for (int j = 0; j < 4; j++) {
                if (i==-1){
                    System.out.print("[BLOCK "+ (j+1) +"]");
                    for (int k=0;k<maxLength-9;k++){
                        System.out.print(" "); 
                    }   
                    System.out.print("   ");    
                } else {
                    String str = schedule[year][i][j];
                    System.out.print(str + "   ");
                    for (int k=0;k<maxLength - str.length();k++){
                        System.out.print(" "); 
                    }       
                }      
            }
            System.out.println("");
        }
        for (int i=0;i<4*(maxLength+3)+8;i++){
            System.out.print("-");
        }
        System.out.println("");
    }
}