package com.example.restapiserver.request;

import com.example.restapiserver.models.Advertisement;

public interface RestSender {
    void postRequest(Advertisement advertisement);
}
