package com.example.casestudydanang.service.borrow;

import com.example.casestudydanang.model.Borrow;
import com.example.casestudydanang.repository.borrow.BorrowReposiotry;

import java.util.Collections;
import java.util.List;

public class BorrowService implements IBorrowSevice {
    BorrowReposiotry borrowRepo = new BorrowReposiotry();

    @Override
    public List<Borrow> findAll() {
        return borrowRepo.findAll();
    }

    @Override
    public Borrow findById(int id) {
        return borrowRepo.findById(id);
    }

    @Override
    public void save(Borrow object) {
        borrowRepo.save(object);
    }

    @Override
    public void update(int id, Borrow object) {
        borrowRepo.update(id, object);
    }

    @Override
    public void delete(int id) {

    }
}
