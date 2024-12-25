package chap02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PwStrengthMeterTest {

/* 요구사항
*
*  길이가 8글자 이상
 * 0~9사이의 숫자를 포함
* 대문자 포함
* -----3가지 규칙 충족시 암호는 강함
* -----2가지 규칙 충족시 암호는 보통
* -----1가지 이하 규칙 충족시 암호는 약함
*
* */

    //공통으로 빼주기(반복코드를 없애기 위함)
    private final PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String pw, PasswordStrength expStr) {
        PasswordStrength result = meter.meter(pw);
        assertEquals(expStr,result);
    }



    @Test
    @DisplayName("모든 요건 충족시 암호 강도는 강함")
    void meetsAllCriteria_Then_Strong() {
        //가장 만들기 쉬운 테스트를 작성

        //요건 충족시 암호 강도 리턴
//        PasswordStrength result = meter.meter("ab12!@AB");
//        assertEquals(PasswordStrength.STRONG,result);

        assertStrength("ab12!@AB",PasswordStrength.STRONG);


//      Test2
//      현재는 무조건 STRONG을 리턴하므로 이 테스트는 success
//        PasswordStrength result2 = meter.meter("abc1!Add");
////      암호 강도 > IF("STRONG") success ELSE fail
//        assertEquals(PasswordStrength.STRONG,result2);

        assertStrength("abc1!Add",PasswordStrength.STRONG);
    }


    @Test
    @DisplayName("요구사항이 길이조건 이외에 충족하는 경우 NORMAL 리턴")
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
//        PasswordStrength result1 = meter.meter("ab12DD");
//        assertEquals(PasswordStrength.NORMAL,result1);

        assertStrength("ab12D",PasswordStrength.NORMAL);
    }


    @Test
    @DisplayName("요구사항이 숫자조건 이외에 충족하는 경우 NORMAL 리턴")
    void meetsOtherCriteria_except_for_number_Then_Normal() {
//        PasswordStrength result1 = meter.meter("abDD!ASDF");
//        assertEquals(PasswordStrength.NORMAL,result1);

        assertStrength("abDD!ASDF",PasswordStrength.NORMAL);
    }


    @Test
    @DisplayName("값이 없는경우 INVAILD 리턴")
    void nonValue_Then_Invalid() {
        assertStrength("",PasswordStrength.INVALID);
    }


    @Test
    @DisplayName("대문자 조건을 충족하지 않는 경우 NORMAL 리턴")
    void nonUpperCaseCondition_Then_Normal() {
        assertStrength("asdf14dfas",PasswordStrength.NORMAL);
    }

//  여기까지는 두가지 조건을 충족한 경우의 테스트를 작성함
//    아래서부터는 한 가지 조건만 충족한 경우의 테스트를 작성하기

    @Test
    @DisplayName("길이 조건만 충족한 경우 WEAK 리턴")
    void onlyMeetStringLength_Then_Weak() {
        assertStrength("aaaaaaaaa",PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("숫자 조건만 충족한 경우 WEAK 리턴")
    void onlyMeetNumCondition_Then_Weak() {
        assertStrength("121!",PasswordStrength.WEAK);
    }

    @Test
    @DisplayName("대문자 조건만 충족한 경우 WEAK 리턴")
    void onlyMeetUpperCaseCondition_Then_Weak() {
        assertStrength("DD",PasswordStrength.WEAK);
    }


    @Test
    @DisplayName("아무것도 충족하지 않은 경우 WEAK")
    void noMeetAllCondition() {
        assertStrength("asd",PasswordStrength.WEAK);
    }

}
