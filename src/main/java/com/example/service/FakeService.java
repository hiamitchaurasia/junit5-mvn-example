package com.example.service;

public class FakeService {
    public boolean fakeUpdate() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
