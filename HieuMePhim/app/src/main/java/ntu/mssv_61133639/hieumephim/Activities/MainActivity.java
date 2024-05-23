package ntu.mssv_61133639.hieumephim.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import ntu.mssv_61133639.hieumephim.Adapters.SliderAdapters;
import ntu.mssv_61133639.hieumephim.Domain.SliderItems;
import ntu.mssv_61133639.hieumephim.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Handler slideHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        banners();
    }

    private void banners() {
        List<SliderItems> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItems(R.drawable.pic1));
        sliderItems.add(new SliderItems(R.drawable.pic2));
        sliderItems.add(new SliderItems(R.drawable.pic3));

        viewPager2.setAdapter(new SliderAdapters(sliderItems, viewPager2));
        viewPager2.setClipToPadding(false); //Hiển thị nội dung mà không cắt bớt lề của hình ảnh
        viewPager2.setClipChildren(false); //Không cắt mất các slide con
        viewPager2.setOffscreenPageLimit(3); //Số lượng trang slide: 3 trang

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40)); //Thêm hiệu ứng chuyển slide

        //Xử lý hiệu ứng chuyển slide: comppositePageTransformer(Kết hợp nhiều pageTransformer(Tùy chỉnh hiển thị giữa các slide))
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) { //Gọi PT này khi slide đang được hiển thị
                float r = 1 -  Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f); //Thay đổi tỉ lệ chiều dọc của slideImage (Hiệu ứng thu nhỏ slide)
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.setCurrentItem(1);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderRunable);
            }
        });
    }

    private Runnable sliderRunable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        slideHandler.removeCallbacks(sliderRunable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        slideHandler.postDelayed(sliderRunable, 2000);
    }

    private void initView() {
        viewPager2 = findViewById(R.id.viewPagerSlider);
    }
}