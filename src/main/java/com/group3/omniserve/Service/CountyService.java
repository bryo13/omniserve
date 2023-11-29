package com.group3.omniserve.Service;

import com.group3.omniserve.Exception.CountyAlreadyExistsException;
import com.group3.omniserve.Exception.CountyNotFoundException;
import com.group3.omniserve.model.County;
import com.group3.omniserve.model.User;
import com.group3.omniserve.model.Country;
import com.group3.omniserve.dto.CountyPostRequest;
import com.group3.omniserve.repository.CountyRepository;
import com.group3.omniserve.repository.UserRepository;
import com.group3.omniserve.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountyService {
    private final CountyRepository countyRepository;
    private final UserRepository userRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public CountyService(CountyRepository countyRepository, UserRepository userRepository, CountryRepository countryRepository) {
        this.countyRepository = countyRepository;
        this.userRepository = userRepository;
        this.countryRepository = countryRepository;
    }

    // Create a new county
    public County createCounty(CountyPostRequest countyRequest) {
        // Check if the Name is not empty
        if (countyRequest.getName() == null || countyRequest.getName().isEmpty()) {
            throw new IllegalArgumentException("County name cannot be empty.");
        }

        // Check if a county with the same name related to the selected country already exists
        if (countyRepository.existsByNameAndCountry(countyRequest.getName(), countyRequest.getCountry())) {
            throw new CountyAlreadyExistsException("A county with the same name already exists for this country.");
        }

        // Check if the User (created by) exists
        User createdBy = userRepository.findById(countyRequest.getCreatedBy().getId())
                .orElseThrow(() -> new IllegalArgumentException("User with the given ID does not exist."));

        // Check if the Country exists
        Country country = countryRepository.findById(countyRequest.getCountry().getId())
                .orElseThrow(() -> new IllegalArgumentException("Country with the given ID does not exist."));

        // You can add more validation or business logic here

        // Create a new county entity and set its attributes from the request
        County county = new County();
        county.setName(countyRequest.getName());
        county.setCreatedBy(createdBy);
        county.setCountry(country);

        // Save the county to the database
        return countyRepository.save(county);
    }

    // Get all counties
    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }

    // Get a specific county by ID
    public County getCountyById(Long id) {
        return countyRepository.findById(id)
                .orElseThrow(() -> new CountyNotFoundException("County not found with ID: " + id));
    }

 

    // Update a county
    public County updateCounty(Long id, CountyPostRequest updatedCountyRequest) {
        Optional<County> existingCountyOptional = countyRepository.findById(id);
        if (existingCountyOptional.isEmpty()) {
            throw new CountyNotFoundException("County not found with ID: " + id);
        }

        County existingCounty = existingCountyOptional.get();

        // Check if a county with the same name related to the selected country already exists (excluding the current county)
        if (!existingCounty.getName().equals(updatedCountyRequest.getName()) &&
            countyRepository.existsByNameAndCountry(updatedCountyRequest.getName(), existingCounty.getCountry())) {
            throw new CountyAlreadyExistsException("A county with the same name already exists for this country.");
        }

        // Update the existing county entity with data from the request
        existingCounty.setName(updatedCountyRequest.getName());

        // You can add more update logic here

        return countyRepository.save(existingCounty);
    }

    // Delete a county by ID
    public void deleteCounty(Long id) {
        if (!countyRepository.existsById(id)) {
            throw new CountyNotFoundException("County not found with ID: " + id);
        }

        countyRepository.deleteById(id);
    }
}
