package week1.dianshangjinjie.bw.com.demo2.api;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import week1.dianshangjinjie.bw.com.demo2.enemty.HomeEnemty;
import week1.dianshangjinjie.bw.com.demo2.enemty.PhotoEmety;

/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 11:43 modify by liujc
 */
public interface PhotoService {
    @POST("techApi/user/verify/v1/modifyHeadPic")
    @Multipart
    Observable<PhotoEmety> getPhoto(@Header("userId") int id, @Header("sessionId") String key, @Part MultipartBody.Part file);
}
