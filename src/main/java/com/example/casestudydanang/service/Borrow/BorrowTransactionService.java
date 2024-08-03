package com.example.casestudydanang.service.Borrow;

import com.example.casestudydanang.model.BorrowTransaction;
import com.example.casestudydanang.repository.borrowing.BorrowTransactionRepository;

import java.util.List;

public class BorrowTransactionService {
    private BorrowTransactionRepository borrowRepository = new BorrowTransactionRepository();


    public void save(BorrowTransaction transaction) {
        borrowRepository.save(transaction);
    }

    public List<BorrowTransaction> findAll() {
        return BorrowTransactionRepository.findAll();
    }

    public BorrowTransaction findById(int id) {
        return BorrowTransactionRepository.findById(id);
    }

    public void update(BorrowTransaction transaction) {
    }
}
