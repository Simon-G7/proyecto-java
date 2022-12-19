package com.smmr.proyectojava.mapper;

import com.smmr.proyectojava.dto.EncryptionBEDto;
import com.smmr.proyectojava.repository.entity.EncryptionBE;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface IEncryptionBEMapper {

    EncryptionBEDto encryptionBE_to_encryptionDTO( EncryptionBE encryption_entity);

    //EncryptionBE encryptionBEDto_to_encryptionBE( EncryptionBEDto encryption_dto);

}
