package com.projectunifiedSubscription.products.service;

import com.projectunifiedSubscription.products.dto.PauseUnpauseDto;
import com.projectunifiedSubscription.products.dto.PlanDto;
import com.projectunifiedSubscription.products.dto.UpdatePlanDto;
import com.projectunifiedSubscription.products.entity.Plan;
import com.projectunifiedSubscription.products.entity.PlanData;

import java.util.List;

public interface PlanService {
    Plan add(PlanDto planDto);

    PlanData getById(int id);

    List<Plan> getAll();

    PlanData updateCost(UpdatePlanDto updatePlanDto);

//    Plan pauseUnpausePlan(int id, boolean paused);

    PlanData pauseUnpausePlan(PauseUnpauseDto pauseUnpauseDto);
}
