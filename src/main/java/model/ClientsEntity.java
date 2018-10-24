package model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "clients", schema = "airport-schedule", catalog = "")
@NamedQuery(name="ClientsEntity.findByUsername", query = "FROM ClientsEntity c where c.username = :username")
public class ClientsEntity {
    private int id;
    private String username;
    private String nume;
    private byte[] passwordClient;

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
    @Column(name = "nume")
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Basic
    @Column(name = "password_client")
    public byte[] getPasswordClient() {
        return passwordClient;
    }

    public void setPasswordClient(byte[] passwordClient) {
        this.passwordClient = passwordClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientsEntity that = (ClientsEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(nume, that.nume) &&
                Arrays.equals(passwordClient, that.passwordClient);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, username, nume);
        result = 31 * result + Arrays.hashCode(passwordClient);
        return result;
    }
}
