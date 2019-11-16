package week1.dianshangjinjie.bw.com.demo2.fragment;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo2.R;
import week1.dianshangjinjie.bw.com.demo2.adapter.HomeAdapter;
import week1.dianshangjinjie.bw.com.demo2.base.base.BaseFragment;
import week1.dianshangjinjie.bw.com.demo2.base.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo2.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo2.enemty.HomeEnemty;
import week1.dianshangjinjie.bw.com.demo2.presenter.Presenter;

/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 09:49 modify by liujc
 */
public class HomeFragment extends BaseFragment implements  Icontract.Iview {

@BindView(R.id.recy_id)
    RecyclerView recy_id;
    private List<HomeEnemty.ResultBean> result;

    @Override
    protected BasePresenter Ipresenter() {
        Presenter  presenter = new Presenter();
        presenter.getModel();
        return presenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.home_layout;
    }

    @Override
    protected void initView(View view) {


    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recy_id.setLayoutManager(manager);
    }



    @Override
    public void sucess(HomeEnemty homeEnemty) {
        Toast.makeText(getContext(), homeEnemty.getMessage(), Toast.LENGTH_SHORT).show();
        result = homeEnemty.getResult();
        if (result!=null){
            HomeAdapter adapter = new HomeAdapter(getContext(),result);
            recy_id.setAdapter(adapter);
        }
    }
}
