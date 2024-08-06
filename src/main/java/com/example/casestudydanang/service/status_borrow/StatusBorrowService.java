package com.example.casestudydanang.service.status_borrow;

import com.example.casestudydanang.model.StatusBorrow;
import com.example.casestudydanang.repository.status_borrow.StatusBorrowRepository;

import java.util.Collections;
import java.util.List;

public class StatusBorrowService implements IStatusBorrowService {
    StatusBorrowRepository statusBorrowRepository = new StatusBorrowRepository();
    @Override
    public List<StatusBorrow> findAll() {
        return statusBorrowRepository.findAll();
    }

    @Override
    public StatusBorrow findById(int id) {
        return null;
    }

    @Override
    public void save(StatusBorrow object) {

    }

    @Override
    public void update(int id, StatusBorrow object) {

    }

    @Override
    public void delete(int id) {

    }
}
