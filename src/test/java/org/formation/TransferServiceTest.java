package org.formation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.formation.repository.CurrentAccountRepository;
import org.formation.repository.SavingAccountRepository;
import org.formation.service.TransferServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransferServiceTest {

    @Mock
    private CurrentAccountRepository currentAccountRepository;

    @Mock
    private SavingAccountRepository savingAccountRepository;

    @InjectMocks
    private TransferServiceImpl transferService;

    @Test
    public void testTransferNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            transferService.transfer(-100, 1L, 2L);
        });
    }
}
