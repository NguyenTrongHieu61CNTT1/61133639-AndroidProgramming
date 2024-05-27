package ntu.mssv_61133639.dictionaryapp.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import ntu.mssv_61133639.dictionaryapp.Models.Phonetics;
import ntu.mssv_61133639.dictionaryapp.R;
import ntu.mssv_61133639.dictionaryapp.ViewHolders.PhoneticViewHolder;

public class PhoneticsAdapter extends RecyclerView.Adapter<PhoneticViewHolder> {
    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public PhoneticViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhoneticViewHolder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_items, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneticViewHolder holder, int position) {
        holder.textView_phonetic.setText(phoneticsList.get(position).getText());
        holder.imageButton_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player = new MediaPlayer();
                try{
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource("https:" + phoneticsList.get(holder.getAdapterPosition()).getAudio()); //Position
                    player.prepare();
                    player.start();
                }catch (IOException e){
                    e.printStackTrace();
                    Toast.makeText(context, "Không thể đọc phát âm!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
