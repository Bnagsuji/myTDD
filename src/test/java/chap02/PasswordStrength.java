package chap02;


/* enum은 열거 타입으로 고유값 필요시 사용 */

/**
 * 암호 강도 타입
 */
public enum PasswordStrength {
    //1. 처음 테스트시는 STRONG만 기입 .-> 테스트만 통과시킬 정도만 작성하는 것임
    STRONG,
    NORMAL,
    INVALID,
    WEAK
}
