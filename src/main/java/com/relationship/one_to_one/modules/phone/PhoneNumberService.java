package com.relationship.one_to_one.modules.phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PhoneNumberService {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    public PhoneNumberModel save(PhoneNumberModel phoneNumber) {
        return this.phoneNumberRepository.save(phoneNumber);
    }

    public Optional<PhoneNumberModel> findById(UUID id) {
        return this.phoneNumberRepository.findById(id);
    }
}
