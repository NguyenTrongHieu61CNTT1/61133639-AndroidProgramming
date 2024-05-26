package ntu.mssv_61133639.dictionaryapp.Adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ntu.mssv_61133639.dictionaryapp.Models.Meanings;
import ntu.mssv_61133639.dictionaryapp.ViewHolders.MeaningViewHolder;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningViewHolder> {
    private Context context;
    protected List<Meanings> meaningsList;

    public MeaningAdapter(Context context, List<Meanings> meaningsList) {
        this.context = context;
        this.meaningsList = meaningsList;
    }

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
