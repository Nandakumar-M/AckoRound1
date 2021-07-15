package com.example.acko.service;

import org.springframework.stereotype.Service;

@Service
public class SMSNotificationService {
    public void notifyBySMS(String phoneNo, String s) {
        System.out.println("Notified "+ phoneNo +". Payload : "+s);
    }
}
