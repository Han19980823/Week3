package week1.dianshangjinjie.bw.com.demo1.contract;

import week1.dianshangjinjie.bw.com.demo1.enemty.HomeEnemty;

/**
 * 作者：Han98
 * 创建时间：2019/11/15
 * 描述：TODO
 * 最近修改：2019/11/15 15:10 modify by liujc
 */
public interface Icontract {

    //p层
    interface getModel{
        void getData();
    }
    interface getShu{
        void get(HomeEnemty homeEnemty);
    }

    interface Iview{
        void success(HomeEnemty homeEnemty);
    }
}
