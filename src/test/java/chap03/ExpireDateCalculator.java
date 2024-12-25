package chap03;


import java.time.LocalDate;

/**
 * 만료일 계산
 * */
public class ExpireDateCalculator {


    public LocalDate calculateExpireDate(LocalDate date, int billingMoney) {

//        지불한 돈과 지불한 데이트로 만료일 계산
//        돈 안낼 수도 있음

        boolean useService = false;
        int useMonth=0;
        if(billingMoney>=10000) useService =true;

        if(useService){
            for(int i=10000; i<= billingMoney;) {
                useMonth++;
                i+=10000;
            }

        }else {
            return date;
        }



//        LocalDate expireDate = date.plusMonths(useMonth);


        return  date.plusMonths(useMonth);
    }
}
