package week1.dianshangjinjie.bw.com.demo2.base.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import week1.dianshangjinjie.bw.com.demo2.base.bases.BaseActivity;

/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 09:30 modify by liujc
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    public  P p;
    public Unbinder unbinder;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = Ipresenter();

        if (p!=null){
            p.attach(this);
        }
    }
    protected abstract P Ipresenter();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), null);
        unbinder = ButterKnife.bind(this,view);
        return view ;

    }

    protected abstract int initLayout();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    protected abstract void initView(View view);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }

    protected abstract void initData(Bundle savedInstanceState);

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.unAttach();
        }
    }
}
