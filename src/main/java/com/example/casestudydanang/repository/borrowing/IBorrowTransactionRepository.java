package com.example.casestudydanang.repository.borrowing;

import com.example.casestudydanang.model.BorrowTransaction;
import com.example.casestudydanang.repository.IGenerateRepository;

import java.util.List;

public interface IBorrowTransactionRepository extends IGenerateRepository<BorrowTransaction> {
    @Override
    List<BorrowTransaction> findAll();

    @Override
    BorrowTransaction findById(int id);

    @Override
    void save(BorrowTransaction object);

    @Override
    void update(int id, BorrowTransaction object);

    @Override
    void delete(int id);
}
