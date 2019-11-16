package week1.dianshangjinjie.bw.com.week3.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import week1.dianshangjinjie.bw.com.week3.R;

/**
 * 作者：Han98
 * 创建时间：2019/11/15
 * 描述：TODO
 * 最近修改：2019/11/15 13:47 modify by liujc
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.VH> {

    private Context context;
    private List<LocalMedia> list;

    public PostAdapter(Context context,  List<LocalMedia> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_item_layout,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        Glide.with(context).load(Uri.fromFile(new File(list.get(position).getCompressPath()))).into(holder.iv);



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder{

        private ImageView iv;
        public VH(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv);
        }
    }

}