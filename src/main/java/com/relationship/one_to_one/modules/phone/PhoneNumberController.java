package com.relationship.one_to_one.modules.phone;

import com.relationship.one_to_one.modules.client.ClientModel;
import com.relationship.one_to_one.modules.client.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/phone-number")
public class PhoneNumberController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private PhoneNumberService phoneNumberService;

    @PostMapping("/{id}")
    public ResponseEntity<Object> registerPhoneNumber(@PathVariable UUID id, @RequestBody  PhoneNumberModel phoneNumber){
        PhoneNumberModel currentPhoneNumber = new PhoneNumberModel();
        Optional<ClientModel> currentClient = this.clientService.findById(id);
        if(currentClient.isPresent()){
            BeanUtils.copyProperties(phoneNumber,currentPhoneNumber);
            currentPhoneNumber.setClient(currentClient.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(this.phoneNumberService.save(currentPhoneNumber));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getSpecificPhoneNumber(@PathVariable UUID id){
        Optional<PhoneNumberModel> currentPhoneNumber = this.phoneNumberService.findById(id);
        if(currentPhoneNumber.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(currentPhoneNumber.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Phone number not found.");
        }
    }
}
