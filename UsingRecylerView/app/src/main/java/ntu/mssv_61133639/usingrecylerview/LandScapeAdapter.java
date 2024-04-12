package ntu.mssv_61133639.usingrecylerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> lstData;

    //Khai báo rồi thì generate Contructor cho 2 tham số trên
    public LandScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemLandHolder extends RecyclerView.ViewHolder{
        TextView tvCaption;
        ImageView ivLandscape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.txtViewCaption);
            ivLandscape = itemView.findViewById(R.id.imgViewLand);
        }
    }
}
