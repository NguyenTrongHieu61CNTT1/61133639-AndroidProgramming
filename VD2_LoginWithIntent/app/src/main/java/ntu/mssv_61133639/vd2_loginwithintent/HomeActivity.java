package ntu.mssv_61133639.vd2_loginwithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Lấy thông tin user:
        Intent iThongTin = getIntent();
        //Lọc ra lấy dữ liệu:
        String tenHienThi = iThongTin.getStringExtra("ten_dang_nhap");
        //Gắn tên vào điều khiển:
        TextView tvTenDN = (TextView) findViewById(R.id.ten);
        tvTenDN.setText(tenHienThi);
    }
}