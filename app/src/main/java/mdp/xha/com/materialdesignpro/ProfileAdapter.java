package mdp.xha.com.materialdesignpro;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ysq on 2019/7/22.
 */

public class ProfileAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<Fragment> mlist;
    private  final String[] mTitles = {"德约", "奶牛", "西里奇","西西帕斯","纳达尔","伯蒂奇"};

    public ProfileAdapter(FragmentManager fm,Context context,List<Fragment> mlist) {
        super(fm);
        this.context=context;
        this.mlist=mlist;
    }

    @Override
    public Fragment getItem(int i) {
        return mlist.get(i);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    public View setTabView(int pos){
        View view = View.inflate(context,R.layout.layout_tab,null);
        TextView tv_tab = view.findViewById(R.id.tv_tab);
        tv_tab.setText(mTitles[pos]);
        return view;
    }

}
