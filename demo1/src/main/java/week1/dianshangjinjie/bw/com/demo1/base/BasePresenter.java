package week1.dianshangjinjie.bw.com.demo1.base;

import java.lang.ref.WeakReference;

/**
 * 作者：Han98
 * 创建时间：2019/11/15
 * 描述：TODO
 * 最近修改：2019/11/15 15:00 modify by liujc
 */
public class BasePresenter<V extends BaseActivity> {

    public V v;
    WeakReference weakReference;
    public void attach(V v){
        if (v!=null){
            this.v = v;
            weakReference = new WeakReference(v);
        }
    }

    public void unAttach(){
        if (v !=null){
             v = null;
             weakReference.clear();
        }
    }
}
