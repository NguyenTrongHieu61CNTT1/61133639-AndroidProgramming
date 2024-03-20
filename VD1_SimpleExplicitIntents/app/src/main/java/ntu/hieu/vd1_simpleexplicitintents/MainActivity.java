package ntu.hieu.vd1_simpleexplicitintents;

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

    //Hàm xử lý khi nhấn nút sẽ chuyển đổi sang màn hình khác
    public void chuyenMH(View v){
        //Tạo đối tượng Intent
        //Tham số thứ 2 của hàm là tên màn hình (Activity) muốn chuyển sang
        Intent iMHPhu = new Intent(this, MainActivity2.class);
        //Thực hiện chuyển đổi
        startActivity(iMHPhu);
    }
}