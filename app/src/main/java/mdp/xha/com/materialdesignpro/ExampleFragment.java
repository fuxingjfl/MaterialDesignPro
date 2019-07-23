package mdp.xha.com.materialdesignpro;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysq on 2019/7/23.
 */

public class ExampleFragment extends Fragment {


    private RecyclerView rv_content;
    private SmartRefreshLayout example_srl;
    private ExampleListAdapter adapter;
    private List<Integer> mlist;
    private Handler handler = new Handler();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(),R.layout.fragment_example,null);
        rv_content=view.findViewById(R.id.rv_content);
        example_srl=view.findViewById(R.id.example_srl);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        example_srl.setEnableRefresh(true);
        example_srl.setEnableAutoLoadMore(true);
        mlist = new ArrayList<>();
        for (int i=0;i<20;i++){
            mlist.add(i);
        }
        adapter = new ExampleListAdapter(getActivity(),mlist);
        rv_content.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_content.setAdapter(adapter);
        example_srl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mlist.clear();
                for (int i=0;i<10;i++){
                    mlist.add(i);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        example_srl.finishRefresh();
                    }
                },1000);


            }
        });
        example_srl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                for (int i=0;i<10;i++){
                    mlist.add(i);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        example_srl.finishLoadMore();
                    }
                },1000);
            }
        });
    }
}
