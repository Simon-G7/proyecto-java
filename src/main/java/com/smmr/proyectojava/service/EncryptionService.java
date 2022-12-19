package com.smmr.proyectojava.service;

import com.smmr.proyectojava.dto.EncryptionBEDto;
import com.smmr.proyectojava.mapper.IEncryptionBEMapper;
import com.smmr.proyectojava.model.*;
import com.smmr.proyectojava.repository.IEncryptionRepository;
import com.smmr.proyectojava.repository.entity.EncryptionBE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EncryptionService implements IEncryptionService{

    private IEncryptionBEMapper mapper;

    private IEncryptionRepository encryption_repository;

    @Autowired
    public EncryptionService(IEncryptionBEMapper mapper, IEncryptionRepository encryption_repository) {
        this.mapper = mapper;
        this.encryption_repository = encryption_repository;
    }

    @Override
    public ResponseEntity<EncryptionGetAllResponse> get_all_encryption_service_handler() {

        log.info("entrando a metodo para obtener todos en Service");
        EncryptionGetAllResponse encryption_response = new EncryptionGetAllResponse();
        List<EncryptionBE> encryption_repository_list = encryption_repository.findAll();

        List<EncryptionBEDto> encryption_model_list = encryption_repository_list.stream().map(mapper::encryptionBE_to_encryptionDTO).toList();

        encryption_response.setInformation_list(encryption_model_list);

       return ResponseEntity.status(HttpStatus.OK).body(encryption_response);
    }

    @Override
    public ResponseEntity<EncryptionGetRs> get_encryption_service_handler(String id_key, String header){

        EncryptionBE encryption_data= encryption_repository.find_data_by_key(id_key,header).get();

        EncryptionGetRs get_response= new EncryptionGetRs();

        get_response.setId_table(encryption_data.getId_table());
        get_response.setValue1(encryption_data.getValor1());
        get_response.setValue2(encryption_data.getValor2());
        get_response.setValue3(new String(encryption_data.getValor3()));

        return ResponseEntity.status(HttpStatus.OK).body(get_response);

    }


    @Override
    public ResponseEntity<EncryptionPostResponse> post_encryption_service_handler(EncryptionPostRequest body, String password) {

        log.info("entrando a metodo para guardar registro. Clase Service");

        EncryptionPostResponse encryption_response = new EncryptionPostResponse();
        int row=encryption_repository.save_data( body.getData().getValue1(), body.getData().getValue2(), body.getData().getValue3(), password);
        encryption_response.setCode("400");
        encryption_response.setResponse("Failure");
        if (row>0) {
            encryption_response.setCode("200");
            encryption_response.setResponse("Inserted");
        }

        return ResponseEntity.status(HttpStatus.OK).body(encryption_response);

    }

    @Override
    public ResponseEntity<EncryptionDeleteResponse> delete_encryption_service_handler(String id_key) {

        log.info("entrando a metodo para eliminar registro. Clase Service");

        EncryptionDeleteResponse encryption_response = new EncryptionDeleteResponse();
        int row=encryption_repository.delete_data(id_key);
        encryption_response.setCode("400");
        encryption_response.setResponse("Failure");
        if (row>0) {
            encryption_response.setCode("200");
            encryption_response.setResponse("Deleted");
        }

        return ResponseEntity.status(HttpStatus.OK).body(encryption_response);

    }

    @Override
    public ResponseEntity<EncryptionPutResponse> put_encryption_service_handler(String id_key, EncryptionPutRequest body, String password) {

        log.info("entrando a metodo para actualizar registro. Clase Service");

        EncryptionPutResponse encryption_response = new EncryptionPutResponse();
        int row=encryption_repository.update_data(id_key, body.getData().getValue1(), body.getData().getValue2(), body.getData().getValue3(), password);
        encryption_response.setCode("400");
        encryption_response.setResponse("Failure");
        if (row>0) {
            encryption_response.setCode("200");
            encryption_response.setResponse("Modified");
        }

        return ResponseEntity.status(HttpStatus.OK).body(encryption_response);

    }
}
