package com.pme.plus.pmeplus.DAOPattern.DAO;

import com.pme.plus.pmeplus.Entity.MemberShop;

import java.util.List;

/**
 * Created by gnkali on 6/21/17.
 */
public interface MemberShopDAO {

    /**
     * This is the method to be used to create
     * a record in the MemberShop table.
     */
    public void createMemberShop(MemberShop memberShop);

    /**
     * This is the method to be used to list down
     * a record from the MemberShop table corresponding
     * to a passed MemberShop (idMember, idShop).
     */
    public MemberShop getMemberShopByID(int idMember, int idShop);

    /**
     * This is the method to be used to list down
     * a record from the MemberShop table corresponding
     * to a passed MemberShop (cardNumber).
     */
    public MemberShop getMemberShopByCardNumber(String cardNumber);

    /**
     * This is the method to be used to list down
     * all the records from the MemberShop table.
     */
    public List<MemberShop> listMemberShops();

    /**
     * This is the method to be used to delete
     * a record from the MemberShop table corresponding
     * to a passed MemberShop (idMember, idShop).
     */
    public void deleteMemberShopByIDs(int idMember, int idShop);

    /**
     * This is the method to be used to update the points
     * a record into the MemberShop table.
     */
    public void updateMemberShopPoints(int idMember, int idShop, long points);
}
