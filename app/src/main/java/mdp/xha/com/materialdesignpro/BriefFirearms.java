package mdp.xha.com.materialdesignpro;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.transition.Explode;
import android.transition.Transition;
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
 * Created by ysq on 2019/7/19.
 */

public class BriefFirearms extends Fragment {


    private SmartRefreshLayout srl;
    public RecyclerView rv_list;
    private List<Integer> mlist;
    private BriefFirearmsAdapter adapter;
    private Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = View.inflate(getActivity(),R.layout.fragment_brieffirearms,null);
        srl=view.findViewById(R.id.srl);
        rv_list=view.findViewById(R.id.rv_list);
        mlist = new ArrayList<>();
        for (int i=0;i<10;i++){
            mlist.add(i);
        }
        //开始下拉
        srl.setEnableRefresh(true);//启用刷新
        srl.setEnableAutoLoadMore(true);//启用加载
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new BriefFirearmsAdapter(mlist,getActivity());

        rv_list.setLayoutManager(new GridLayoutManager(getActivity(),2));
        rv_list.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback());
        itemTouchHelper.attachToRecyclerView(rv_list);
        srl.setOnRefreshListener(new OnRefreshListener() {
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
                        srl.finishRefresh();
                    }
                },1000);
            }
        });
        srl.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                for (int i=0;i<10;i++){
                    mlist.add(i);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                        srl.finishLoadMore();
                    }
                },1000);

            }
        });
        adapter.setItemClickListener(itemClickListener);
    }

    private BriefFirearmsAdapter.adapterItemClickListener itemClickListener = new BriefFirearmsAdapter.adapterItemClickListener() {
        @Override
        public void itemClickListener(View view, int pos) {

            getActivity().getWindow().setExitTransition(new Explode());

            Intent intent = new Intent(getActivity(),DetailsActivity.class);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());

        }
    };

    class ItemTouchHelperCallback extends ItemTouchHelper.Callback {

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
            return makeMovementFlags(dragFlags,swipeFlags);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            adapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            adapter.onItemDismiss(viewHolder.getAdapterPosition());
        }
    }

}
