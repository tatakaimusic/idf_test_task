package com.example.idf_test_task.web.mapper;

import com.example.idf_test_task.model.Transaction;
import com.example.idf_test_task.web.dto.TransactionDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TransactionMapper
        extends Mappable<Transaction, TransactionDTO> {
}
