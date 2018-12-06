package com.kinfo.thuttu.rxbus;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public class RxBus {


    public RxBus() {
    }

    private PublishSubject<Object> bus = PublishSubject.create();

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }



}
