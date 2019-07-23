package mdp.xha.com.materialdesignpro;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ysq on 2019/7/23.
 */

public class ExampleAdapter extends FragmentPagerAdapter {

    private Context context;
    private List<Fragment> mlist;
    private  final String[] mTitles = {"样例1", "样例2", "样例3","样例4","样例5","样例6","样例7","样例8"};

    public ExampleAdapter(FragmentManager fm,Context context,List<Fragment> mlist) {
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


    public View setView(int pos){
        View view =View.inflate(context,R.layout.layout_tab_content,null);
        TextView tv_tab = view.findViewById(R.id.tv_tab_view);
        tv_tab.setText(mTitles[pos]);
        return view;
    }

}
