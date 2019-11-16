package week1.dianshangjinjie.bw.com.demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.demo2.adapter.FragmentAdapter;
import week1.dianshangjinjie.bw.com.demo2.base.bases.BaseActivity;
import week1.dianshangjinjie.bw.com.demo2.fragment.HomeFragment;
import week1.dianshangjinjie.bw.com.demo2.fragment.MyFragment;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

   @BindView(R.id.view_pager)
    ViewPager viewPager;
   @BindView(R.id.tab_layout)
    TabLayout tabLayout;
   private List<String> list = new ArrayList<>();
   private List<Fragment> flist = new ArrayList<>();

    @Override
    protected void initData() {
            list.add("首页");
            list.add("我的");
            flist.add(new HomeFragment());
            flist.add(new MyFragment());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(),list,flist);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.GREEN,Color.RED);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }
}
