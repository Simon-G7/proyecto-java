package com.smmr.proyectojava.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EncryptionPostResponse {

    private String code;

    private String response;

}
