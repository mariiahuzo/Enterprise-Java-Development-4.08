package com.ironhack.Lab_4_08.Lab_4_08.controllers.impl;


import com.ironhack.Lab_4_08.Lab_4_08.controllers.interfaces.HouseAssignmentController;
import com.ironhack.Lab_4_08.Lab_4_08.enums.House;
import com.ironhack.Lab_4_08.Lab_4_08.enums.Wing;
import com.ironhack.Lab_4_08.Lab_4_08.models.HouseAssignment;
import com.ironhack.Lab_4_08.Lab_4_08.services.interfaces.HouseAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseAssignmentControllerImpl implements HouseAssignmentController {

    @Autowired
    private HouseAssignmentService houseAssignmentService;

    @GetMapping("/house-assignment/house/{house}")
    public List<HouseAssignment> getAllHouseAssignmentByHouse(@PathVariable(name = "house") House house) {
        return houseAssignmentService.getAllHouseAssignmentByHouse(house);
    }

    @GetMapping("/house-assignment/wing")
    public List<HouseAssignment> getAllHouseAssignmentByWing(@RequestParam Wing wing) {
        return houseAssignmentService.getAllHouseAssignmentByWing(wing);
    }

    @PostMapping("/house-assignment")
    @ResponseStatus(HttpStatus.CREATED)
    public HouseAssignment saveHouseAssignment(@RequestBody HouseAssignment houseAssignment) {
        return houseAssignmentService.saveHouseAssignment(houseAssignment);
    }
}
