package org.mv.distrito;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.mv.municipio.Municipio;

@Entity
@Table(name = "distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distrito_id_gen")
    @SequenceGenerator(name = "distrito_id_gen", sequenceName = "distrito_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_municipio", nullable = false)
    private Municipio municipio;

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

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
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