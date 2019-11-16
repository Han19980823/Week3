package week1.dianshangjinjie.bw.com.demo2.adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * 作者：Han98
 * 创建时间：2019/11/16
 * 描述：TODO
 * 最近修改：2019/11/16 09:45 modify by liujc
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    List<String> slist ;
    List<Fragment> flist;

    public FragmentAdapter(@NonNull FragmentManager fm,  List<String> slist, List<Fragment> flist) {
        super(fm);
        this.slist = slist;
        this.flist = flist;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return flist.get(position);
    }

    @Override
    public int getCount() {
        return flist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return slist.get(position);
    }
}
