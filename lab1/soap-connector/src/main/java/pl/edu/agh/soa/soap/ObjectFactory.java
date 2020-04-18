
package pl.edu.agh.soa.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.edu.agh.soa.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddCourseToStudent_QNAME = new QName("http://soap.soa.agh.edu.pl/", "addCourseToStudent");
    private final static QName _AddCourseToStudentResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "addCourseToStudentResponse");
    private final static QName _AddStudent_QNAME = new QName("http://soap.soa.agh.edu.pl/", "addStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "addStudentResponse");
    private final static QName _DeleteStudent_QNAME = new QName("http://soap.soa.agh.edu.pl/", "deleteStudent");
    private final static QName _DeleteStudentResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "deleteStudentResponse");
    private final static QName _GetAllStudents_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getAllStudents");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getAllStudentsResponse");
    private final static QName _GetIcon_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getIcon");
    private final static QName _GetIconResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getIconResponse");
    private final static QName _GetStudent_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudent");
    private final static QName _GetStudentResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentResponse");
    private final static QName _GetStudentsByCourse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentsByCourse");
    private final static QName _GetStudentsByCourseResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentsByCourseResponse");
    private final static QName _GetStudentsByFaculty_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentsByFaculty");
    private final static QName _GetStudentsByFacultyResponse_QNAME = new QName("http://soap.soa.agh.edu.pl/", "getStudentsByFacultyResponse");
    private final static QName _Student_QNAME = new QName("http://soap.soa.agh.edu.pl/", "student");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.edu.agh.soa.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link AddCourseToStudent }
     * 
     */
    public AddCourseToStudent createAddCourseToStudent() {
        return new AddCourseToStudent();
    }

    /**
     * Create an instance of {@link AddCourseToStudentResponse }
     * 
     */
    public AddCourseToStudentResponse createAddCourseToStudentResponse() {
        return new AddCourseToStudentResponse();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link DeleteStudent }
     * 
     */
    public DeleteStudent createDeleteStudent() {
        return new DeleteStudent();
    }

    /**
     * Create an instance of {@link DeleteStudentResponse }
     * 
     */
    public DeleteStudentResponse createDeleteStudentResponse() {
        return new DeleteStudentResponse();
    }

    /**
     * Create an instance of {@link GetAllStudents }
     * 
     */
    public GetAllStudents createGetAllStudents() {
        return new GetAllStudents();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse }
     * 
     */
    public GetAllStudentsResponse createGetAllStudentsResponse() {
        return new GetAllStudentsResponse();
    }

    /**
     * Create an instance of {@link GetIcon }
     * 
     */
    public GetIcon createGetIcon() {
        return new GetIcon();
    }

    /**
     * Create an instance of {@link GetIconResponse }
     * 
     */
    public GetIconResponse createGetIconResponse() {
        return new GetIconResponse();
    }

    /**
     * Create an instance of {@link GetStudent }
     * 
     */
    public GetStudent createGetStudent() {
        return new GetStudent();
    }

    /**
     * Create an instance of {@link GetStudentResponse }
     * 
     */
    public GetStudentResponse createGetStudentResponse() {
        return new GetStudentResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByCourse }
     * 
     */
    public GetStudentsByCourse createGetStudentsByCourse() {
        return new GetStudentsByCourse();
    }

    /**
     * Create an instance of {@link GetStudentsByCourseResponse }
     * 
     */
    public GetStudentsByCourseResponse createGetStudentsByCourseResponse() {
        return new GetStudentsByCourseResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByFaculty }
     * 
     */
    public GetStudentsByFaculty createGetStudentsByFaculty() {
        return new GetStudentsByFaculty();
    }

    /**
     * Create an instance of {@link GetStudentsByFacultyResponse }
     * 
     */
    public GetStudentsByFacultyResponse createGetStudentsByFacultyResponse() {
        return new GetStudentsByFacultyResponse();
    }

    /**
     * Create an instance of {@link Course }
     * 
     */
    public Course createCourse() {
        return new Course();
    }

    /**
     * Create an instance of {@link Student.Courses }
     * 
     */
    public Student.Courses createStudentCourses() {
        return new Student.Courses();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourseToStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCourseToStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "addCourseToStudent")
    public JAXBElement<AddCourseToStudent> createAddCourseToStudent(AddCourseToStudent value) {
        return new JAXBElement<AddCourseToStudent>(_AddCourseToStudent_QNAME, AddCourseToStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourseToStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCourseToStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "addCourseToStudentResponse")
    public JAXBElement<AddCourseToStudentResponse> createAddCourseToStudentResponse(AddCourseToStudentResponse value) {
        return new JAXBElement<AddCourseToStudentResponse>(_AddCourseToStudentResponse_QNAME, AddCourseToStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "deleteStudent")
    public JAXBElement<DeleteStudent> createDeleteStudent(DeleteStudent value) {
        return new JAXBElement<DeleteStudent>(_DeleteStudent_QNAME, DeleteStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "deleteStudentResponse")
    public JAXBElement<DeleteStudentResponse> createDeleteStudentResponse(DeleteStudentResponse value) {
        return new JAXBElement<DeleteStudentResponse>(_DeleteStudentResponse_QNAME, DeleteStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getAllStudents")
    public JAXBElement<GetAllStudents> createGetAllStudents(GetAllStudents value) {
        return new JAXBElement<GetAllStudents>(_GetAllStudents_QNAME, GetAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getAllStudentsResponse")
    public JAXBElement<GetAllStudentsResponse> createGetAllStudentsResponse(GetAllStudentsResponse value) {
        return new JAXBElement<GetAllStudentsResponse>(_GetAllStudentsResponse_QNAME, GetAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIcon }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetIcon }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getIcon")
    public JAXBElement<GetIcon> createGetIcon(GetIcon value) {
        return new JAXBElement<GetIcon>(_GetIcon_QNAME, GetIcon.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetIconResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetIconResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getIconResponse")
    public JAXBElement<GetIconResponse> createGetIconResponse(GetIconResponse value) {
        return new JAXBElement<GetIconResponse>(_GetIconResponse_QNAME, GetIconResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudent")
    public JAXBElement<GetStudent> createGetStudent(GetStudent value) {
        return new JAXBElement<GetStudent>(_GetStudent_QNAME, GetStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentResponse")
    public JAXBElement<GetStudentResponse> createGetStudentResponse(GetStudentResponse value) {
        return new JAXBElement<GetStudentResponse>(_GetStudentResponse_QNAME, GetStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByCourse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByCourse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentsByCourse")
    public JAXBElement<GetStudentsByCourse> createGetStudentsByCourse(GetStudentsByCourse value) {
        return new JAXBElement<GetStudentsByCourse>(_GetStudentsByCourse_QNAME, GetStudentsByCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByCourseResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByCourseResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentsByCourseResponse")
    public JAXBElement<GetStudentsByCourseResponse> createGetStudentsByCourseResponse(GetStudentsByCourseResponse value) {
        return new JAXBElement<GetStudentsByCourseResponse>(_GetStudentsByCourseResponse_QNAME, GetStudentsByCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByFaculty }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByFaculty }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentsByFaculty")
    public JAXBElement<GetStudentsByFaculty> createGetStudentsByFaculty(GetStudentsByFaculty value) {
        return new JAXBElement<GetStudentsByFaculty>(_GetStudentsByFaculty_QNAME, GetStudentsByFaculty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByFacultyResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByFacultyResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "getStudentsByFacultyResponse")
    public JAXBElement<GetStudentsByFacultyResponse> createGetStudentsByFacultyResponse(GetStudentsByFacultyResponse value) {
        return new JAXBElement<GetStudentsByFacultyResponse>(_GetStudentsByFacultyResponse_QNAME, GetStudentsByFacultyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Student }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Student }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap.soa.agh.edu.pl/", name = "student")
    public JAXBElement<Student> createStudent(Student value) {
        return new JAXBElement<Student>(_Student_QNAME, Student.class, null, value);
    }

}
