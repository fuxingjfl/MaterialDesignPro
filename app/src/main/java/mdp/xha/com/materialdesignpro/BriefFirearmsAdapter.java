package mdp.xha.com.materialdesignpro;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ysq on 2019/7/19.
 */

public class BriefFirearmsAdapter extends RecyclerView.Adapter<BriefFirearmsAdapter.ViewHodle> implements IItemHelper{

    private List<Integer> mlist;

    private Context context;
    private adapterItemClickListener adapterItemClickListener;

    public BriefFirearmsAdapter(List<Integer> mlist, Context context){
        this.mlist=mlist;
        this.context=context;
    }

    @Override
    public ViewHodle onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item_home,null);

        return new ViewHodle(view);
    }

    @Override
    public void onBindViewHolder(ViewHodle holder, final int position) {

        CardView cv = holder.cv;
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterItemClickListener.itemClickListener(v,position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Integer remove = mlist.remove(fromPosition);
        int num;
        if (toPosition > fromPosition)
        {
            num  = toPosition - 1;
        } else{
            num=toPosition;
        }
        mlist.add(num,remove);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        mlist.remove(position);
        notifyItemRemoved(position);
    }

    class ViewHodle extends RecyclerView.ViewHolder{

        CardView cv;

        public ViewHodle(View itemView) {
            super(itemView);
            cv=itemView.findViewById(R.id.cv);
        }
    }

    public void setItemClickListener(adapterItemClickListener adapterItemClickListener){
        this.adapterItemClickListener=adapterItemClickListener;
    }

    public interface adapterItemClickListener{
        void itemClickListener(View view,int pos);
    }
}
