package chap03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 서비스 만료일 계산 테스트
 * */
public class CalculateServiceExpireDayTest {


/*

    < 매달 배용을 지불해야 사용 가능한 유료 서비스 기능 >
    요구사항

    - 서비스를 사용하려면 매달 만원을 선불로 납부.
    납부일 기준으로 한 달 뒤가 서비스 만료일이 된다.

    - 2개월 이상 요금을 납부할 수 있다.

    - 10만원을 납부하면 서비스 1년 제공

    1. 만원을 납부하지 않았을 때/납부했을 때
    2.

*/


    @Test
    @DisplayName("납부일계산 테스트")
    void if_pay_the_10000won_then_expire_after_month_Test() {
        //'만원'값을 넣으면 만료일이 return 돼야 함
        //지불한 날

        assertExpireDate(LocalDate.of(2019,4,1),10000,LocalDate.of(2019,5,1));

        assertExpireDate(LocalDate.of(2020,1,31),10000,LocalDate.of(2020,2,29));

    }


    private void assertExpireDate(LocalDate date, int billingMoney, LocalDate expectedDate){
        ExpireDateCalculator cal = new ExpireDateCalculator();
        LocalDate expireDate = cal.calculateExpireDate(date,billingMoney);
        assertEquals(expectedDate,expireDate);
    }




}
