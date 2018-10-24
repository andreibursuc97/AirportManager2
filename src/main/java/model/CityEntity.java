package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "airport-schedule", catalog = "")
@NamedQueries({
        @NamedQuery(name = "CityEntity.getAllCities", query = "select c FROM CityEntity as c"),
        @NamedQuery(name = "CityEntity.getCityByName", query = "select c FROM CityEntity as c where c.cityName =: cityName")
})
public class CityEntity {
    private int id;
    private String cityName;
    private String longitude;
    private String latitude;

    public CityEntity(String cityName, String longitude, String latitude) {
        this.cityName = cityName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public CityEntity() {
    }

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
