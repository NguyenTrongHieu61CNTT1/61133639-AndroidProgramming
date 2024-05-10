package ntu.mssv_61133639.qlbook_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bước 0: Tạo cơ sở dữ liệu:
        SQLiteDatabase db = openOrCreateDatabase("QLBook.db", MODE_PRIVATE, null); //Tên file db/ giới hạn truy cập/con trỏ bản ghi
        //Bước 1: Tạo bảng ghi
        String sqlXoaBangNeuDaCo = "DROP TABLE IF EXISTS Books;"; //Tạo bảng nha!
        String sqlTaoBang = "CREATE TABLE Books(BookID integer PRIMARY KEY," + "BookName text," + "Page interger," + "Price Float," + "Description text);";
        //Thực hiện các lệnh SQL:
        db.execSQL(sqlXoaBangNeuDaCo);
        db.execSQL(sqlTaoBang);

        // Thêm một số dòng dữ liệu vào bảng
        String sqlThem1 = "INSERT INTO Books VALUES(1, 'Java', 100, 9.99, 'sách về java');";
        String sqlThem2 = "INSERT INTO Books VALUES(2, 'Android', 320, 19.00, 'Android cơ bản');";
        String sqlThem3 = "INSERT INTO Books VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');";
        String sqlThem4 = "INSERT INTO Books VALUES(4, 'Tử điển Anh-Việt', 1000, 29.50, 'Từ điển 100.000 từ');";
        String sqlThem5 = "INSERT INTO Books VALUES(5, 'CNXH', 1, 1, 'chuyện cổ tích');";
        db.execSQL(sqlThem1);
        db.execSQL(sqlThem2);
        db.execSQL(sqlThem3);
        db.execSQL(sqlThem4);
        db.execSQL(sqlThem5);

        //Close to check:
        db.close();
    }
}