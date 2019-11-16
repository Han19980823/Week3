package week1.dianshangjinjie.bw.com.week3.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import week1.dianshangjinjie.bw.com.week3.R;
import week1.dianshangjinjie.bw.com.week3.adapter.PostAdapter;
import week1.dianshangjinjie.bw.com.week3.aps.ApiService;
import week1.dianshangjinjie.bw.com.week3.base.BaseActivity;
import week1.dianshangjinjie.bw.com.week3.base.BasePresenter;
import week1.dianshangjinjie.bw.com.week3.entity.Post;
import week1.dianshangjinjie.bw.com.week3.presenter.Presenter;
import week1.dianshangjinjie.bw.com.week3.utils.RestrfitUtils;

public class XQActivity extends BaseActivity {


    @BindView(R.id.et_text)
    EditText etText;
    @BindView(R.id.RecyclerView)
     RecyclerView RecyclerView;
    @BindView(R.id.addImg)
    ImageView addImg;
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
    List<LocalMedia> selectList;//文件列表
    @Override
    protected void initData() {
    }

    @Override
    protected void initView() {
        RecyclerView.setLayoutManager(new GridLayoutManager(this,3));

    }


    @OnClick(R.id.addImg)
    public void addimg(View view) {
        //调用相机或相册
        dialogLayout.setVisibility(View.VISIBLE);
    }


    @OnClick(R.id.camara)
    public void camara(View view) {
        dialogLayout.setVisibility(View.GONE);
        PictureSelector.create(XQActivity.this)
                .openCamera(PictureMimeType.ofImage())//打开相机
                .compress(true)
                .maxSelectNum(9)// 最大图片选择数量 int
                .minSelectNum(1)
                .openClickSound(true)// 是否开启点击声音 true or false
                .selectionMedia(selectList)// 是否传入已选图片 List<LocalMedia> list
                .isCamera(true)
                .forResult(PictureConfig.CHOOSE_REQUEST);

    }

    @OnClick(R.id.photo)
    public void photo(View view) {
        dialogLayout.setVisibility(View.GONE);
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//打开相册
                .compress(true)
                .forResult(PictureConfig.CHOOSE_REQUEST);

    }

    @OnClick(R.id.cancel)
    public void cancel(View view) {
        dialogLayout.setVisibility(View.GONE);
    }

    @OnClick(R.id.btn_post_data)
    public void add(View view){

        //多表单文件对象列表，通过集合维护
        List<MultipartBody.Part> filesPart = new ArrayList<>();

        //遍历已经选择的图片数据，并且转换成文件对象，保存到文件对象列表中
        for (LocalMedia localMedia : selectList) {
            //床架文件对象
            File file = new File(localMedia.getCompressPath());

            //把文件对象包装成请求体对象
//            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用file
            //最终转换成需要的多表单对象
            MultipartBody.Part body = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

            filesPart.add(body);
        }

        if (etText.getText().toString().length()==0){
            Toast.makeText(this, "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        //文本
        RequestBody content = RequestBody.create(MediaType.parse("multipart/form-data"),etText.getText().toString());

        //发布帖子接口
        RestrfitUtils.getInstance().initInstnce(ApiService.class)
                .postContent(839,"1573731663360839",content,filesPart)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Post>() {
                    @Override
                    public void accept(Post post) throws Exception {
                        Toast.makeText(XQActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_xq;
    }

    @Override
    protected BasePresenter Ipresenter() {
        Presenter presenter = new Presenter();

        return presenter;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    if (selectList!=null&&selectList.size()>0){
                        selectList.clear();
                    }
                    // 图片、视频、音频选择结果回调,框架的回调
                    selectList = PictureSelector.obtainMultipleResult(data);

                    PostAdapter postAdapter = new PostAdapter(XQActivity.this,selectList);
                    RecyclerView.setAdapter(postAdapter);

                    break;
            }
        }
    }

}
