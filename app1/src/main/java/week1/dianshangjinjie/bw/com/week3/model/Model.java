package week1.dianshangjinjie.bw.com.week3.model;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import week1.dianshangjinjie.bw.com.week3.aps.ApiService;
import week1.dianshangjinjie.bw.com.week3.contract.Icontract;
import week1.dianshangjinjie.bw.com.week3.entity.SQentity;
import week1.dianshangjinjie.bw.com.week3.utils.RestrfitUtils;
import week1.dianshangjinjie.bw.com.week3.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/11/14
 * 描述：TODO
 * 最近修改：2019/11/14 18:52 modify by liujc
 */
public class Model  {
    public void getModel(Icontract.callBack callBack){
            RestrfitUtils.getInstance().initInstnce(ApiService.class)
                    .getData(839,"1573731663360839",1,5)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<SQentity>() {
                        @Override
                        public void accept(SQentity sQentity) throws Exception {
                            callBack.back(sQentity);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Log.e("net", "网络错误 " );
                        }
                    });
        }

}
