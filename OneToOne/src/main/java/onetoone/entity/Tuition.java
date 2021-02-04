package onetoone.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tuition")
public class Tuition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tuition")
    private int idTuition;

    public Tuition(){}

    @Column (name = "fee")
    private Double fee;

    /**
     * En éste caso, la FK la tendrá Tuition (@JoinColumn).
     * Será necesario que Student referencie también (@OneToOne) para hacer la relación bidireccional
     * Posible usar @MapsId en lugar de @JoinColumn: sólo hay una matrícula por estudiante. MapsId especifica que student_id
     *      es PK de Tuition, pero también FK de Student. Ambas entidades compartirán el mismo valor de identificación y no
     *      haría falta @GeneratedValue en Tuition.
     */
    @JoinColumn(name = "student_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

    public int getIdTuition() {
        return idTuition;
    }

    public void setIdTuition(int idTuition) {
        this.idTuition = idTuition;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
