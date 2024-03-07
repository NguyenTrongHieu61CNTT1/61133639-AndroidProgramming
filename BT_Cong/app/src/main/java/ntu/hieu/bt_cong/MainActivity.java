package ntu.hieu.bt_cong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Gắn Layout tương ứng
        setContentView(R.layout.activity_main);
    }

    //Listener và xử lý event nút tính tổng
    public void xuLyCong(View view){
        //Tìm, tham chiếu đến điều khiển trong tệp XML -> mapping qua file Java
        EditText editTextSoA = findViewById(R.id.edtA); //Phải có kiểu tương tự trước khi khai báo biến
        EditText editTextSoB= findViewById(R.id.edtB);
        EditText editTextKQ = findViewById(R.id.edtKQ);
        //Lấy dữ liệu từ điều khiển số a và b:
        String strA = editTextSoA.getText().toString();
        String strB = editTextSoB.getText().toString();
        //Chuyển kiểu DL -> số
        int soA = Integer.parseInt(strA);
        int soB = Integer.parseInt(strB);
        //Xử lý tính toán:
        int tong = soA + soB;
        //Chuyển kết quả sang dạng chuỗi:
        String strTong = String.valueOf(tong);
        //Hiển thị:
        editTextKQ.setText(strTong);
    }
}