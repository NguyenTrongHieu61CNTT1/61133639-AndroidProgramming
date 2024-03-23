package ntu.MSSV_61133639.cau2_apptaohinhanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    //Khai báo các biến
    EditText txtNhap;
    MaterialButton btnTaoHinhAnh;
    ProgressBar thanhTienDo;
    ImageView img;

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lấy id từng điều khiển
        txtNhap = findViewById(R.id.txtNhap);
        btnTaoHinhAnh = findViewById(R.id.btnTao);
        thanhTienDo = findViewById(R.id.progress_bar);
        img = findViewById(R.id.img);

        //Tạo các bộ listener
        btnTaoHinhAnh.setOnClickListener((v)-> {
            String text = txtNhap.getText().toString().trim(); //Lấy text được nhập vào, trim(): Xóa khoảng trắng ở đầu và cuối chuỗi
            if (text.isEmpty()) {
                txtNhap.setError("Bạn chưa nhập nội dung nè!");
                return;
            }
            callAPI(text);
        });
    }

    void callAPI(String text){
        //Hàm gọi web API
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("prompt", text);
            jsonBody.put("size","256x256");
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(jsonBody.toString(), JSON);
        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/images/generations")
                .header("Authorization", "Bearer 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")
                .post(requestBody)
                .build();

        //Hàm Callback không đồng bộ, khi request hoàn thành hay bị lỗi thì hàm onResponse() or hàm onFailure() sẽ được gọi tương ứng
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                //Thông báo thất bại
                Toast.makeText(getApplicationContext(), "Tạo hình ảnh thất bại!", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                Log.i("Response: ", response.body().string());
            }
        });
    }
}