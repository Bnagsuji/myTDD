package chap02;


/**
 *  요건 충족시 암호 강도 STRONG return
 *
 */
public class PasswordStrengthMeter {

    public PasswordStrength meter(String s){

        //1. 처음 테스트는 기댓값을 STRONG으로 하지만 null이 나오게 해 테스트를 실패하게 함
        // return null;

//      2. 두번째 테스트를 STRONG으로 리턴하게 한다
//        return PasswordStrength.STRONG;

//      3. return PasswordStrength.NORMAL >>> 세번째 테스트를 NORMAL으로 리턴하게 한다 ->
//      전체 테스트시 세번째 테스트는 통과지만 두번째 테스트의 예상값은 STRONG이어야하므로 실패가 된다.
//      이제 조건을 만들어주기!!!(첫번째 테스트와 두번째 테스트 모두 충족하기 위함)

//      값이 null이거나 빈 경우 INVALID
        if(s==null|| s.isEmpty()) return PasswordStrength.INVALID;

//        4. 숫자조건 이외에 모든 요건 충족시 NORMAL 리턴해야하므로 조건 만들기
        boolean containsNum = meetNumberCondition(s);
        boolean enoughLength = false;
        //길이조건 충족 if문
        if(s.length()>=8){
            enoughLength=true;
        }
        //대문자 조건 충족치 않을시 NORMAL
        boolean containsUpperCase = meetUpperCaseCondition(s);

//      길이조건만 충족시
        if(enoughLength && !containsNum && !containsUpperCase) return PasswordStrength.WEAK;

//      숫자조건만 충족시
        if(!enoughLength && containsNum && !containsUpperCase) return PasswordStrength.WEAK;

//      대문자조건만 충족시
        if(!enoughLength && !containsNum && containsUpperCase) return PasswordStrength.WEAK;



        //길이 조건만 미충족시 NORMAL
//        if(s.length()<8) return PasswordStrength.NORMAL;
        if(!enoughLength) return PasswordStrength.NORMAL;

        //숫자  조건만 미충족시 NORMAL
        if(!containsNum) return PasswordStrength.NORMAL;

        //대문자 조건만 미충족시 NORMAL
        if(!containsUpperCase) return PasswordStrength.NORMAL;



        return PasswordStrength.STRONG;
    }



    /**
     * 숫자 조건 일치 메서드
     * */
    public boolean meetNumberCondition(String s){

//      문자열을 한단어씩 0~9 사이의 문자 검사
        for(char c : s.toCharArray()){
            if(c >='0' && c <='9'){
                return true;
            }
        }
        return false;
    }


    /**
     * 대문자 조건 일치 메서드
     * */
    public boolean meetUpperCaseCondition(String s){
        for(char c: s.toCharArray()){
            if(c >=65 && c<=90){
                return true;
            }
        }

        return false;
    }


}
