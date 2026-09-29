package co.test.technicaltest.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id) {
        super("Employee dengan ID " + id + " tidak ditemukan");
    }
}
