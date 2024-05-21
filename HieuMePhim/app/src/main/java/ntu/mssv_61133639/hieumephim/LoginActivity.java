package ntu.mssv_61133639.hieumephim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);

        //Xử lý sự kiện login:
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Điều kiện:
                if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Tên đăng nhập và Mật khẩu không được để trống!", Toast.LENGTH_SHORT).show();
                } else if (username.getText().toString().equals("Hieu") &&  password.getText().toString().equals("1234")) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else {
                    Toast.makeText(LoginActivity.this, "Tên đăng nhập và mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}