package com.abisayuti.indonews.Base;

public interface BasePresenter <T extends BaseView>{
    void onAttach(T v);

    void onDettach();
}
