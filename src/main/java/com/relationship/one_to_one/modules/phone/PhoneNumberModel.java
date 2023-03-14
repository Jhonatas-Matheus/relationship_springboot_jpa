package com.relationship.one_to_one.modules.phone;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.relationship.one_to_one.modules.client.ClientModel;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class PhoneNumberModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String phoneNumber;
    @JsonIgnore
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private ClientModel client;
}
