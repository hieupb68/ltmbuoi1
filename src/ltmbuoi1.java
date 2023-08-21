import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ltmbuoi1 {

    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Load student list from file
        students = loadStudentListFromFile();

        // Add new student
        Student student = new Student("SV03", "Pham Ba Hieu", 1);
        students.add(student);

        // Update student data
        student = students.get(0);
        student.setMaSV("SV02");
        student.setHoTen("Tran Thi Hai Yen");
        student.setNhom(2);

        // Save student list to file
        saveStudentsToFile(students);

        // Display student list
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public static List<Student> loadStudentListFromFile() {
        List<Student> studentList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentList =(List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static void saveStudentsToFile(List<Student> students) {
        List<Student> studentList = new ArrayList<>();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("Student list saved to file.");
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Student implements Serializable {

    private String maSV;
    private String hoTen;
    private int nhom;

    public Student(String maSV, String hoTen, int nhom) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.nhom = nhom;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNhom() {
        return nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "maSV='" + maSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", nhom=" + nhom +
                '}';
    }
}