import pl.edu.agh.soa.models.Student;
import pl.edu.agh.soa.models.User;

public class ClientUsage {
    public static void main(String[] args) {
        Client client = new Client();

        User loggedUser = new User("Login", "password");
        client.register(loggedUser.getLogin(), loggedUser.getPassword());
        String token = client.login(loggedUser.getLogin(), loggedUser.getPassword()).trim();

        Student studentA = new Student("Jan", "Kowalski", 29876, "Computer Science");
        Student studentB = new Student("Anna", "Nowak", 29879, "Physics");

        client.addStudent(studentA, token);
        client.addStudent(studentB, token);
        System.out.println(client.getStudents());
        System.out.println(client.getStudentsByFaculty("Physics"));
        System.out.println(client.getStudent(29876));
    }
}
