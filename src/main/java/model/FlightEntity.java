package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "flight", schema = "airport-schedule", catalog = "")
@NamedQuery(name="FlightEntity.getAllFlights", query = "select f FROM FlightEntity as f")
public class FlightEntity {
    private int id;
    private String airplaneType;
    private Integer departureCityId;
    private String departureDate;
    private Integer arrivalCityId;
    private String arrivalDate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "airplane_type")
    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    @Basic
    @Column(name = "departure_city_id")
    public Integer getDepartureCityId() {
        return departureCityId;
    }

    public void setDepartureCityId(Integer departureCityId) {
        this.departureCityId = departureCityId;
    }

    @Basic
    @Column(name = "departure_date")
    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    @Basic
    @Column(name = "arrival_city_id")
    public Integer getArrivalCityId() {
        return arrivalCityId;
    }

    public void setArrivalCityId(Integer arrivalCityId) {
        this.arrivalCityId = arrivalCityId;
    }

    @Basic
    @Column(name = "arrival_date")
    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightEntity that = (FlightEntity) o;
        return id == that.id &&
                Objects.equals(airplaneType, that.airplaneType) &&
                Objects.equals(departureCityId, that.departureCityId) &&
                Objects.equals(departureDate, that.departureDate) &&
                Objects.equals(arrivalCityId, that.arrivalCityId) &&
                Objects.equals(arrivalDate, that.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airplaneType, departureCityId, departureDate, arrivalCityId, arrivalDate);
    }
}
