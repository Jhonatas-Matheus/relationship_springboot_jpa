package com.relationship.one_to_one.modules.client;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.relationship.one_to_one.modules.address.AddressModel;
import com.relationship.one_to_one.modules.phone.PhoneNumberModel;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    @Column(nullable = false)
    private String gender;
    @OneToOne
    @JoinColumn(name = "addres_id")
    private AddressModel address;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<PhoneNumberModel> phoneNumbers;
}
