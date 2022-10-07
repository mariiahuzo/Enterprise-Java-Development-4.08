package com.ironhack.Lab_4_08.Lab_4_08.services.impl;

import com.ironhack.Lab_4_08.Lab_4_08.enums.House;
import com.ironhack.Lab_4_08.Lab_4_08.enums.Wing;
import com.ironhack.Lab_4_08.Lab_4_08.models.HouseAssignment;
import com.ironhack.Lab_4_08.Lab_4_08.repositories.HouseAssignmentRepository;
import com.ironhack.Lab_4_08.Lab_4_08.services.interfaces.HouseAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseAssignmentServiceImpl implements HouseAssignmentService {

    @Autowired
    private HouseAssignmentRepository houseAssignmentRepository;

    public List<HouseAssignment> getAllHouseAssignmentByHouse(House house) {
        return houseAssignmentRepository.findAllHouseAssignmentByHouse(house);
    }

    public List<HouseAssignment> getAllHouseAssignmentByWing(Wing wing) {
        return houseAssignmentRepository.findAllHouseAssignmentByWing(wing);
    }

    public HouseAssignment saveHouseAssignment(HouseAssignment houseAssignment) {
        /*if (houseAssignment.getId() != null && houseAssignmentRepository.existsById(houseAssignment.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Este id ya existe en base de datos");
        }*/
        houseAssignment.setId(null);
        return houseAssignmentRepository.save(houseAssignment);
    }
}
