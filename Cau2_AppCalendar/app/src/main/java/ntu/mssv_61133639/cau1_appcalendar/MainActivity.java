package ntu.mssv_61133639.cau1_appcalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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
        //setDay(1,1,2024);

        //Hiển thị thông báo ngày hiện tại khi vừa vào ứng dụng
        getDate();

        //Tạo Listener khi thay đổi ngày sẽ hiện thông báo ngày bạn đang chọn
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                Toast.makeText(MainActivity.this, "Bạn đang chọn ngày: " + day + "/" + month + 1 + "/" + year, Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Hàm hiển thị thông báo ngày hiện tại
    public void getDate(){
        long date = calendarView.getDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
        calendar.setTimeInMillis(date);
        String selected_date = simpleDateFormat.format(calendar.getTime());
        Toast.makeText(this, selected_date, Toast.LENGTH_SHORT).show();
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