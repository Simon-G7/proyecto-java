package com.smmr.proyectojava.controller;

import com.smmr.proyectojava.dto.EncryptionBEDto;
import com.smmr.proyectojava.model.*;
import com.smmr.proyectojava.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encryption")
public class EncryptionController {

    @Autowired
    EncryptionService encryption_service;

    @GetMapping
    public ResponseEntity<EncryptionGetAllResponse> encryption_get_all() {
        return encryption_service.get_all_encryption_service_handler();
    }


    @GetMapping(value = "/{id_key}")
    public ResponseEntity<EncryptionGetRs> encryption_get_by_id(@PathVariable String id_key, @RequestHeader(value = "password", required = true) String pass) {
        return encryption_service.get_encryption_service_handler(id_key, pass);
    }

    @PostMapping
    public ResponseEntity<EncryptionPostResponse> encryption_post(@RequestBody EncryptionPostRequest encryption_post_request, @RequestHeader(value = "password", required = true) String pass) {
        return encryption_service.post_encryption_service_handler(encryption_post_request, pass);
    }

    @PutMapping(value = "/{id_key}")
    public ResponseEntity<EncryptionPutResponse> encryption_put(@PathVariable String id_key, @RequestBody EncryptionPutRequest encryption_put_request, @RequestHeader(value = "password", required = true) String pass) {
        return encryption_service.put_encryption_service_handler(id_key, encryption_put_request, pass);
    }

    @DeleteMapping(value = "/{id_key}")
    public ResponseEntity<EncryptionDeleteResponse> encryption_delete(@PathVariable String id_key) {
        return encryption_service.delete_encryption_service_handler(id_key);
    }

}
