
package com.group3.omniserve.dto;

/**
 *
 * @author stephen masaku
 */
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsersUpdateRequest {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 255)
    private String first_name;

    @NotBlank
    @Size(min = 2, max = 255)
    private String surname;

    @NotBlank
    @Size(min = 2, max = 255)
    private String other_name;

    @NotBlank
    @Size(min = 2, max = 255)
    private Long countryID;

    @NotBlank
    private Long countyID;

    @NotBlank
    private Long cityID;

    @NotBlank
    private String location;

    @NotBlank
    private String address;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String status = "Active";

    @NotBlank
    private String nationalID;

    private String national_ID_Doc_Upload;

    private boolean emailVerified = false;

    @NotBlank
    @Size(min = 2, max = 255)
    private String username;

    @NotBlank
    @Size(min = 2, max = 255)
    private String email;

    

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOther_name() {
        return other_name;
    }

    public void setOther_name(String other_name) {
        this.other_name = other_name;
    }

    public Long getCountryID() {
        return countryID;
    }

    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    public Long getCountyID() {
        return countyID;
    }

    public void setCountyID(Long countyID) {
        this.countyID = countyID;
    }

    public Long getCityID() {
        return cityID;
    }

    public void setCityID(Long cityID) {
        this.cityID = cityID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getNational_ID_Doc_Upload() {
        return national_ID_Doc_Upload;
    }

    public void setNational_ID_Doc_Upload(String national_ID_Doc_Upload) {
        this.national_ID_Doc_Upload = national_ID_Doc_Upload;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
