package com.abisayuti.indonews.Main.View;

import com.abisayuti.indonews.Base.BaseView;
import com.abisayuti.indonews.Main.Model.ArticlesItem;

import java.util.List;

public interface MainView extends BaseView {
    void onError(String msg);
    void onSucces(List<ArticlesItem> data);
}
