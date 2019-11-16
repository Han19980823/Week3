package week1.dianshangjinjie.bw.com.demo1.presenter;

import week1.dianshangjinjie.bw.com.demo1.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo1.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo1.enemty.HomeEnemty;
import week1.dianshangjinjie.bw.com.demo1.model.Model;
import week1.dianshangjinjie.bw.com.demo1.view.MainActivity;

/**
 * 作者：Han98
 * 创建时间：2019/11/15
 * 描述：TODO
 * 最近修改：2019/11/15 15:00 modify by liujc
 */
public class Presenter extends BasePresenter implements Icontract.getModel {
    Model model;

    public Presenter() {
      model = new Model();
    }

    @Override
    public void getData() {
        model.getUtils(new Icontract.getShu() {
            @Override
            public void get(HomeEnemty homeEnemty) {
                MainActivity activity = (MainActivity) v;
                activity.success(homeEnemty);
            }
        });
    }
}
