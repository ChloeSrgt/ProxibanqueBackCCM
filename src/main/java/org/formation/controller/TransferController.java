package org.formation.controller;

import java.util.HashMap;
import java.util.Map;

import org.formation.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
@CrossOrigin(origins = "http://localhost:4200")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> transfer(@RequestParam double amount, @RequestParam long fromAccountId,
                                                        @RequestParam long toAccountId) {
        Map<String, String> response = new HashMap<>();
        try {
            boolean success = transferService.transfer(amount, fromAccountId, toAccountId);
            if (success) {
                response.put("message", "Transfer successful");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Transfer failed: insufficient funds");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (IllegalArgumentException e) {
            response.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
