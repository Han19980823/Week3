package week1.dianshangjinjie.bw.com.demo2.contract;

import okhttp3.MultipartBody;
import week1.dianshangjinjie.bw.com.demo2.enemty.HomeEnemty;
import week1.dianshangjinjie.bw.com.demo2.enemty.PhotoEmety;
import week1.dianshangjinjie.bw.com.demo2.fragment.HomeFragment;

/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 10:21 modify by liujc
 */
public interface Icontract  {

    interface Ipresenter{
        void getModel();

    }
    interface callback{
        void back(HomeEnemty homeEnemty);
    }

    interface  Iview{
        void sucess(HomeEnemty homeFragment);
    }

    interface Photo{
        void getP(PhotoEmety files);
    }

    interface IFrag{
        void success(PhotoEmety photoEmety);
    }

}
