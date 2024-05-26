package ntu.mssv_61133639.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ntu.mssv_61133639.dictionaryapp.R;

public class MeaningViewHolder extends RecyclerView.ViewHolder {
    TextView textView_partOfSpeech;
    RecyclerView recycler_definitions;
    public MeaningViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_partOfSpeech = itemView.findViewById(R.id.textView_partOfSpeech);
        recycler_definitions = itemView.findViewById(R.id.recycler_definitions);
    }
}
