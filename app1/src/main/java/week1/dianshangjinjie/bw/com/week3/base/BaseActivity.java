package week1.dianshangjinjie.bw.com.week3.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：Han98
 * 创建时间：2019/11/14
 * 描述：TODO
 * 最近修改：2019/11/14 18:28 modify by liujc
 */
public abstract  class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P p;
   public Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        p = Ipresenter();
        unbinder =  ButterKnife.bind(this);
        if (p!=null){
            p.attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();
    protected abstract P  Ipresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.unAttach();
            p=null;
        }
    }
}
