package com.easyapp.mathias.adm.mathias.service;

import com.easyapp.mathias.adm.mathias.exceptions.UserNotFoundException;
import com.easyapp.mathias.adm.mathias.model.TokenInfo;
import com.easyapp.mathias.adm.mathias.model.User;
import com.easyapp.mathias.adm.mathias.repository.AuthRepository;
import com.easyapp.mathias.adm.mathias.utils.LogUtils;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    AuthRepository repository;
    public String getUidByToken(String token) throws Exception {
        return repository.getUidByToken(token);
    }

    public User getUserInfo(String uid) throws UserNotFoundException {
        try {
            return repository.getUserByUid(uid);
        } catch (FirebaseAuthException e) {
            throw new UserNotFoundException(e.toString());
        }
    }

    public Optional<TokenInfo> verifyToken(String token){
        try {
            return Optional.of(repository.verifyToken(token));
        } catch (FirebaseAuthException e) {
            LogUtils.log("Erro ao verificar log: " + e);
            return Optional.empty();
        }
    }

    private FirebaseAuth auth(){
        return FirebaseAuth.getInstance();
    }
    
}
