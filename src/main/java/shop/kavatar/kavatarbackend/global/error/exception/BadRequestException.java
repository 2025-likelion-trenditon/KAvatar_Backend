package shop.kavatar.kavatarbackend.global.error.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }
}
