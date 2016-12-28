package Chapter_13;

public class Course implements Cloneable {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;
    
    /** Set course name */
    public Course(String courseName) {
        this.courseName = courseName;
    }
    
    /** Add student to course */
    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }
    
    /** Return student's name */
    public String[] getStudents() {
        return students;
    }
    
    /** Return number of students **/
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    
    /** Return course name */
    public String getCourseName() {
        return courseName;
    }
    
    /** Drop student from class */
    public void dropStudent(String student) {
        int dropIndex = -1;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equalsIgnoreCase(student)) {
                dropIndex = i;
                if (dropIndex != -1) {
                    for (i = dropIndex; i < numberOfStudents; i++)
                        students[i] = students[i + 1];
                }
                numberOfStudents--;
            }
        }
    }
    
    @Override
    /** 
     * Override the protected clone method defined in the Object class and
     * strengthen its accessibility 
     * @throws java.lang.CloneNotSupportedException
     */
    public Object clone() {
        try {
            Course courseClone = (Course)super.clone();
            courseClone.students = (String[])(students.clone());
            return courseClone;
        }
        catch (CloneNotSupportedException ex){
            return null;
        }
    }
    
    /** Testing */
    public static void main(String[] args) {
        Course course1 = new Course("Math");
        course1.addStudent("Mike");
        course1.addStudent("Sonya");
        Course course2 = (Course)(course1.clone());
        System.out.println(course2.courseName);
        for (String s : course2.students) {
            if (s != null)
                System.out.println(s);
        }
    }
}
