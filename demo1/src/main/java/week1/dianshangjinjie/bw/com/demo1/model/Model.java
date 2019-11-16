package week1.dianshangjinjie.bw.com.demo1.model;

import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.demo1.api.ApiService;
import week1.dianshangjinjie.bw.com.demo1.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo1.enemty.HomeEnemty;
import week1.dianshangjinjie.bw.com.demo1.utils.Utils;
import week1.dianshangjinjie.bw.com.demo1.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/11/15
 * 描述：TODO
 * 最近修改：2019/11/15 15:10 modify by liujc
 */
public class Model {

    public void getUtils(Icontract.getShu getShu){

        Utils.getInstance().getData(ApiService.class)
                .service(847,"1573803427251847",1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeEnemty>() {
                    @Override
                    public void accept(HomeEnemty homeEnemty) throws Exception {
                        if (getShu!=null){
                            getShu.get(homeEnemty);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(App.context, "网络错误", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
