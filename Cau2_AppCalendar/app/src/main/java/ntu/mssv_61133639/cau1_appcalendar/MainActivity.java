package ntu.mssv_61133639.cau1_appcalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Khai báo
    CalendarView calendarView;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lấy id lịch
        calendarView = findViewById(R.id.cal);
        calendar = Calendar.getInstance();

        //Tạo Listener khi thay đổi ngày sẽ hiện thông báo ngày bạn đang chọn
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                Toast.makeText(MainActivity.this, "Bạn đang chọn ngày: " + day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
            }
        });
    }
}