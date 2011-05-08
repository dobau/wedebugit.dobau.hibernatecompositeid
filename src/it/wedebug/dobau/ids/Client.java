package it.wedebug.dobau.ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = -683479186917303343L;

    @Id
    private String firstName;

    @Id
    private String lastName;

    @Column
    private Integer age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Client) || this.firstName == null || this.lastName == null) {
            return false;
        } else {
            Client aux = (Client) obj;

            if (this.firstName == null || this.lastName == null || aux.firstName == null || aux.lastName == null) {
                return false;
            } else {
                return this.firstName.equals(aux.firstName)
                        && this.lastName.equals(aux.lastName);
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;

        if (this.firstName != null) {
            hash += this.firstName.hashCode();
        }

        if (this.lastName != null) {
            hash += this.lastName.hashCode();
        }

        return hash * 37;
    }

}
