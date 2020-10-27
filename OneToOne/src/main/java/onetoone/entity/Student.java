package onetoone.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_student")
    private int idStudent;


    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    /**
     * - 'mappedBy' establece la relación bidireccional aunque haya sólo una FK
     * - 'orphanRemoval' especifica que la entidad hijo será eliminada si deja de ser referenciada por objeto padre.
     *      P. ej.: Si tenemos una colección de items y eliminamos uno, ese item ha dejado de tener una referencia (será eliminado)
     * - 'cascade': eliminación en cascada (a nivel de DB)
     * - 'fetch = FetchType.LAZY'. Inicialización 'perezosa', recupera la entidad sólo cuando la necesitamos. La sesión debe estar abierta
     *      (si no lo está -> LazyInitializationException)
     */
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Tuition tuition;

    public Student(){}

    //getters & setters
    public int getIdStudent() {
        return idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setIdStudent(int idStudent) { this.idStudent = idStudent; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Tuition getTuition() {
        return tuition;
    }

    public void setTuition(Tuition tuition) {
        this.tuition = tuition;
    }
}
