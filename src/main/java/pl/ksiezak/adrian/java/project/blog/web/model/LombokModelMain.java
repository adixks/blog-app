package pl.ksiezak.adrian.java.project.blog.web.model;

public class LombokModelMain {
    public static void main(String[] args) {
        Student student = new Student("Adrian",21);
//        student.setName("Adrian");
        System.out.println(student);

        Student agata = new Student.StudentBuilder().age(19).name("Agata").build();
        System.out.println(agata);
    }
}
