package com.aincorp.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author almaz
 */
@Entity
@Table(name = "result")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r")
        , @NamedQuery(name = "Result.findById", query = "SELECT r FROM Result r WHERE r.id = :id")
        , @NamedQuery(name = "Result.findByCode", query = "SELECT r FROM Result r WHERE r.code = :code")
        , @NamedQuery(name = "Result.findByNumber", query = "SELECT r FROM Result r WHERE r.number = :number")
        , @NamedQuery(name = "Result.findByFilenames", query = "SELECT r FROM Result r WHERE r.filenames = :filenames")
        , @NamedQuery(name = "Result.findByError", query = "SELECT r FROM Result r WHERE r.error = :error")})
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Size(max = 50)
    @Column(name = "code")
    private String code;
    @Column(name = "number")
    private Integer number;
    //@Size(max = 100)
    @Column(name = "filenames")
    private String filenames;
    //@Size(max = 100)
    @Column(name = "error")
    private String error;

    public Result() {
    }

    public Result(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getFilenames() {
        return filenames;
    }

    public void setFilenames(String filenames) {
        this.filenames = filenames;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Result)) {
            return false;
        }
        Result other = (Result) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ResponseResult[ id=" + id + " ]";
    }

}

