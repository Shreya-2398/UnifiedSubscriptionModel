package com.projectunifiedSubscription.products.controller;

import com.projectunifiedSubscription.products.Exception.GenericException;
import com.projectunifiedSubscription.products.dto.PauseUnpauseDto;
import com.projectunifiedSubscription.products.dto.PlanDto;
import com.projectunifiedSubscription.products.dto.UpdatePlanDto;
import com.projectunifiedSubscription.products.entity.Plan;
import com.projectunifiedSubscription.products.entity.PlanData;
import com.projectunifiedSubscription.products.entity.PlanProduct;
import com.projectunifiedSubscription.products.response.GenericStringResponse;
import com.projectunifiedSubscription.products.service.Implementations.PlanServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plan")
public class PlanController {

    @Autowired
    private PlanServiceImpl planService;

    @PostMapping(path = "")
    public ResponseEntity<?> addSubscription(@RequestBody PlanDto planDto) {
        try {
            planService.add(planDto);
            return ResponseEntity.ok(new GenericStringResponse("Plan created successfully"));
        } catch (GenericException e) {
            return new ResponseEntity<>((new GenericStringResponse(e.getMessage())), e.getStatus());
        }
    }

    @GetMapping(path = "")
    public ResponseEntity<?> getById(@RequestParam int id) {
        try {
            PlanData planData = planService.getById(id);
            return ResponseEntity.ok(planData);
        } catch (GenericException e) {
            return new ResponseEntity<>((new GenericStringResponse(e.getMessage())), e.getStatus());
        }
    }

    @GetMapping(path = "/getAllPlans")
    public List<Plan> getAllPlans() {
        return planService.getAll();
    }


    @PatchMapping(path = "")
    public ResponseEntity<?> updateCost(@RequestBody UpdatePlanDto updatePlanDto) {
        try {
            PlanData planData = planService.updateCost(updatePlanDto);
            return ResponseEntity.ok(planData);
        } catch (GenericException e) {
            return new ResponseEntity<>((new GenericStringResponse(e.getMessage())), e.getStatus());
        }
    }

    @PatchMapping("/paused")
    public ResponseEntity<?> updatePausePlan(@RequestBody PauseUnpauseDto pauseUnpauseDto) {
        try {
            PlanData planData = planService.pauseUnpausePlan(pauseUnpauseDto);
            return ResponseEntity.ok(planData);
        } catch (GenericException e) {
            return new ResponseEntity<>((new GenericStringResponse(e.getMessage())), e.getStatus());
        }

//        @PatchMapping("/paused")
//        public ResponseEntity<?> updatePausePlan(@PathVariable int id, @RequestParam boolean paused) {
//            try {
//                Plan plan = planService.pauseUnpausePlan(id, paused);
//                return ResponseEntity.ok(plan);
//            } catch (GenericException e) {
//                return new ResponseEntity<>((new GenericStringResponse(e.getMessage())), e.getStatus());
//            }
    }
}

