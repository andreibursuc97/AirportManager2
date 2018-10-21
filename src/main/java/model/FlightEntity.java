package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "flight", schema = "airport-schedule", catalog = "")
@NamedQuery(name="flight.getAllFlights", query = "FROM FlightEntity ")
public class FlightEntity {
    private int id;
    private String airplaneType;
    private String departureCityName;
    private String departureCityLongitude;
    private String departureCityLatitude;
    private String departureDate;
    private String arrivalCityName;
    private String arrivalCityLongitude;
    private String arrivalCityLatitude;
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
    @Column(name = "departure_city_name")
    public String getDepartureCityName() {
        return departureCityName;
    }

    public void setDepartureCityName(String departureCityName) {
        this.departureCityName = departureCityName;
    }

    @Basic
    @Column(name = "departure_city_longitude")
    public String getDepartureCityLongitude() {
        return departureCityLongitude;
    }

    public void setDepartureCityLongitude(String departureCityLongitude) {
        this.departureCityLongitude = departureCityLongitude;
    }

    @Basic
    @Column(name = "departure_city_latitude")
    public String getDepartureCityLatitude() {
        return departureCityLatitude;
    }

    public void setDepartureCityLatitude(String departureCityLatitude) {
        this.departureCityLatitude = departureCityLatitude;
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
    @Column(name = "arrival_city_name")
    public String getArrivalCityName() {
        return arrivalCityName;
    }

    public void setArrivalCityName(String arrivalCityName) {
        this.arrivalCityName = arrivalCityName;
    }

    @Basic
    @Column(name = "arrival_city_longitude")
    public String getArrivalCityLongitude() {
        return arrivalCityLongitude;
    }

    public void setArrivalCityLongitude(String arrivalCityLongitude) {
        this.arrivalCityLongitude = arrivalCityLongitude;
    }

    @Basic
    @Column(name = "arrival_city_latitude")
    public String getArrivalCityLatitude() {
        return arrivalCityLatitude;
    }

    public void setArrivalCityLatitude(String arrivalCityLatitude) {
        this.arrivalCityLatitude = arrivalCityLatitude;
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
                Objects.equals(departureCityName, that.departureCityName) &&
                Objects.equals(departureCityLongitude, that.departureCityLongitude) &&
                Objects.equals(departureCityLatitude, that.departureCityLatitude) &&
                Objects.equals(departureDate, that.departureDate) &&
                Objects.equals(arrivalCityName, that.arrivalCityName) &&
                Objects.equals(arrivalCityLongitude, that.arrivalCityLongitude) &&
                Objects.equals(arrivalCityLatitude, that.arrivalCityLatitude) &&
                Objects.equals(arrivalDate, that.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, airplaneType, departureCityName, departureCityLongitude, departureCityLatitude, departureDate, arrivalCityName, arrivalCityLongitude, arrivalCityLatitude, arrivalDate);
    }
}
