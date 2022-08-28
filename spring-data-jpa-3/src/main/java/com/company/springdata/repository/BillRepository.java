package com.company.springdata.repository;

import com.company.springdata.entity.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByDayCount(Integer dayCount);
    //TODO: JPQL

    @Query("select b from Bill b where b.dayCount=?1 and b.doctorCharge=?2")
    List<Bill> getBillByDayCountAndDoctorCharge(Integer dayCount, Integer doctorCharge);


    @Query("select b.dayCount from Bill b where b.doctorCharge=?1")
    List<Bill> getDayCountByDoctorCharge(Integer doctorCharge);

    @Query("select b.roomCharge from Bill b where b.doctorCharge>?1 and b.labCharge<?1 order by b.dayCount")
    List<Bill> getRoomChargeByDoctorChargeAndLabCharge(Integer doctorCharge, Integer labCharge);

    @Query("select b from Bill b where b.roomCharge<?1 and b.labCharge>?2 order by b.roomCharge")
    Page<Bill> getBillByRoomChargeAndLabCharge(Integer roomCharge, Integer labCharge, Pageable pageable);


    //TODO: NATIVE QUERY

    @Query(
            value = "select * from tbl_bill b where b.bill_id=?1 and b.room_charge=?2",
            nativeQuery = true
    )
    Bill getBillByBillIdAndRoomCharge(Integer billId, Integer roomCharge);

    @Query(
            value = "select * from tbl_bill b where b.bill_id= :billId and b.lab_charge= :labCharge",
            nativeQuery = true
    )
    Bill getBillByBillIdAndLabCharge(
            @Param("billId") Integer billId,
            @Param("labCharge") Integer labCharge
    );

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_bill set doctor_charge=?1 where room_charge=?2",
            nativeQuery = true
    )
    int updateBillDoctorChargeByRoomCharge(Integer doctorCharge,Integer roomCharge);

//    @Modifying
//    @Transactional
//    @Query(
//            value = "delete from Bill b where b.room_charge = :roomCharge",
//            nativeQuery = true
//    )
//    void deleteBillsByRoomCharge(
//            @Param("roomCharge") Integer roomCharge
//    );
}
