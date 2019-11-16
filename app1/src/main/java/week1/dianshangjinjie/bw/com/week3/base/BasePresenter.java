package week1.dianshangjinjie.bw.com.week3.base;

/**
 * 作者：Han98
 * 创建时间：2019/11/14
 * 描述：TODO
 * 最近修改：2019/11/14 18:28 modify by liujc
 */
public class BasePresenter<V extends BaseActivity> {
    public V v;


    public void attach(V v){
        this.v = v;
    }
    public void unAttach(){
        if (v!=null){
            v = null;
        }
    }
}
