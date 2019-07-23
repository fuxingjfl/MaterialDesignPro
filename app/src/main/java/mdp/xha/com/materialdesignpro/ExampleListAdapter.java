package mdp.xha.com.materialdesignpro;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ysq on 2019/7/23.
 */

public class ExampleListAdapter  extends  RecyclerView.Adapter<ExampleListAdapter.ViewHoder>{

    private Context context;
    private List<Integer> data;

    public ExampleListAdapter(Context context,List<Integer> data){
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.list_item_layout,viewGroup,false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleListAdapter.ViewHoder viewHoder, int i) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHoder extends RecyclerView.ViewHolder{

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
