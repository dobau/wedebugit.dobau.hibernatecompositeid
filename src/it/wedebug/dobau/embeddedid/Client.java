package it.wedebug.dobau.embeddedid;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = -683479186917303343L;

    @EmbeddedId
    private ClientId id;

    @Column
    private Integer age;

    public ClientId getId() {
        if (id == null) {
            id = new ClientId();
        }

        return id;
    }

    public void setId(ClientId id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
