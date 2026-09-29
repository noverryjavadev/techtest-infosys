package co.test.technicaltest.controller;

import co.test.technicaltest.dto.TransferRequest;
import co.test.technicaltest.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<Map<String, String>> transfer(@RequestBody TransferRequest request) {
        transferService.transfer(request.sourceAccountId(), request.destinationAccountId(), request.amount());
        return ResponseEntity.ok(Map.of("message", "Transfer berhasil"));
    }
}
