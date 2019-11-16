package week1.dianshangjinjie.bw.com.week3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import week1.dianshangjinjie.bw.com.week3.R;
import week1.dianshangjinjie.bw.com.week3.adapter.OneAdapter;
import week1.dianshangjinjie.bw.com.week3.adapter.ThreeAdapter;
import week1.dianshangjinjie.bw.com.week3.adapter.TwoAdapter;
import week1.dianshangjinjie.bw.com.week3.base.BaseActivity;
import week1.dianshangjinjie.bw.com.week3.base.BasePresenter;
import week1.dianshangjinjie.bw.com.week3.contract.Icontract;
import week1.dianshangjinjie.bw.com.week3.contract.Icontract.Iview;
import week1.dianshangjinjie.bw.com.week3.entity.SQentity;
import week1.dianshangjinjie.bw.com.week3.presenter.Presenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

public class MainActivity extends BaseActivity implements Icontract.Iview {

    private RecyclerView home_recy1,home_recy2,home_recy3;
    private ImageView img_view1;
    private TextView text_name1;
    private TextView text_name2;
    private ImageView btn_tiao;

    @Override
    protected void initData() {
        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.VERTICAL);
        home_recy1.setLayoutManager(manager1);

        //点击按钮跳转
        btn_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,XQActivity.class));
            }
        });
    }

    @Override
    protected void initView() {
        home_recy1 = findViewById(R.id.home_recy1);
        img_view1 = findViewById(R.id.img_view1);
        text_name1 = findViewById(R.id.text_name1);
        text_name2 = findViewById(R.id.text_name2);
        btn_tiao = findViewById(R.id.btn_tiao);


    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        Presenter presenter = new Presenter();
        presenter.getData();
        return presenter;
    }



    @Override
    public void success(SQentity sQentity) {
        //展示列表
        Toast.makeText(this, sQentity.getMessage(), Toast.LENGTH_SHORT).show();
        List<SQentity.ResultBean> result = sQentity.getResult();
        OneAdapter oneAdapter = new OneAdapter(this, result);
        home_recy1.setAdapter(oneAdapter);
        oneAdapter.notifyDataSetChanged();

//        List<SQentity.ResultBean.CommunityCommentVoListBean> communityCommentVoList2 = result.get(1).getCommunityCommentVoList();
//        TwoAdapter twoAdapter = new TwoAdapter(this, communityCommentVoList2);
//        home_recy1.setAdapter(twoAdapter);
//        List<SQentity.ResultBean.CommunityCommentVoListBean> communityCommentVoList3 = result.get(2).getCommunityCommentVoList();
//        ThreeAdapter threeAdapter = new ThreeAdapter(this, communityCommentVoList3);
//        home_recy1.setAdapter(threeAdapter);
    }
}
