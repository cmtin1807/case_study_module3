package com.example.casestudydanang.service.borrow_transaction_dto;

import com.example.casestudydanang.model.BorrowDTO.BorrowTransactionDTO;
import com.example.casestudydanang.repository.borrow_transaction_dto.BorrowTransactionRepository;

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
    public List<BorrowTransactionDTO> findByCodeCustomer(String codeCustomer) {
        return repository.findByCodeCustomer(codeCustomer);
    }

    @Override
    public void delete(int id) {
        repository.deleteBorrowTransaction(id);
    }

    @Override
    public void update(int id, BorrowTransactionDTO object) {
        repository.update(id, object);
    }
    public void updateBorrow(BorrowTransactionDTO object) {
        repository.update(object);
    }

    @Override
    public void save(BorrowTransactionDTO object) {
        repository.save(object);
    }
}
