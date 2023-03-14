package com.relationship.one_to_one.modules.client;

import com.relationship.one_to_one.modules.address.AddressModel;
import com.relationship.one_to_one.modules.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    public ClientModel save(ClientModel currentClient) {
        AddressModel currentAddressToSave = this.addressRepository.save(currentClient.getAddress());
        currentClient.setAddress(currentAddressToSave);
        return this.clientRepository.save(currentClient);
    }

    public Optional<ClientModel> findById(UUID id) {
        return this.clientRepository.findById(id);
    }
}
