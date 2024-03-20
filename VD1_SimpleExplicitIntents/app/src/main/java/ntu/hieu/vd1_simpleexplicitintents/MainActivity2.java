package ntu.hieu.vd1_simpleexplicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    //Thực hiẹn xử lý quay về trang chủ
    public void quayVe(View v){
        //Tạo đối tượng Intent
        //Tham số thứ 2 truyền vào sẽ là màn hình chính
        Intent iMHChinh = new Intent(this, MainActivity.class);
        //Thực hiện chuyển
        startActivity(iMHChinh);
    }
}
