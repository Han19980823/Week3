package week1.dianshangjinjie.bw.com.demo1.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import week1.dianshangjinjie.bw.com.demo1.enemty.HomeEnemty;

/**
 * 作者：Han98
 * 创建时间：2019/11/15
 * 描述：TODO
 * 最近修改：2019/11/15 15:09 modify by liujc
 */
public interface ApiService {
    //请求列表
    @GET("techApi/community/v1/findCommunityList")
    Observable<HomeEnemty> service(@Header("userId") int id, @Header("sessionId") String sid, @Query("page")int pger, @Query("count") int count);
}
