package ntu.hieu.demo_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //B2:
        ArrayList<String> dsQua;
        dsQua = new ArrayList<String>();
        dsQua.add("Gấu bông siêu to khổng lồ");
        dsQua.add("Bó hoa siêu to đủ loại hoa");
        dsQua.add("Bánh kem Socola siêu ngon dát vàng");
        dsQua.add("Chuyến đi du lịch trên du thuyền Dubai");

        //B3:
        ArrayAdapter<String> adapterQua;
        adapterQua = new ArrayAdapter<String>(
            this,
                android.R.layout.simple_expandable_list_item_1,
                dsQua
        );
        //B4:
        ListView lvQua = findViewById(R.id.lvQuaTang);
        lvQua.setAdapter(adapterQua);
        //B5: Xử lý sự kiện

    }
}