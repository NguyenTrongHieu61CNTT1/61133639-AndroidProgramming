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

        //Set ngày mặc định khi khởi chạy ứng dụng
        setDay(1,1,2024);

        //Tạo Listener khi thay đổi ngày sẽ hiện thông báo ngày bạn đang chọn
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                Toast.makeText(MainActivity.this, "Bạn đang chọn ngày: " + day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Hàm set ngày tháng năm mặc định
    public void setDay(int day, int month, int year){
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        long milli = calendar.getTimeInMillis();
        calendarView.setDate(milli);
    }
}