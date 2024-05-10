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
        //Close to check:
        db.close();
    }
}