package com.easyapp.mathias.adm.mathias.controller;

import com.easyapp.mathias.adm.mathias.exceptions.UserNotFoundException;
import com.easyapp.mathias.adm.mathias.model.TokenInfo;
import com.easyapp.mathias.adm.mathias.model.User;
import org.apache.http.HttpStatus;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyapp.mathias.adm.mathias.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthService service;

    @GetMapping("{email}")
    public String postMethodName(@PathVariable("email") String entity) {
        try {
            return service.getUidByToken(entity);
        } catch (Exception e) {
            return e.toString();
        }
    }

    @GetMapping("user/{uid}")
    public User getUserInfo(@PathVariable("uid") String uid) throws UserNotFoundException {
        return service.getUserInfo(uid);
    }

    @GetMapping(value = "token/{token}", produces = "application/json")
    public ResponseEntity<TokenInfo> verifyToken(@PathVariable("token") String token){
        var tokenInfo = service.verifyToken(token);
        return tokenInfo.map(ResponseEntity::ok).orElseGet(() ->
             ResponseEntity.status(HttpStatus.SC_FORBIDDEN).build()
        );
    }

}
