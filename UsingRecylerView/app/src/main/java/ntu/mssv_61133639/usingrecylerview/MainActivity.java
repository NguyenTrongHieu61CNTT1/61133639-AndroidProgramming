package ntu.mssv_61133639.usingrecylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerViewLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Chuẩn bị dữ liệu cho landscapeList
        recyclerViewDatas = getDataForRecyclerView();
        //Tìm điều khiển Recycler
        recyclerViewLandscape = findViewById(R.id.recyclerLand);
        //Tạo Layout manager để đặt bố cục cho Recycler
//        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
//        recyclerViewLandscape.setLayoutManager(layoutLinear);

        //Test theo chiều ngang:
        RecyclerView.LayoutManager layoutLinearHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewLandscape.setLayoutManager(layoutLinearHorizontal);

        //Tạo Adapter gắn với nguồn dữ liệu
        landScapeAdapter = new LandScapeAdapter(this, recyclerViewDatas);
        //Gắn Adapter với Recycler
        recyclerViewLandscape.setAdapter(landScapeAdapter);
    }

    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("thaptram", "Tháp Trầm Hương - Biểu tượng Thành phố Nha Trang");
        dsDuLieu.add(landScape1);
        dsDuLieu.add(new LandScape("thapba", "Tháp Bà Ponagar - Văn hóa du lịch Nha Trang"));
        dsDuLieu.add(new LandScape("chualongson", "Chùa Long Sơn - Phật nhìn cả thành phố biển"));
        return dsDuLieu;
    }
}