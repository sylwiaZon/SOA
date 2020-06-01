import pl.edu.agh.soa.models.*;

public class ClientUsage {
    public static void main(String[] args) {
        Client client = new Client();

        User loggedUser = new User("Login", "password");
        System.out.println("Register user");
        client.register(loggedUser.getLogin(), loggedUser.getPassword());
        System.out.println();
        System.out.println("Login registered user to get token");
        String token = "Bearer " + client.login(loggedUser.getLogin(), loggedUser.getPassword()).trim();
        System.out.println();

        Faculty facultyA = new Faculty("Computer Science");
        Faculty facultyB = new Faculty("Physics");

        System.out.println("Add faculty: ");
        client.addFaculty(facultyA, token);
        System.out.println("Add faculty: ");
        client.addFaculty(facultyB, token);
        System.out.println("Add already existing faculty: ");
        client.addFaculty(facultyB, token);
        System.out.println();

        Professor professorA = new Professor("Piotr", "Janiak");
        Professor professorB = new Professor("Katarzyna", "Cieplak");

        System.out.println("Add professor: ");
        client.addProfessor(professorA, token);
        System.out.println("Add professor: ");
        client.addProfessor(professorB, token);
        System.out.println("Add already existing professor: ");
        client.addProfessor(professorA, token);
        System.out.println();

        Student studentA = new Student("Jan", "Kowalski", 29876, "Computer Science");
        Student studentB = new Student("Anna", "Nowak", 29879, "Physics");

        System.out.println("Add student: ");
        client.addStudent(studentA, token);
        System.out.println("Add student: ");
        client.addStudent(studentB, token);
        System.out.println("Add already existing student: ");
        client.addStudent(studentA, token);
        System.out.println();

        System.out.println("Get all students: ");
        System.out.println(client.getStudents().toString());

        System.out.println("Get all students filtered by faculty: ");
        System.out.println(client.getStudentsByFaculty("Physics").toString());
        System.out.println("Get specified student: ");
        System.out.println(client.getStudent(29876).toString());
        System.out.println();

        System.out.println("Update student: ");
        Student st = new Student("Biedronka");
        client.updateStudent(29879, st, token);

        System.out.println("Update not existing student: ");
        client.updateStudent(25879, st, token);

        System.out.println();

        System.out.println("Delete student: ");
        client.deleteStudent(29879, token);

        System.out.println("Delete not existing student: ");
        client.deleteStudent(25879, token);

        System.out.println();

        Course courseA = new Course("Maths", professorA, 5, 30);
        Course courseB = new Course("English", professorB, 2, 15);

        System.out.println("Add course: ");
        client.addCourse(courseA, token);
        System.out.println("Add course: ");
        client.addCourse(courseB, token);
        System.out.println("Add already existing course: ");
        client.addCourse(courseA, token);
        System.out.println();

        System.out.println("Add courses to student: ");
        client.addCoursesToStudent(29876, courseA, token);
        client.addCoursesToStudent(29876, courseB, token);
        System.out.println("Get courses of specified student:");
        System.out.println(client.getCourses(29876).toString());
        client.getIcon();
        System.out.println("Get protocol buffer response: ");
        System.out.println(client.getProtocolBufferStudent(29876));
    }
}
