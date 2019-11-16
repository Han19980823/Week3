package week1.dianshangjinjie.bw.com.week3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import week1.dianshangjinjie.bw.com.week3.R;
import week1.dianshangjinjie.bw.com.week3.entity.SQentity;

/**
 * 作者：Han98
 * 创建时间：2019/11/14
 * 描述：TODO
 * 最近修改：2019/11/14 20:31 modify by liujc
 */
public  class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.fisAdapter> {
    Context context;
    List<SQentity.ResultBean.CommunityCommentVoListBean> list;

    public ThreeAdapter(Context context, List<SQentity.ResultBean.CommunityCommentVoListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public fisAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.three_layout, parent, false);
        return new fisAdapter(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull fisAdapter holder, int position) {
        holder.text_name1.setText(list.get(position).getNickName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class fisAdapter extends RecyclerView.ViewHolder{
        ImageView img_view1,img_view2,img_view3,img_view4,img_view5;
        TextView text_name1,text_name2,text_name3,text_name4;
        public fisAdapter(@NonNull View itemView) {
            super(itemView);
            img_view1 = itemView.findViewById(R.id.img_view1);
            img_view2 = itemView.findViewById(R.id.img_view2);
            img_view3 = itemView.findViewById(R.id.img_view3);
            img_view4 = itemView.findViewById(R.id.img_view4);
            img_view5 = itemView.findViewById(R.id.img_view5);
            text_name1 = itemView.findViewById(R.id.text_name1);
            text_name2 = itemView.findViewById(R.id.text_name2);
            text_name3 = itemView.findViewById(R.id.text_name3);
            text_name4 = itemView.findViewById(R.id.text_name4);
        }
    }

}
