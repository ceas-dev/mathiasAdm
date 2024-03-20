package com.easyapp.mathias.adm.mathias.model;

import com.google.firebase.auth.UserRecord;

public class User {
    private final String uid;
    private final String tenantId;
    private final String email;
    private final String phoneNumber;
    private final boolean emailVerified;
    private final String displayName;
    private final String photoUrl;
    private final boolean disabled;
    private final long tokensValidAfterTimestamp;

    public User(UserRecord userRecord) {
        this.uid = userRecord.getUid();
        this.tenantId = userRecord.getTenantId();
        this.email = userRecord.getEmail();
        this.phoneNumber = userRecord.getPhoneNumber();
        this.emailVerified = userRecord.isEmailVerified();
        this.displayName = userRecord.getDisplayName();
        this.photoUrl = userRecord.getPhotoUrl();
        this.disabled = userRecord.isDisabled();
        this.tokensValidAfterTimestamp = userRecord.getTokensValidAfterTimestamp();
    }

    // Getters para acessar os campos privados

    public String getUid() {
        return uid;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public long getTokensValidAfterTimestamp() {
        return tokensValidAfterTimestamp;
    }
}
