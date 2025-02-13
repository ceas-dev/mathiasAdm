package com.easyapp.mathias.adm.mathias.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    FirebaseApp firebaseApp() throws IOException {
       var serviceAccount = new FileInputStream("src/main/resources/google-services.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://mathiasadm-b5772-default-rtdb.firebaseio.com")
                .build();

       return FirebaseApp.initializeApp(options);

    }
   
}
