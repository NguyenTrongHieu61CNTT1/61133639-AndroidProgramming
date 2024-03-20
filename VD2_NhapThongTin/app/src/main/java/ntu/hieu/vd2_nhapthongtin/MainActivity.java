package ntu.hieu.vd2_nhapthongtin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nhapLieu(View v){
        //Tạo mới 1 Intent
        Intent iNhap = new Intent(this, MainActivity2.class);
        startActivity(iNhap,8000); //Code yêu cầu: 8000
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 8000){
            if (resultCode == RESULT_OK){
                String hoTenNhanDuoc = data.getStringExtra();
            }
        }
    }
}