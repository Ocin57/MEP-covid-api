package org.polytech.covidapi.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class VaccinationCenter {
    @Id
    private Integer id;
    private String name;
    private String postalCode;
    private String address;
    private String city;

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public String getAddress() {
            return address;
        }

        public String getCity() {
            return city;
        }
}
