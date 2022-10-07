package com.ironhack.Lab_4_08.Lab_4_08.controllers.interfaces;



import com.ironhack.Lab_4_08.Lab_4_08.enums.House;
import com.ironhack.Lab_4_08.Lab_4_08.enums.Wing;
import com.ironhack.Lab_4_08.Lab_4_08.models.HouseAssignment;

import java.util.List;

public interface HouseAssignmentController {
    List<HouseAssignment> getAllHouseAssignmentByHouse(House house);
    List<HouseAssignment> getAllHouseAssignmentByWing(Wing wing);
    HouseAssignment saveHouseAssignment(HouseAssignment houseAssignment);
}
