package co.test.technicaltest.dto;

public record TransferRequest(Long sourceAccountId, Long destinationAccountId, double amount) {
}
