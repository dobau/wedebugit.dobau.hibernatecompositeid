package it.wedebug.dobau.embeddedid;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ClientId implements Serializable {

    private static final long serialVersionUID = -683479186917303343L;

    private String firstName;
    private String lastName;

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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ClientId) || this.firstName == null || this.lastName == null) {
            return false;
        } else {
            ClientId aux = (ClientId) obj;

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
