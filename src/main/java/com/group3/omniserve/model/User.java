package com.group3.omniserve.model;

/**
 *
 * @author stephen masaku
 */

import com.group3.omniserve.model.timestampdata.DateAudit;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.NaturalId;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private boolean phoneNumberVerified = false;


    @NotBlank
    @Size(max = 20)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 160)
    @Email
    private String email;

    
    @NotBlank
    @Size(max = 100)
    private String password;

  @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {

    }

// Constructor with db fields 
    public User(String first_name, String surname, String other_name, Long countryID, Long countyID, Long cityID, String location, String address, String zipCode, String status, String nationalID, String national_ID_Doc_Upload, boolean emailVerified, boolean phoneNumberVerified, String username, String email, String password) {
      // this.name = name;
        this.first_name = first_name;
        this.surname = surname;
        this.other_name = other_name;
        this.countryID = countryID;
        this.countyID = countyID;
        this.cityID = cityID;
        this.location = location;
        this.address = address;
        this.zipCode = zipCode;
        this.status = status;
        this.nationalID = nationalID;
        this.national_ID_Doc_Upload = national_ID_Doc_Upload;
        this.emailVerified = emailVerified;
        this.phoneNumberVerified = phoneNumberVerified;
        this.username = username;
        this.email = email;
        this.password = password;
    }

     // Setters and Getters for the fields

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
     
    public String getSur_name() {
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

    public boolean isPhoneNumberVerified() {
        return phoneNumberVerified;
    }

    public void setPhoneNumberVerified(boolean phoneNumberVerified) {
        this.phoneNumberVerified = phoneNumberVerified;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }
    

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setFirstName(String firstName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setOtherName(String otherName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    
}