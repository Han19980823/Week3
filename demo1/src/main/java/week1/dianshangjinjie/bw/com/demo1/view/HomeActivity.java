package week1.dianshangjinjie.bw.com.demo1.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import week1.dianshangjinjie.bw.com.demo1.R;
import week1.dianshangjinjie.bw.com.demo1.base.BaseActivity;
import week1.dianshangjinjie.bw.com.demo1.base.BasePresenter;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.et_text)
    EditText etText;
    @BindView(R.id.addImg)
    ImageView addImg;
    @BindView(R.id.RecyclerView)
    androidx.recyclerview.widget.RecyclerView RecyclerView;
    @BindView(R.id.camara)
    Button camara;
    @BindView(R.id.photo)
    Button photo;
    @BindView(R.id.cancel)
    Button cancel;
    @BindView(R.id.dialog_layout)
    RelativeLayout dialogLayout;
    @BindView(R.id.btn_post_centel)
    Button btnPostCentel;
    @BindView(R.id.btn_post_data)
    Button btnPostData;

    @OnClick(R.id.camara)
    public void getCamere(View view){
        dialogLayout.setGravity(View.VISIBLE);

    }
    @OnClick(R.id.photo)
    public void getPhoto(View view){

    }
    @OnClick(R.id.cancel)
    public void getCanel(View view){

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

}
