package week1.dianshangjinjie.bw.com.demo1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import week1.dianshangjinjie.bw.com.demo1.R;
import week1.dianshangjinjie.bw.com.demo1.enemty.HomeEnemty;

/**
 * 作者：Han98
 * 创建时间：2019/11/15
 * 描述：TODO
 * 最近修改：2019/11/15 17:03 modify by liujc
 */
public  class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.imgHolder> {
    List<HomeEnemty.ResultBean> list;
    Context context;

    public ImgAdapter(List<HomeEnemty.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public imgHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.img_id,null);
        return new imgHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull imgHolder holder, int position) {
        Glide.with(context).load(list.get(position).getFile()+"").into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class imgHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public imgHolder(@NonNull View itemView) {
            super(itemView);
            imageView =  itemView.findViewById(R.id.imgView);
        }
    }
}
