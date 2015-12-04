package gpgolf.teeoff.com.kr;

/**
 * Created by T on 2015-12-03.
 */
public class DBInputScoreCard {

    public String id;
    //골프장테이블의 ID값
    public String golfclub_id_col;  // 골프장 아이디

    public String golfclub_name_col;  // 골프장 이름
    public String golfclub_coursename_col;  // 골프장 코스이름
    public String golfclub_par_col;  // 골프장 파

    public String rounding_info_first9_col;  // 전반9홀 코스이름
    public String rounding_info_second9_col;  // 후반9홀 코스이름
    public String rounding_info_teetime_col;  // 티타임 (hh,mm)

    public String scorecard_weather_col;  // 골프장 날씨
    public String scorecard_holescore_col;  // 스코어,par,put json으로 넘겨오기
    public String scorecard_date_col; // 스코어카드 구분해주는 시간 (YYYY,mm,DD).

    public String scorecard_condition; // 컨디션 표시
    public String scorecard_routin; // 루틴 표시
    public String scorecard_greenhittrate; // 그린 적중률 표시
    public String scorecard_approach; // 어프로치 표시
    public String scorecard_fairwayhittrate; // 페어웨이 적중률 표시
    public String scorecard_trobleshotsave; // 트러블샷 세이브율 표시

    public DBInputScoreCard() {
    }

    public DBInputScoreCard(String id, String golfclub_id_col, String golfclub_name_col, String golfclub_coursename_col, String golfclub_par_col,
                            String rounding_info_first9_col, String rounding_info_second9_col, String rounding_info_teetime_col,
                            String scorecard_weather_col,String scorecard_holescore_col, String scorecard_date_col, String scorecard_condition,
                            String scorecard_routin, String scorecard_greenhittrate, String scorecard_approach, String scorecard_fairwayhittrate,
                            String scorecard_trobleshotsave) {
        this.id = id;
        this.golfclub_id_col = golfclub_id_col;
        this.golfclub_name_col = golfclub_name_col;
        this.golfclub_coursename_col = golfclub_coursename_col;
        this.golfclub_par_col = golfclub_par_col;
        this.rounding_info_first9_col = rounding_info_first9_col;
        this.rounding_info_second9_col = rounding_info_second9_col;
        this.rounding_info_teetime_col = rounding_info_teetime_col;
        this.scorecard_weather_col = scorecard_weather_col;
        this.scorecard_holescore_col = scorecard_holescore_col;
        this.scorecard_date_col = scorecard_date_col;
        this.scorecard_condition = scorecard_condition;
        this.scorecard_routin = scorecard_routin;
        this.scorecard_greenhittrate = scorecard_greenhittrate;
        this.scorecard_approach = scorecard_approach;
        this.scorecard_fairwayhittrate = scorecard_fairwayhittrate;
        this.scorecard_trobleshotsave = scorecard_trobleshotsave;
    }
}
