package week1.dianshangjinjie.bw.com.demo2.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.List;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import week1.dianshangjinjie.bw.com.demo2.R;
import week1.dianshangjinjie.bw.com.demo2.api.PhotoService;
import week1.dianshangjinjie.bw.com.demo2.base.base.BaseFragment;
import week1.dianshangjinjie.bw.com.demo2.base.base.BasePresenter;
import week1.dianshangjinjie.bw.com.demo2.contract.Icontract;
import week1.dianshangjinjie.bw.com.demo2.enemty.HomeEnemty;
import week1.dianshangjinjie.bw.com.demo2.enemty.PhotoEmety;
import week1.dianshangjinjie.bw.com.demo2.presenter.Presenter;
import week1.dianshangjinjie.bw.com.demo2.utils.Utils;
import week1.dianshangjinjie.bw.com.demo2.view.App;

import static android.app.Activity.RESULT_OK;

/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 09:49 modify by liujc
 */
public class MyFragment extends BaseFragment implements Icontract.IFrag {


    @BindView(R.id.img_btn)
    ImageView imgBtn;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_price)
    TextView textPrice;
    @BindView(R.id.camara)
    Button camara;
    @BindView(R.id.photo)
    Button photo;
    @BindView(R.id.cancel)
    Button cancel;
    @BindView(R.id.dialog_layout)
    RelativeLayout dialogLayout;

    List<LocalMedia> localMediaList;
    MultipartBody.Part filePart;

    @OnClick(R.id.img_btn)
    public void btn(View view) {
        dialogLayout.setVisibility(View.VISIBLE);
    }


    /**
     * @param view 调用相机
     */
    @OnClick(R.id.camara)
    public void camara(View view) {
        dialogLayout.setVisibility(View.GONE);
        PictureSelector.create(this)
                .openCamera(PictureMimeType.ofImage())
                .compress(true)
                .maxSelectNum(1)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    /**
     * 调用相册
     *
     * @param view
     */
    @OnClick(R.id.photo)
    public void photo(View view) {
        dialogLayout.setVisibility(View.GONE);
        PictureSelector.create(getActivity())
                .openGallery(PictureMimeType.ofImage())
                .compress(true)
                .forResult(PictureConfig.CHOOSE_REQUEST);

    }


    /**
     * 取消
     *
     * @param view
     */
    @OnClick(R.id.cancel)
    public void cancel(View view) {
        dialogLayout.setVisibility(View.GONE);
    }

    @Override
    protected BasePresenter Ipresenter() {
        Presenter presenter = new Presenter();
        presenter.getPhoto(filePart);
        return presenter;
    }

    @Override
    public void success(PhotoEmety photoEmety) {
        if (localMediaList != null && localMediaList.size() > 0) {
            Log.e("aaa", "post: " + localMediaList.size());
            File file = new File(localMediaList.get(0).getCompressPath());
            //把文件对象包装成请求体对象
//            RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            // MultipartBody.Part  和后端约定好Key，这里的partName是用file
            //最终转换成需要的多表单对象
            filePart = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
            Glide.with(getContext()).load(Uri.fromFile(new File(localMediaList.get(0).getCompressPath()))).into(imgBtn);

        }
    }


    /**
     * 回调
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调,框架的回调
                    localMediaList = PictureSelector.obtainMultipleResult(data);
                    break;
            }
        }
    }

    @Override
    protected int initLayout() {
        return R.layout.my_layout;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {


    }
}
