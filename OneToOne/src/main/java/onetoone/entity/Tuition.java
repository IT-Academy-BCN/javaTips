package onetoone.entity;

import javax.persistence.*;
import java.io.Serializable;

/*@Entity
@Table(name = "tuition")*/
public class Tuition implements Serializable {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tuition")*/
    private Long id;

    public Tuition(){}


    /*
    private Double fee;

        // Que columna en la tabla Tuition tiene la FK
        @JoinColumn(name = "student_id")
        @OneToOne(fetch = FetchType.LAZY)
        private Student student;*/




}
