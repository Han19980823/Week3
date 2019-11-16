package week1.dianshangjinjie.bw.com.demo1.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import week1.dianshangjinjie.bw.com.demo1.R;
import week1.dianshangjinjie.bw.com.demo1.adapter.HomeAdapter;
import week1.dianshangjinjie.bw.com.demo1.base.BaseActivity;
import week1.dianshangjinjie.bw.com.demo1.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo1.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo1.enemty.HomeEnemty;
import week1.dianshangjinjie.bw.com.demo1.presenter.Presenter;


public class MainActivity extends BaseActivity implements Icontract.Iview{
    @BindView(R.id.recy_id)
    RecyclerView recy_view;


//  @OnClick(R.id.btn_img)
//  public void btn(View view){
//      startActivity(new Intent(MainActivity.this,HomeActivity.class));
//  }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recy_view.setLayoutManager(manager);
    }

    @Override
    protected BasePresenter Ipresenter() {
        Presenter presenter = new Presenter();
        presenter.getData();
        return presenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void success(HomeEnemty homeEnemty) {
        Toast.makeText(this, homeEnemty.getMessage(), Toast.LENGTH_SHORT).show();
        List<HomeEnemty.ResultBean> result = homeEnemty.getResult();
        recy_view.setAdapter(new HomeAdapter(this,result));
    }


}
