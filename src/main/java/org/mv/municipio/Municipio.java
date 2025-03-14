package org.mv.municipio;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.mv.departamento.Departamento;

@Entity
@Table(name = "municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipio_id_gen")
    @SequenceGenerator(name = "municipio_id_gen", sequenceName = "municipio_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_departam", nullable = false)
    private Departamento departamento;

    @Column(name = "codigo", nullable = false, length = 3)
    private String codigo;

    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}