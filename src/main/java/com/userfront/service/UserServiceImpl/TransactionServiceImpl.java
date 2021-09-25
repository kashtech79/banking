package com.userfront.service.UserServiceImpl;

import com.userfront.dao.PrimaryAccountDao;
import com.userfront.dao.PrimaryTransactionDao;
import com.userfront.dao.SavingsAccountDao;
import com.userfront.dao.SavingsTransactionDao;
import com.userfront.domain.PrimaryTransaction;
import com.userfront.domain.SavingsTransaction;
import com.userfront.domain.User;
import com.userfront.service.TransactionService;
import com.userfront.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

        @Autowired
        private UserService userService;

        @Autowired
        private PrimaryTransactionDao primaryTransactionDao;

        @Autowired
        private SavingsTransactionDao savingsTransactionDao;

        @Autowired
        private PrimaryAccountDao primaryAccountDao;

        @Autowired
        private SavingsAccountDao savingsAccountDao;


        public List<PrimaryTransaction> findPrimaryTransactionList(String username){
            User user = userService.findByUsername(username);
            List<PrimaryTransaction> primaryTransactionList = user.getPrimaryAccount().getPrimaryTransactionList();

            return primaryTransactionList;
        }

        public List<SavingsTransaction> findSavingsTransactionList(String username) {
            User user = userService.findByUsername(username);
            List<SavingsTransaction> savingsTransactionList = user.getSavingsAccount().getSavingsTransactionList();

            return savingsTransactionList;
        }

        public void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction) {
            primaryTransactionDao.save(primaryTransaction);
        }

        public void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction) {
            savingsTransactionDao.save(savingsTransaction);
        }

        public void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction) {
            primaryTransactionDao.save(primaryTransaction);
        }

        public void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction) {
            savingsTransactionDao.save(savingsTransaction);
        }

    }
