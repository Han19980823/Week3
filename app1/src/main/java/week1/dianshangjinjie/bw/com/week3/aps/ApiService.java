package week1.dianshangjinjie.bw.com.week3.aps;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import week1.dianshangjinjie.bw.com.week3.entity.Post;
import week1.dianshangjinjie.bw.com.week3.entity.SQentity;

/**
 * 作者：Han98
 * 创建时间：2019/11/14
 * 描述：TODO
 * 最近修改：2019/11/14 19:27 modify by liujc
 */
public interface ApiService {

    @GET("techApi/community/v1/findCommunityList")
    Observable<SQentity>  getData(@Header("userId") int userId, @Header("sessionId") String sessionId, @Query("page") int page,@Query("count") int count);
    @POST("techApi/community/verify/v1/releasePost")
    @Multipart
//多表单上传，可以上传文件和字符串
    Observable<Post> postContent(@Header("userId") int uid, @Header("sessionId") String sid, @Part("content") RequestBody content, @Part List<MultipartBody.Part> files);

}
