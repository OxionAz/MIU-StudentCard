package com.oxionaz.internetapp.model;

import com.jakewharton.rxbinding.widget.RxCheckedTextView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.oxionaz.internetapp.view.ViewHolder;

import rx.Observable;
import rx.functions.Func1;


public class ModelImpl implements Model {

    private final ViewHolder viewHolder;

    public ModelImpl(final ViewHolder viewHolder){
        this.viewHolder = viewHolder;
    }

    @Override
    public Observable<String> changeText() {
        return null;
    }

    @Override
    public Observable<String> request(String userNumber) {
        return null;
    }
}
