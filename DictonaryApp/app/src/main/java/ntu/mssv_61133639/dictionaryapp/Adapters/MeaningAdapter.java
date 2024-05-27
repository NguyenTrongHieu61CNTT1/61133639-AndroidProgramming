package ntu.mssv_61133639.dictionaryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ntu.mssv_61133639.dictionaryapp.Models.Meanings;
import ntu.mssv_61133639.dictionaryapp.R;
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
        return new MeaningViewHolder(LayoutInflater.from(context).inflate(R.layout.meanings_list_items, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
        holder.textView_partOfSpeech.setText("Loại từ: " + meaningsList.get(position).getPartOfSpeech());
        holder.recycler_definitions.setHasFixedSize(true);
        holder.recycler_definitions.setLayoutManager(new GridLayoutManager(context, 1));
        DefinitionAdapter definitionAdapter = new DefinitionAdapter(context, meaningsList.get(position).getDefinitions());
        holder.recycler_definitions.setAdapter(definitionAdapter);
    }

    @Override
    public int getItemCount() {
        return meaningsList.size();
    }
}
