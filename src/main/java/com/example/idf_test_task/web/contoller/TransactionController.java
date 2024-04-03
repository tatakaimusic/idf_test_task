package com.example.idf_test_task.web.contoller;

import com.example.idf_test_task.model.Transaction;
import com.example.idf_test_task.service.TransactionService;
import com.example.idf_test_task.web.dto.TransactionDTO;
import com.example.idf_test_task.web.mapper.TransactionMapper;
import com.example.idf_test_task.web.validation.OnCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/transaction")
@Validated
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionController(TransactionService transactionService, TransactionMapper transactionMapper) {
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
    }

    @PostMapping("/save")
    public Flux<TransactionDTO> saveTransaction(
            @Validated(OnCreate.class)
            @RequestBody TransactionDTO dto
    ) {
        Transaction transaction = transactionMapper.toEntity(dto);
        return Flux.just(
                transactionMapper.toDto(
                        transactionService.save(transaction)
                )
        );
    }


}
