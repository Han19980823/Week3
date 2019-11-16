package week1.dianshangjinjie.bw.com.demo2.presenter;

import okhttp3.MultipartBody;
import week1.dianshangjinjie.bw.com.demo2.base.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo2.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo2.enemty.HomeEnemty;
import week1.dianshangjinjie.bw.com.demo2.enemty.PhotoEmety;
import week1.dianshangjinjie.bw.com.demo2.fragment.HomeFragment;
import week1.dianshangjinjie.bw.com.demo2.fragment.MyFragment;
import week1.dianshangjinjie.bw.com.demo2.model.Model;

/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 10:21 modify by liujc
 */
public class Presenter extends BasePresenter implements Icontract.Ipresenter {
    Model model;

    public Presenter() {
        model = new Model();
    }

    @Override
    public void getModel() {
        model.getUtils(new Icontract.callback() {
            @Override
            public void back(HomeEnemty homeEnemty) {
                HomeFragment fragment = (HomeFragment) v;
                fragment.sucess(homeEnemty);
            }
        });
    }

    public void getPhoto(MultipartBody.Part files){
        model.getP(files, new Icontract.Photo() {
            @Override
            public void getP(PhotoEmety files) {
                MyFragment fragment  = (MyFragment) v;
                fragment.success(files);
            }
        });
    }
}
