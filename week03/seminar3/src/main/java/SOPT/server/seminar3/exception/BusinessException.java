package SOPT.server.seminar3.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message); //같은에러에 다른 에러코드 띄우고싶으면?
    }
}
