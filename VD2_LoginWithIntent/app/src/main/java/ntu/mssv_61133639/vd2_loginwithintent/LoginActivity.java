package ntu.mssv_61133639.vd2_loginwithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnXacNhan = (Button) findViewById(R.id.btn_ok);

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Xử lý đăng nhập
                //B1: Tìm tham chiếu đến điều khiển
                EditText edtName = (EditText) findViewById(R.id.edt_username);
                EditText edtPass = (EditText) findViewById(R.id.edt_password);
                //B2: Lấy dữ liệu
                String tenDangNhap = edtName.getText().toString();
                String matKhau = edtPass.getText().toString();
                //Kiểm tra mật khẩu và tên đăng nhập
                if (tenDangNhap.equals("hieu") && matKhau.equals("123")){
                    //Đúng -> home
                    Intent iHome = new Intent(LoginActivity.this, HomeActivity.class);
                    //Gói dữ liệu vào HOME (key [Lọc dữ liệu qua key] - value)
                    iHome.putExtra("ten_dang_nhap", tenDangNhap);
                    iHome.putExtra("mat_khau", matKhau);
                    //Gửi đi:
                    startActivity(iHome);
                }
                else {
                    //Sai -> Thông báo
                    Toast.makeText(LoginActivity.this, "Bạn đã nhập sai, vui lòng nhập lại!", Toast.LENGTH_LONG);
                }
            }
        });
    }
}