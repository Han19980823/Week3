package week1.dianshangjinjie.bw.com.demo1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import week1.dianshangjinjie.bw.com.demo1.R;
import week1.dianshangjinjie.bw.com.demo1.enemty.HomeEnemty;

/**
 * 作者：Han98
 * 创建时间：2019/11/15
 * 描述：TODO
 * 最近修改：2019/11/15 16:22 modify by liujc
 */
public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.Holder>{
    Context context;
    List<HomeEnemty.ResultBean> list;

    public HomeAdapter(Context context, List<HomeEnemty.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.one,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(list.get(position).getHeadPic()).into(holder.img_view);
        holder.text_name.setText((list.get(position)).getSignature());
        holder.text_id.setText(list.get(position).getUserId()+"");
        holder.img_reid.setLayoutManager(new GridLayoutManager(context,3));
        holder.text_context.setText(list.get(position).getContent());
        holder.img_reid.setAdapter(new ImgAdapter(list,context));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class Holder extends RecyclerView.ViewHolder{
        ImageView img_view;
        TextView text_name,text_context;
        TextView text_id;
        RecyclerView img_reid;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img_view =   itemView.findViewById(R.id.img_view);
            text_name =  itemView.findViewById(R.id.text_name);
            text_id =  itemView.findViewById(R.id.text_id);
            text_context =  itemView.findViewById(R.id.text_context);
        }
    }
}
