package week1.dianshangjinjie.bw.com.week3.presenter;

import week1.dianshangjinjie.bw.com.week3.base.BasePresenter;
import week1.dianshangjinjie.bw.com.week3.contract.Icontract;
import week1.dianshangjinjie.bw.com.week3.entity.SQentity;
import week1.dianshangjinjie.bw.com.week3.model.Model;
import week1.dianshangjinjie.bw.com.week3.view.MainActivity;

/**
 * 作者：Han98
 * 创建时间：2019/11/14
 * 描述：TODO
 * 最近修改：2019/11/14 18:52 modify by liujc
 */
public class Presenter extends BasePresenter implements Icontract.IPresenter {
    Model model;

    public Presenter() {
        model = new Model();
    }

    @Override
    public void getData() {
        model.getModel(new Icontract.callBack() {
            @Override
            public void back(SQentity sQentity) {
                MainActivity activity = (MainActivity) v;
                activity.success(sQentity);

            }
        });
    }
}
