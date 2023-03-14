package com.relationship.one_to_one.modules.client;

import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Object> registerClient(@RequestBody ClientModel clientModel){

        ClientModel currentClient = new ClientModel();
        BeanUtils.copyProperties(clientModel,currentClient);
        ClientModel response = this.clientService.save(currentClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable UUID id){
        Optional<ClientModel> userFound = this.clientService.findById(id);
        if(userFound.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(userFound.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

    }
}
