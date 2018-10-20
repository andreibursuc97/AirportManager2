package model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "administrator", schema = "airport-schedule", catalog = "")
@NamedQuery(name="administrator.findByUsername", query = "FROM AdministratorEntity A where A.username = :username")

public class AdministratorEntity {
    private int id;
    private String username;
    private byte[] passwordAdmin;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password_admin")
    public byte[] getPasswordAdmin() {
        return passwordAdmin;
    }

    public void setPasswordAdmin(byte[] passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministratorEntity that = (AdministratorEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Arrays.equals(passwordAdmin, that.passwordAdmin);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, username);
        result = 31 * result + Arrays.hashCode(passwordAdmin);
        return result;
    }
}
