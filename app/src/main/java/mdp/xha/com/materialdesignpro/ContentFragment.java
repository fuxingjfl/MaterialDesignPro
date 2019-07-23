package mdp.xha.com.materialdesignpro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysq on 2019/7/19.
 */

public class ContentFragment extends Fragment {


    private TabLayout tab_xf;
    private ViewPager vp_tab_content;

    private List<Fragment> lists;
    private ExampleAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(),R.layout.fragment_content,null);
        tab_xf=view.findViewById(R.id.tab_xf);
        vp_tab_content=view.findViewById(R.id.vp_tab_content);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lists = new ArrayList<>();
        lists.add(new ExampleFragment());
        lists.add(new ExampleFragment());
        lists.add(new ExampleFragment());
        lists.add(new ExampleFragment());
        lists.add(new ExampleFragment());
        lists.add(new ExampleFragment());
        lists.add(new ExampleFragment());
        lists.add(new ExampleFragment());
        adapter = new ExampleAdapter(getChildFragmentManager(),getActivity(),lists);
        vp_tab_content.setAdapter(adapter);
        tab_xf.setupWithViewPager(vp_tab_content);
        for (int i=0;i<tab_xf.getTabCount();i++){
            TabLayout.Tab tabAt = tab_xf.getTabAt(i);
            if (tabAt!=null){
                tabAt.setCustomView(adapter.setView(i));
            }
        }
    }
}
