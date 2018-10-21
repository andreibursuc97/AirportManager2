package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "airport-schedule", catalog = "")
//@NamedQuery(name="CityEntity.getCityById", query = "select c FROM CityEntity as c")
public class CityEntity {
    private int id;
    private String cityName;
    private String longitude;
    private String latitude;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return id == that.id &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(latitude, that.latitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName, longitude, latitude);
    }
}
