import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class StudentJTK {
    public static class Student<T> implements Comparable<Student<T>> {
        private String studentID;
        private String name;
        private String address;
        private T department;

        public Student(String studentID, String name, String address, T department) {
            this.studentID = studentID;
            this.name = name;
            this.address = address;
            this.department = department;
        }

        public String getStudentID() {
            return studentID;
        }

        public void setStudentID(String studentID) {
            this.studentID = studentID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public T getDepartment() {
            return department;
        }

        public void setDepartment(T department) {
            this.department = department;
        }

        @Override
        public String toString() {
            return String.format("Student{id='%s', name='%s', address='%s', department=%s}",
                    studentID, name, address, department);
        }

        @Override
        public int compareTo(Student<T> other) {
            return this.name.compareToIgnoreCase(other.name);
        }
    }

    public static void main(String[] args) {
        List<Student<String>> studentsList = new ArrayList<>();
        studentsList.add(new Student<>("S001", "Rizky Satria", "Bandung", "Teknik Informatika"));
        studentsList.add(new Student<>("S002", "Andi Putra", "Jakarta", "Sistem Informasi"));
        studentsList.add(new Student<>("S003", "Yazid Alrasyid", "Bangka Belitung", "Teknik Komputer"));
        studentsList.add(new Student<>("S004", "Muhamad Syahid", "Padang", "Manajemen Informatika"));
        studentsList.add(new Student<>("S005", "Ikhsan Satriadi", "Semarang", "Teknik Informasi"));

        Collections.sort(studentsList);
        System.out.println("Daftar mahasiswa (ArrayList) setelah diurutkan berdasarkan nama:");
        for (Student<String> student : studentsList) {
            System.out.println(student);
        }

        Vector<Student<String>> studentVector = new Vector<>();
        studentVector.add(new Student<>("V001", "Arman", "Bandung", "Computer Science"));
        studentVector.add(new Student<>("V002", "Farah", "Bogor", "Information Systems"));
        studentVector.add(new Student<>("V003", "Gita", "Depok", "Computer Science"));
        studentVector.add(new Student<>("V004", "Hadi", "Bogor", "Software Engineering"));
        studentVector.add(new Student<>("V005", "Intan", "Bekasi", "Data Science"));

        System.out.println("\nMahasiswa di departemen Computer Science (Vector):");
        for (Student<String> student : studentVector) {
            if ("Computer Science".equalsIgnoreCase(student.getDepartment())) {
                System.out.println(student);
            }
        }
    }
}
