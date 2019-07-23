package mdp.xha.com.materialdesignpro;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysq on 2019/7/22.
 */

public class ProfileFragment extends Fragment{

    private TabLayout tablayout;
    private ViewPager vp_content;

    private List<Fragment> fragmentList;
    private ProfileAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.fragment_profile,null);
        tablayout=view.findViewById(R.id.tablayout);
        vp_content=view.findViewById(R.id.vp_content);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentList = new ArrayList<>();
        fragmentList.add(new PagerFragment());
        fragmentList.add(new PagerFragment());
        fragmentList.add(new PagerFragment());
        fragmentList.add(new PagerFragment());
        fragmentList.add(new PagerFragment());
        fragmentList.add(new PagerFragment());
        adapter = new ProfileAdapter(getChildFragmentManager(),getActivity(),fragmentList);
        vp_content.setAdapter(adapter);
        tablayout.setupWithViewPager(vp_content);
        for (int i=0;i<tablayout.getTabCount();i++){
            TabLayout.Tab tabAt = tablayout.getTabAt(i);
            tabAt.setCustomView(adapter.setTabView(i));
        }
    }
}
