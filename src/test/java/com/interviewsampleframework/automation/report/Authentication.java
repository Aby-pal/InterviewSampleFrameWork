package com.interviewsampleframework.automation.report;

import javax.mail.PasswordAuthentication;

/**
 *
 * @author Abhishek Pal Singh
 */
class Authenticator extends javax.mail.Authenticator {
        
    private PasswordAuthentication authentication;

    public Authenticator(String username, String password) {
        authentication = new PasswordAuthentication(username, password);
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return authentication;
    }
}

