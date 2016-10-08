package com.oxionaz.internetapp.model;

import rx.Observable;

public interface Model {
    Observable<String> changeText();
    Observable<String> request(String userNumber);
}
