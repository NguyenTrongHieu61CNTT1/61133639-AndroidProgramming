package ntu.mssv_61133639.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import ntu.mssv_61133639.dictionaryapp.Adapters.MeaningAdapter;
import ntu.mssv_61133639.dictionaryapp.Adapters.PhoneticAdapter;
import ntu.mssv_61133639.dictionaryapp.Models.APIResponse;

public class MainActivity extends AppCompatActivity {

    SearchView search_view;
    TextView textView_word;
    RecyclerView recycler_phonetics, recycler_meanings;
    ProgressDialog dialog;
    PhoneticAdapter phoneticAdapter;
    MeaningAdapter meaningAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        textView_word = findViewById(R.id.textView_word);
        recycler_phonetics = findViewById(R.id.recycler_phonetics);
        recycler_meanings = findViewById(R.id.recycler_meanings);
        dialog = new ProgressDialog(this);

        dialog.setTitle("Đang tải...");
        dialog.show();
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getWordMeaning(listener, "beautiful");

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Đang tìm nạp dữ liệu của từ " + query);
                dialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            dialog.dismiss();
            if (apiResponse == null){
                Toast.makeText(MainActivity.this, "Không tìm thấy dữ liệu!", Toast.LENGTH_SHORT).show();
                return;
            }
            showResult(apiResponse);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showResult(APIResponse response){
        textView_word.setText("Từ bạn tìm kiếm: " + response.getWord());

        recycler_phonetics.setHasFixedSize(true);
        recycler_phonetics.setLayoutManager(new GridLayoutManager(this, 1));
        phoneticAdapter = new PhoneticAdapter(this, response.getPhonetics());
        recycler_phonetics.setAdapter(phoneticAdapter);

        recycler_meanings.setHasFixedSize(true);
        recycler_meanings.setLayoutManager(new GridLayoutManager(this, 1));
        meaningAdapter = new MeaningAdapter(this, response.getMeanings());
        recycler_meanings.setAdapter(meaningAdapter);
    }
}