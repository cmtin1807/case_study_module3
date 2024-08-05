package com.example.casestudydanang.service.Borrow;

import com.example.casestudydanang.model.BorrowDTO.BorrowTransactionDTO;
import com.example.casestudydanang.repository.borrowing.BorrowTransactionRepository;

import java.util.List;

public class BorrowTransactionService implements IBorrowTransactionService {
    private BorrowTransactionRepository repository = new BorrowTransactionRepository();

    @Override
    public List<BorrowTransactionDTO> findAll() {
        return repository.findAll();
    }
    public List<BorrowTransactionDTO> findBasicBorrow() {
        return repository.findBasicBorrow();
    }

    @Override
    public BorrowTransactionDTO findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public void update(int id, BorrowTransactionDTO object) {
        repository.update(id, object);
    }

    @Override
    public void save(BorrowTransactionDTO object) {
        repository.save(object);
    }
}
