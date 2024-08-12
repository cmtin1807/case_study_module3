package com.example.casestudydanang.service.borrow;

import com.example.casestudydanang.model.Borrow;
import com.example.casestudydanang.repository.borrow.BorrowReposiotry;

import java.sql.Date;
import java.time.LocalDate;
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


    public void updateOverdueBorrows() {
        List<Borrow> borrows = borrowRepo.findAll();
        for (Borrow borrow : borrows) {
            if (borrow.getReturnDate() != null && borrow.getReturnDate().before(Date.valueOf(LocalDate.now())) && borrow.getStatusBorrowId() == 1) {
                borrow.setStatusBorrowId(2); // Cập nhật trạng thái thành "Quá hạn"
                borrowRepo.update(borrow.getId(), borrow);
            }
        }
    }


}
