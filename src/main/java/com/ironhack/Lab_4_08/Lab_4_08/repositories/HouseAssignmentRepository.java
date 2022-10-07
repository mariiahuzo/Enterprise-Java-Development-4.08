package com.ironhack.Lab_4_08.Lab_4_08.repositories;

import com.ironhack.Lab_4_08.Lab_4_08.enums.House;
import com.ironhack.Lab_4_08.Lab_4_08.enums.Wing;
import com.ironhack.Lab_4_08.Lab_4_08.models.HouseAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseAssignmentRepository extends JpaRepository<HouseAssignment, Integer> {
    List<HouseAssignment> findAllHouseAssignmentByHouse(House house);

    List<HouseAssignment> findAllHouseAssignmentByWing(Wing wing);
}
