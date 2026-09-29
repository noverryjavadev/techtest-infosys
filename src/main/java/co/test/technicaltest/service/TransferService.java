package co.test.technicaltest.service;

import co.test.technicaltest.entity.Account;
import co.test.technicaltest.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transfer(Long sourceAccountId, Long destinationAccountId, double amount) {
        Account source = accountRepository.findById(sourceAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Rekening asal tidak ditemukan"));
        Account destination = accountRepository.findById(destinationAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Rekening tujuan tidak ditemukan"));

        source.debit(amount);
        destination.credit(amount);

        accountRepository.save(source);
        accountRepository.save(destination);
    }
}
