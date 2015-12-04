package gpgolf.teeoff.com.kr;

import android.provider.BaseColumns;

/**
 * Created by T on 2015-12-03.
 */
public class ScoreCardConstant {

    public static final class MemberInfo implements  BaseColumns {  // 1번째 테이블DB
        public static final String MEMBER_TBL = "member_tbl";  // 맴버 테이블
        public static final String MEMBER_IMAGE = "member_image_col";  // 맴버 프로필사진
        public static final String MEMBER_NAME = "member_name_col";  // 맴버 이름
        public static final String MEMBER_GENDER = "member_gender_col";  // 맴버 성별
        public static final String MEMBER_HOMECOURSE = "member_homecourse_col";  // 맴버의 홈코스
        public static final String MEMBER_AGE = "member_age_col";  // 맴버 나이
    }

    public static final class GolfClubInfo implements BaseColumns { // 2번째 테이블,DB
        public static final String GOLFCLUB_TBL = "golfclub_tbl";   // 골프장 테이블
        public static final String GOLFCLUB_NAME = "golfclub_name_col";   // 골프장 이름
        public static final String GOLFCLUB_ADDRESS = "golfclub_address_col";  // 골프장 주소
        public static final String GOLFCLUB_HOLE = "golfclub_hole_col";  // 골프장 홀
        public static final String GOLFCLUB_TYPE = "golfclub_type_col";  // 골프장 타입(회원제, 퍼블릭)
        public static final String GOLFCLUB_COURCENAME = "golfclub_coursename_col";  // 골프장 코스 이름
        public static final String GOLFCLUB_PAR = "golfclub_par_col";  // 골프장 파수
        public static final String GOLFCLUB_LATITUDE = "golfclub_latitude_col";  // 골프장 위도
        public static final String GOLFCLUB_LONGITUDE = "golfclub_longitude_col";  // 골프장 경도
    }

    public static final class RoundingInfo implements BaseColumns { // 3번째 테이블DB 라운딩할 골프장 정보들
        public static final String ROUNDING_INFO_TBL = "rounding_info_tbl";  // 라운딩테이블
        public static final String ROUNDING_INFO_GOLFCLUB_ID = "rounding_info_golfclub_id_col";  // 골프장DB 아이디값
        public static final String ROUNDING_INFO_HOLE = "rounding_info_hole_col";  // 라운딩할 골프장 홀수 (9 or 18)
        public static final String ROUNDING_INFO_FIRST9 = "rounding_info_first9_col";  // 전반9홀 코스 이름 (전반)
        public static final String ROUNDING_INFO_SECOND9 = "rounding_info_second9_col";  // 후반9홀 코스 이름 (후반)
        public static final String ROUNDING_INFO_TEETIME = "rounding_info_teetime_col";  // 티타임 (YYYY/mm/DD)
    }

    public static final class ScoreCard implements BaseColumns {  // 4번째 테이블 DB 스코어카드에서 저장할때 받는값들
        public static final String SCORECARD_TBL = "scorecard_tbl";  // 스코어카드 테이블
        public static final String SCORECARD_ID = "scorecard_id_col"; // 스코어카드 아이디
        public static final String SCORECARD_WEATHER = "scorecard_weather_col";  // 현재 골프장 날씨
        public static final String SOCRECARD_HOLESCORE = "scorecard_holescore_col";  // json으로 par, score, put의 값을 넘겨준다
        public static final String SCORECARD_DATE = "scorecard_date_col";  // 스코어카드를 구분해주는 경기시간  (YYYY|MM|DD)
        public static final String SCORECARD_PICSCORE = "scorecard_picscore";  // 스코어카드를 사진으로 찍어서 저장
        public static final String SCORECARD_MEMO = "scorecard_memo";  // 경기완료후 간단한 분석메모
        public static final String SCORECARD_CONDITION = "scorecard_condition";  // 그날의 컨디션을 표시  (매우좋음, 좋음, 보통, 나쁨, 매우나쁨)
        public static final String SCORECARD_ROUTIN = "scorecard_routin";  // 그날의 루틴표시
        public static final String SCORECARD_GREENHITRATE = "scorecard_greenhittrate";  // 그날의 그린적중률을 표시
        public static final String SCORECARD_APPROACH = "scorecard_approach";  // 그날의 어프로치감각을 표시
        public static final String SCORECARD_FAIRWAYHITRATE = "scorecard_fairwayhittrate";  // 그날의 페어웨이 적중률을 표시
        public static final String SCORECARD_TROBLESHOTSAVE = "scorecard_trobleshotsave";  // 그날의 트러블샷 세이브율을 표시시
    }
}