package gpgolf.teeoff.com.kr;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by T on 2015-12-03.
 */
public class TeeOffDBHelper extends SQLiteOpenHelper {

    private static String dbName = "teeoff_schema.db";   // db이름 설정
    private static int versionCode = 1; // versionCode
    private static TeeOffDBHelper dbHelper; // 이름간략화

    private TeeOffDBHelper() {
        this(ScoreApplication.getContext(), dbName, null, versionCode);
    }


    public TeeOffDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public TeeOffDBHelper(Context context) {
        super(context, dbName, null, versionCode);
    }

    public static TeeOffDBHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new TeeOffDBHelper();
        }
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder member = new StringBuilder();
        StringBuilder golfclub = new StringBuilder();
        StringBuilder rounding = new StringBuilder();
        StringBuilder scorecard = new StringBuilder();

        member.append(" CREATE TEBLE ")
                .append(ScoreCardConstant.MemberInfo.MEMBER_TBL)
                .append(" ( ")
                .append(ScoreCardConstant.MemberInfo._ID + " INTEGER primary key autoincrement ,")
                .append(ScoreCardConstant.MemberInfo.MEMBER_IMAGE + " TEXT, ")
                .append(ScoreCardConstant.MemberInfo.MEMBER_NAME + " TEXT, ")
                .append(ScoreCardConstant.MemberInfo.MEMBER_GENDER + " TEXT, ")
                .append(ScoreCardConstant.MemberInfo.MEMBER_HOMECOURSE + " TEXT, ")
                .append(ScoreCardConstant.MemberInfo.MEMBER_AGE + " TEXT")
                .append(" );");

        golfclub.append(" CREATE TABLE ")
                .append(ScoreCardConstant.GolfClubInfo.GOLFCLUB_TBL)
                .append(" ( ")
                .append(ScoreCardConstant.GolfClubInfo._ID + " INTEGER primary key autoincrement ,")
                .append(ScoreCardConstant.GolfClubInfo.GOLFCLUB_NAME + " TEXT, ")
                .append(ScoreCardConstant.GolfClubInfo.GOLFCLUB_ADDRESS + " TEXT, ")
                .append(ScoreCardConstant.GolfClubInfo.GOLFCLUB_HOLE + " TEXT, ")
                .append(ScoreCardConstant.GolfClubInfo.GOLFCLUB_TYPE + " TEXT, ")
                .append(ScoreCardConstant.GolfClubInfo.GOLFCLUB_COURCENAME + " TEXT, ")
                .append(ScoreCardConstant.GolfClubInfo.GOLFCLUB_PAR + " TEXT, ")
                .append(ScoreCardConstant.GolfClubInfo.GOLFCLUB_LATITUDE + " DOUBLE, ")
                .append(ScoreCardConstant.GolfClubInfo.GOLFCLUB_LONGITUDE + " DOUBLE")
                .append(" );");

        rounding.append(" CREATE TABLE ")
                .append(ScoreCardConstant.RoundingInfo.ROUNDING_INFO_TBL)
                .append(" ( ")
                .append(ScoreCardConstant.RoundingInfo._ID + " INTEGER primary key autoincrement ,")
                .append(ScoreCardConstant.RoundingInfo.ROUNDING_INFO_GOLFCLUB_ID + " INTEGER, ")
                .append(ScoreCardConstant.RoundingInfo.ROUNDING_INFO_HOLE + " TEXT, ")
                .append(ScoreCardConstant.RoundingInfo.ROUNDING_INFO_FIRST9 + " TEXT,")
                .append(ScoreCardConstant.RoundingInfo.ROUNDING_INFO_SECOND9 + " TEXT, ")
                .append(ScoreCardConstant.RoundingInfo.ROUNDING_INFO_TEETIME + " TEXT")
                .append(" );");

        scorecard.append(" CREATE TABLE ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_TBL)
                .append(" ( ")
                .append(ScoreCardConstant.ScoreCard._ID + " INTEGER primary key autoincrement ,")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_ID + " INTEGER, ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_WEATHER + " TEXT, ")
                .append(ScoreCardConstant.ScoreCard.SOCRECARD_HOLESCORE + " TEXT, ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_DATE + " TEXT, ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_PICSCORE + " TEXT, ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_MEMO + " TEXT, ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_CONDITION + " TEXT, ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_ROUTIN + " TEXT, ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_GREENHITRATE + " TEXT, ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_APPROACH + " TEXT, ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_FAIRWAYHITRATE + " TEXT, ")
                .append(ScoreCardConstant.ScoreCard.SCORECARD_TROBLESHOTSAVE + " TEXT")
                .append(" );");

        db.execSQL(member.toString());
        db.execSQL(golfclub.toString());
        db.execSQL(rounding.toString());
        db.execSQL(scorecard.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor searchClub(String keyword){
        SQLiteDatabase db = null;
        Cursor c = null;
        try {
            db = getReadableDatabase();
//            list = new ArrayList<Address>();
            String[] column = new String[]{ ScoreCardConstant.GolfClubInfo.GOLFCLUB_NAME, ScoreCardConstant.GolfClubInfo.GOLFCLUB_ADDRESS,
                                            ScoreCardConstant.GolfClubInfo.GOLFCLUB_HOLE, ScoreCardConstant.GolfClubInfo.GOLFCLUB_TYPE};
            String selection = null;
            String[] selectionArgs = null;
            if (keyword != null && !keyword.trim().equals("")) {

                selection =
                        ScoreCardConstant.GolfClubInfo.GOLFCLUB_NAME + " LIKE ? OR " +
                                ScoreCardConstant.GolfClubInfo.GOLFCLUB_ADDRESS + " LIKE ?";
                selectionArgs = new String[]{
                        "%" + keyword + "%",
                        "%" + keyword + "%",
                        "%" + keyword + "%",
                        "%" + keyword + "%"};
            }
            String orderBy = ScoreCardConstant.GolfClubInfo.GOLFCLUB_NAME + " COLLATE LOCALIZED ASC ";  //시스템 정렬(특수, 영어, 한글순 )
            c = db.query(ScoreCardConstant.GolfClubInfo.GOLFCLUB_TBL, column, selection, selectionArgs, null, null, orderBy);

        }catch (Exception e){
            Toast.makeText(ScoreApplication.getContext(), "검색실패", Toast.LENGTH_SHORT);
        }finally{

        }
        return c;
    }



}
