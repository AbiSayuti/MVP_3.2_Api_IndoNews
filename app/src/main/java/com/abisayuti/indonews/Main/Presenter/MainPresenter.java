package com.abisayuti.indonews.Main.Presenter;

import com.abisayuti.indonews.Base.BasePresenter;
import com.abisayuti.indonews.Main.Model.ArticlesItem;
import com.abisayuti.indonews.Main.Model.ResponseGetNews;
import com.abisayuti.indonews.Main.View.MainView;
import com.abisayuti.indonews.Network.ConfigRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {

    MainView mainView;
    private String country = "id";
    private String apikey = "b15273ddf49045eda71bb8d5c090e25c";



    public void getData() {


        call().enqueue(new Callback<ResponseGetNews>() {
            @Override
            public void onResponse(Call<ResponseGetNews> call, Response<ResponseGetNews> response) {
                if(response.isSuccessful()){
                    List<ArticlesItem> articlesItems = response.body().getArticles();
                    mainView.onSucces(articlesItems);
                }else {
                    mainView.onError("Gagal Mengambil Data");
                }
            }

            @Override
            public void onFailure(Call<ResponseGetNews> call, Throwable t) {
//                Toast.makeText(MainActivity, "", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDettach() {

    }
    public Call<ResponseGetNews> call() {
        return ConfigRetrofit.getInstance().getNewsData(country,apikey);
    }
}
