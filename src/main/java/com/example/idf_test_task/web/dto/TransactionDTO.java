package com.example.idf_test_task.web.dto;

import com.example.idf_test_task.model.ExpenseCategory;
import com.example.idf_test_task.web.validation.OnCreate;
import com.example.idf_test_task.web.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {

    @NotNull(
            message = "Id must be not null!",
            groups = OnUpdate.class
    )
    private Long id;

    @NotNull(
            message = "Account from must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @Min(
            value = 10,
            message = "Account from must be 10 symbols"
    )
    @Max(
            value = 10,
            message = "Account from must be 10 symbols"
    )
    private Integer accountFrom;

    @NotNull(
            message = "Account to must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @Min(
            value = 10,
            message = "Account to must be 10 symbols"
    )
    @Max(
            value = 10,
            message = "Account to must be 10 symbols"
    )
    private Integer accountTo;

    @NotNull(
            message = "Currency short name must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private String currencyShortname;

    @NotNull(
            message = "Sum must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private BigDecimal sum;

    @NotNull(
            message = "Expense category must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    private ExpenseCategory expenseCategory;

    @NotNull(
            message = "Date time must be not null!",
            groups = {OnCreate.class, OnUpdate.class}
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private LocalDateTime datetime;

    public TransactionDTO() {
    }

    public TransactionDTO(Long id, Integer accountFrom, Integer accountTo, String currencyShortname, BigDecimal sum, ExpenseCategory expenseCategory, LocalDateTime dateTime) {
        this.id = id;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.currencyShortname = currencyShortname;
        this.sum = sum;
        this.expenseCategory = expenseCategory;
        this.datetime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Integer accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Integer getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Integer accountTo) {
        this.accountTo = accountTo;
    }

    public String getCurrencyShortname() {
        return currencyShortname;
    }

    public void setCurrencyShortname(String currencyShortname) {
        this.currencyShortname = currencyShortname;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public LocalDateTime getDateTime() {
        return datetime;
    }

    public void setDateTime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

}
