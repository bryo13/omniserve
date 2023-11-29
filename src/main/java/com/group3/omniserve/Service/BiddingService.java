package com.group3.omniserve.Service;

import com.group3.omniserve.Exception.BiddingNotFoundException;
import com.group3.omniserve.model.Bidding;
import com.group3.omniserve.repository.BiddingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BiddingService {
    private final BiddingRepository biddingRepository;

    @Autowired
    public BiddingService(BiddingRepository biddingRepository) {
        this.biddingRepository = biddingRepository;
    }

    // Create a new bidding
    public Bidding createBidding(Bidding bidding) {
        // Your validation logic here

        return biddingRepository.save(bidding);
    }

    // Get all biddings
    public List<Bidding> getAllBiddings() {
        return biddingRepository.findAll();
    }

    // Get a specific bidding by ID
    public Bidding getBiddingById(Long id) {
        Optional<Bidding> bidding = biddingRepository.findById(id);
        if (bidding.isPresent()) {
            return bidding.get();
        } else {
            throw new BiddingNotFoundException("Bidding not found with ID: " + id);
        }
    }

    // Update a bidding
    public Bidding updateBidding(Bidding updatedBidding) {
        // Your validation logic for updates here

        return biddingRepository.save(updatedBidding);
    }

    // Delete a bidding by ID
    public void deleteBidding(Long id) {
        if (!biddingRepository.existsById(id)) {
            throw new BiddingNotFoundException("Bidding not found with ID: " + id);
        }
        biddingRepository.deleteById(id);
    }
}
