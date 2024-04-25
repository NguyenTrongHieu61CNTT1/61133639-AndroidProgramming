package ntu.mssv_61133639.vd2_loginwithintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tìm điều khiển:
        Button btnDangNhap = (Button) findViewById(R.id.btn_login);

        //Xử lý sự kiện:
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Code xử lý:
                Intent iLogin = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(iLogin);
            }
        });
    }
}