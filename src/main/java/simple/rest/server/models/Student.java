package simple.rest.server.models;


import org.hibernate.annotations.SQLInsert;

import javax.persistence.*;

@Entity
@Table(name="Students",uniqueConstraints={@UniqueConstraint(columnNames = "registrationNumber")})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String registrationNumber;
    private String course;
    private String guardianMobile;
    private String guardianEmailAddress;
    private String phoneNumber;
    private String currentYear;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGuardianMobile() {
        return guardianMobile;
    }

    public void setGuardianMobile(String guardianMobile) {
        this.guardianMobile = guardianMobile;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    public String getGuardianEmailAddress() {
        return guardianEmailAddress;
    }

    public void setGuardianEmailAddress(String guardianEmailAddress) {
        this.guardianEmailAddress = guardianEmailAddress;
    }
}
