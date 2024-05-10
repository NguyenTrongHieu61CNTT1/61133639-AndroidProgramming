package ntu.mssv_61133639.qlbook_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //Bước 0: Tạo cơ sở dữ liệu:
//        SQLiteDatabase db = openOrCreateDatabase("QLBook.db", MODE_PRIVATE, null); //Tên file db/ giới hạn truy cập/con trỏ bản ghi
//        //Bước 1: Tạo bảng ghi
//        String sqlXoaBangNeuDaCo = "DROP TABLE IF EXISTS Books;"; //Tạo bảng nha!
//        String sqlTaoBang = "CREATE TABLE Books(BookID integer PRIMARY KEY," + "BookName text," + "Page interger," + "Price Float," + "Description text);";
//        //Thực hiện các lệnh SQL:
//        db.execSQL(sqlXoaBangNeuDaCo);
//        db.execSQL(sqlTaoBang);
//
//        // Thêm một số dòng dữ liệu vào bảng
//        String sqlThem1 = "INSERT INTO Books VALUES(1, 'Java', 100, 9.99, 'sách về java');";
//        String sqlThem2 = "INSERT INTO Books VALUES(2, 'Android', 320, 19.00, 'Android cơ bản');";
//        String sqlThem3 = "INSERT INTO Books VALUES(3, 'Học làm giàu', 120, 0.99, 'sách đọc cho vui');";
//        String sqlThem4 = "INSERT INTO Books VALUES(4, 'Tử điển Anh-Việt', 1000, 29.50, 'Từ điển 100.000 từ');";
//        String sqlThem5 = "INSERT INTO Books VALUES(5, 'CNXH', 1, 1, 'chuyện cổ tích');";
//        db.execSQL(sqlThem1);
//        db.execSQL(sqlThem2);
//        db.execSQL(sqlThem3);
//        db.execSQL(sqlThem4);
//        db.execSQL(sqlThem5);
//
//        //Close to check:
//        db.close();

        //---------------------TRUY VẤN------------------------------//
        //B1. Mở CSDL
        SQLiteDatabase db = openOrCreateDatabase("QLBook.db", MODE_PRIVATE, null); //Tên file db/ giới hạn truy cập/con trỏ bản ghi
        //B2. Thực hiện câu lệnh select
        String sqlSelect ="Select * from Books;";
        Cursor cs = db.rawQuery(sqlSelect,null);
        cs.moveToFirst(); // set con trỏ về hàng đầu tiên của bảng ghi
        //B3: Thực hiện xử lý biến
        //3.1. Xây dựng model/class cho bảng Books
        //3.2. Tạo biến ArrayList<Book> dsSach;
        ArrayList<Book> dsSach = new ArrayList<Book>();
        //3.3. Duyệt qua từng bản ghi và thêm vào danhSach
        while (cs.moveToNext())
        {
            // Lấy dữ liệu từng cột ở dòng hiện tại
            int idSach = cs.getInt(0);  // lấy dữ liệu ở côt 0, kiểu int
            String tenSach = cs.getString(1);
            int soTrang = cs.getInt(2);
            float gia = cs.getFloat(3);
            String mota = cs.getString(4);
            // Tạo một đối tượng sách và thêm vào danh sách
            Book b = new Book(idSach,tenSach,soTrang,gia,mota);
            dsSach.add(b);
        }
        //B4, Hiện lên listview, recylerview,..
        ArrayList<String> dsTenSach = new ArrayList<String>();
        for (int i=0; i<dsSach.size(); i++ )
            dsTenSach.add(dsSach.get(i).getBookName());
    }
}