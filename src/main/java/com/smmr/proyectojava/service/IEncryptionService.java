package com.smmr.proyectojava.service;

import com.smmr.proyectojava.dto.EncryptionBEDto;
import com.smmr.proyectojava.model.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IEncryptionService {

    ResponseEntity<EncryptionGetAllResponse> get_all_encryption_service_handler();

    ResponseEntity<EncryptionGetRs> get_encryption_service_handler(String id_key, String header);

    ResponseEntity<EncryptionPostResponse> post_encryption_service_handler(EncryptionPostRequest body, String password);

    ResponseEntity<EncryptionDeleteResponse> delete_encryption_service_handler(String id_key);

    ResponseEntity<EncryptionPutResponse> put_encryption_service_handler(String id_key, EncryptionPutRequest body, String password);


}
