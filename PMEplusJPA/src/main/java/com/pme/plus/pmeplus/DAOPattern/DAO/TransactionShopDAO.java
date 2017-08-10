package com.pme.plus.pmeplus.DAOPattern.DAO;

import com.pme.plus.pmeplus.Entity.TransactionShop;

import java.sql.Date;
import java.util.List;

/**
 * Created by gnkali on 6/21/17.
 */
public interface TransactionShopDAO {

    /**
     * This is the method to be used to create
     * a record in the TransactionShop table.
     */
    public void createTransactionShop(TransactionShop transactionShop);

    /**
     * This is the method to be used to list down
     * a record from the TransactionShop table corresponding
     * to a passed TransactionShop (idProduct, idShop, idMember, transactionTimestamp).
     */
    public TransactionShop getTransactionShopByIDs(int idProduct, int idShop, int idMember, Date transactionTimestamp);

    /**
     * This is the method to be used to list down
     * all the records from the TransactionShop table.
     */
    public List<TransactionShop> listTransactionShops();

    /**
     * This is the method to be used to delete
     * a record from the TransactionShop table corresponding
     * to a passed TransactionShop (idProduct, idShop, idMember, transactionTimestamp).
     */
    public void deleteTransactionShopByIDs(int idProduct, int idShop, int idMember, Date transactionTimestamp);

    /**
     * This is the method to be used to update the quantity of
     * a record into the TransactionShop table.
     */
    public void updateTransactionShopQuantity(int idProduct, int idShop, int idMember, Date transactionTimestamp, int quantity);
}
