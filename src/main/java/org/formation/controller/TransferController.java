package org.formation.controller;

import org.formation.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

	private final TransferService transferService;

	public TransferController(TransferService transferService) {
		this.transferService = transferService;
	}

	@PostMapping
	public ResponseEntity<String> transfer(@RequestParam double amount, @RequestParam long fromAccountId,
			@RequestParam long toAccountId) {
		try {
			boolean success = transferService.transfer(amount, fromAccountId, toAccountId);
			if (success) {
				return ResponseEntity.ok("Transfer successful");
			} else {
				return ResponseEntity.badRequest().body("Transfer failed: insufficient funds");
			}
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
