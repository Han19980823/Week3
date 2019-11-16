package week1.dianshangjinjie.bw.com.demo2.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import week1.dianshangjinjie.bw.com.demo2.enemty.HomeEnemty;


/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 10:47 modify by liujc
 */
public interface HomeService {
    @GET("techApi/community/v1/findCommunityList")
    Observable<HomeEnemty> setive(@Header("sessionId") String key, @Query("page") int page, @Query("count") int count);
}
