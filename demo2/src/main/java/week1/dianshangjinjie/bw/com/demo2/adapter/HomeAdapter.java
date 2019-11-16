package week1.dianshangjinjie.bw.com.demo2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import week1.dianshangjinjie.bw.com.demo2.R;

import week1.dianshangjinjie.bw.com.demo2.enemty.HomeEnemty;


/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 11:16 modify by liujc
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {
    Context context;
    List<HomeEnemty.ResultBean> list;

    public HomeAdapter(Context context, List<HomeEnemty.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_layout,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        RequestOptions mRequestOptions = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(position).getHeadPic()).apply(mRequestOptions).into(holder.imageView);
        holder.textView1.setText(list.get(position).getNickName());
        holder.textView2.setText(list.get(position).getPraise()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.img_view);
            textView1=itemView.findViewById(R.id.text_name);
            textView2=  itemView.findViewById(R.id.text_price);
        }
    }
}
