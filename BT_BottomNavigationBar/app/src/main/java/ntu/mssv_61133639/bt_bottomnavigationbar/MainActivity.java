package ntu.mssv_61133639.bt_bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.b_NavBar);
        frameLayout = findViewById(R.id.frameLayout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemID = item.getItemId();

                //Xử lý chuyn đổi màn hình khi bấm vào nút trên thanh navigation bar
                if (itemID == R.id.b_nav_home){
                    allFragment(new Home_Fragment(), false);
                } else if (itemID == R.id.b_nav_search) {
                    allFragment(new Search_Fragment(), false);
                } else if (itemID == R.id.b_nav_noti) {
                    allFragment(new Notification_Fragment(), false);
                } else {
                    allFragment(new Profile_Fragment(), false);
                }

                allFragment(new Home_Fragment(), true);
                return true;
            }
        });
    }

    //Hàm gọi fragment cho các chức năng trên thanh NavBar:
    private void allFragment(Fragment fragment, boolean isAppInitialized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized){
            fragmentTransaction.add(R.id.frameLayout, fragment);
        }else {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        }
        fragmentTransaction.commit();
    }

}