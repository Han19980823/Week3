package week1.dianshangjinjie.bw.com.demo2.utils;

import android.util.Log;

import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import week1.dianshangjinjie.bw.com.demo2.view.App;
import week1.dianshangjinjie.bw.com.demo2.R;
import week1.dianshangjinjie.bw.com.demo2.api.Api;

/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 10:23 modify by liujc
 */
public class Utils {
    private static  Utils utils;
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;

    /**
     *
     * 构造
     */
    private Utils(){
        try {
            //创建证书对象，方便管理证书数据
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);//初始化证书资源，首次是空

            //校验证书，x.509协议，所有的证书都是通过x.509协议生成的
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(App.context.getResources().openRawResource(R.raw.server));

            //ssl协议入场，看看是不是符合ssl协议标准
            SSLContext sc = SSLContext.getInstance("TLS");
            //信任证书管理,这个是由我们自己生成的,信任我们自己的服务器证书
            TrustManager tm = new MyTrustManager(certificate);
            sc.init(null, new TrustManager[]{
                    tm
            }, null);

            okHttpClient= new OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .writeTimeout(5, TimeUnit.SECONDS)
                    .readTimeout(5, TimeUnit.SECONDS)
                    .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .hostnameVerifier(new TrustHostnameVerifier())
                    .sslSocketFactory(sc.getSocketFactory(), (X509TrustManager) tm)
                    .build();

            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Api.BASE_URL)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *   单例模式
     * @re turn
     */

    public static Utils getInstance(){
        if (utils==null){
            synchronized (Utils.class){
                if (utils == null){
                    utils = new Utils();
                }
            }
        }
        return utils;
    }

    /**
     *
     * @param clz  动态代理模式
     * @param <T>
     * @return
     */

    public <T> T getService(Class<T> clz){
        return retrofit.create(clz);
    }






    /**
     * 实现了 X509TrustManager
     * 通过此类中的 checkServerTrusted 方法来确认服务器证书是否正确
     */
    static  class MyTrustManager implements X509TrustManager {
        X509Certificate cert;

        MyTrustManager(X509Certificate cert) {
            this.cert = cert;
        }

        /**
         * 信任客户端的
         * @param chain
         * @param authType
         * @throws CertificateException
         */
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // 我们在客户端只做服务器端证书校验。
        }

        /**
         * 信任服务器的
         * @param chain
         * @param authType
         * @throws CertificateException
         */
        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // 确认服务器端证书和代码中 hard code 的 CRT 证书相同。
            if (chain[0].equals(this.cert)) {
                Log.i("Jin", "checkServerTrusted Certificate from server is valid!");
                return;// found match
            }
            throw new CertificateException("checkServerTrusted No trusted server cert found!");
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }


    /**
     * 校验主机名
     */
    public static class TrustHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {

            if (hostname.trim().equals("172.17.8.100")) {//必须注意，根据题目要求配置相应主机名（域名或者ip地址）
                return true;
            }else{
                return false;
            }
        }
    }


}
