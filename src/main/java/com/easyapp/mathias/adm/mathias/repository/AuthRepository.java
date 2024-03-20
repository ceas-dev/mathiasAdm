package com.easyapp.mathias.adm.mathias.repository;

import com.easyapp.mathias.adm.mathias.model.TokenInfo;
import org.springframework.stereotype.Repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.easyapp.mathias.adm.mathias.model.User;
@Repository
public class AuthRepository {
    public TokenInfo verifyToken(String token) throws FirebaseAuthException {
        return new TokenInfo(auth().verifyIdToken(token), token);
    }
    public String getUidByToken(String token) throws FirebaseAuthException {
        return auth().verifyIdToken(token).getClaims().keySet().toString();
    }

    public User getUserByUid(String uid) throws FirebaseAuthException {
        return new User(auth().getUser(uid));
    }


    private FirebaseAuth auth(){
        return FirebaseAuth.getInstance();
    }
    
}
