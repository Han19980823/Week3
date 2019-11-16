package week1.dianshangjinjie.bw.com.demo2.model;


import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import week1.dianshangjinjie.bw.com.demo2.api.HomeService;
import week1.dianshangjinjie.bw.com.demo2.api.PhotoService;
import week1.dianshangjinjie.bw.com.demo2.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo2.enemty.HomeEnemty;
import week1.dianshangjinjie.bw.com.demo2.enemty.PhotoEmety;
import week1.dianshangjinjie.bw.com.demo2.utils.Utils;

/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 10:23 modify by liujc
 */
public class Model {


    public void getUtils(Icontract.callback callback) {
        Utils.getInstance().getService(HomeService.class)
                .setive("1573875167250852", 1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeEnemty>() {
                    @Override
                    public void accept(HomeEnemty homeEnemty) throws Exception {
                        callback.back(homeEnemty);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }


    public void getP(MultipartBody.Part files,Icontract.Photo photo){

        Utils.getInstance().getService(PhotoService.class)
                .getPhoto(852, "1573888749363852", files)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhotoEmety>() {
                    @Override
                    public void accept(PhotoEmety photoEmety) throws Exception {
                        photo.getP(photoEmety);
                    }

                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });
    }
}

