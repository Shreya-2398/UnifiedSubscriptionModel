package com.projectunifiedSubscription.products.service.Implementations;

import com.projectunifiedSubscription.products.Exception.GenericException;
import com.projectunifiedSubscription.products.dto.PauseUnpauseDto;
import com.projectunifiedSubscription.products.dto.PlanDto;
import com.projectunifiedSubscription.products.dto.UpdatePlanDto;
import com.projectunifiedSubscription.products.entity.Plan;
import com.projectunifiedSubscription.products.entity.PlanData;
import com.projectunifiedSubscription.products.entity.PlanProduct;
import com.projectunifiedSubscription.products.repository.ProductRepo;
import com.projectunifiedSubscription.products.repository.PlanProductRepo;
import com.projectunifiedSubscription.products.repository.PlanRepo;
import com.projectunifiedSubscription.products.service.ProductService;
import com.projectunifiedSubscription.products.service.PlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepo planRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private PlanProductRepo planProductRepo;

    @Autowired
    private ProductService productService;

    @Override
    public Plan add(PlanDto planDto) {
        /*
         * 1. Check if plan with the name exists or not
         * 2. If yes
         *      throw error
         * 3. else
         *      Check if all products exists in db or not
         *      If yes
         *          Create plan
         *          Add Products with new plan id to plan products table
         *      Else
         *          throw error
         */

        Optional<Plan> findSubscriptionPlan = planRepo.findProductByName(planDto.getName());
        if (!findSubscriptionPlan.isEmpty()) {
            throw new GenericException("Plan already exists with this name", HttpStatus.CONFLICT);
        }
        for (int i = 0; i < planDto.getProducts().length; i++) {
            productService.getById(planDto.getProducts()[i].getId());
        }
        Plan subscriptionPlan = new Plan();
        subscriptionPlan.setName(planDto.getName());
        subscriptionPlan.setPrice(planDto.getPrice());
        Plan newPlan = planRepo.save(subscriptionPlan);

        for (int i = 0; i < planDto.getProducts().length; i++) {
            PlanProduct planProduct = new PlanProduct();
            planProduct.setPlanId(newPlan.getId());
            planProduct.setPrice(0);
            planProduct.setProductId(planDto.getProducts()[i].getId());
            planProduct.setTimePeriod(planDto.getTimePeriod());
            planProductRepo.save(planProduct);
        }
        return subscriptionPlan;
    }

    @Override
    public PlanData getById(int id) {
        /*
         * 1. Check if plan exists with the id
         * 2. If yes
         *      then read all the products from plan products table of the plan
         *      Create new Plan Instance and set all data. Return the instance from this function
         *    else
         *      throw error plan doesn't exist
         */
        Optional<Plan> plan = planRepo.findById(id);
        if (plan.isEmpty()) {
            throw new GenericException("Plan doesn't exist", HttpStatus.NOT_FOUND);
        }

        PlanProduct[] products = planProductRepo.findProductByPlanId(id);
        PlanData planData = new PlanData(plan.get().getId(), plan.get().getName(), plan.get().getPrice(),plan.get().isPaused(),products);
        return planData;
    }

    @Override
    public List<Plan> getAll() {
        return planRepo.findAll();
    }

    @Override
    public PlanData updateCost(UpdatePlanDto updatePlanDto) {
       /*
        * 1. Check if plan exists or not with the id
        2. If yes
            Update cost in plan table and get the new plan. Return the new plan
        3. else
            throw error
        */
        Optional<Plan> plan = planRepo.findById(updatePlanDto.getId());
        if (plan.isEmpty()) {
            throw new GenericException("Plan doesn't exist", HttpStatus.NOT_FOUND);
        }

        plan.get().setPrice(updatePlanDto.getPrice());
        return this.getById(updatePlanDto.getId());
    }

//    @Override
//    public Plan pauseUnpausePlan(PauseUnpauseDto pauseUnpauseDto){
//        Plan> plan1 = planRepo.findById(pauseUnpauseDto.getId());
//        if(plan1.isEmpty()){
//            throw new GenericException("Plan doesn't exist",HttpStatus.NOT_FOUND);
//        }
//        plan1.get().setPaused(pauseUnpauseDto.isPaused());
//       return plan1;
//    }

//    @Override
//    public Plan pauseUnpausePlan(int id, boolean paused){
//        Optional <Plan> optionalPlan = planRepo.findById(id);
//        if(optionalPlan.isEmpty()){
//            throw new GenericException("Plan doesn't exist",HttpStatus.NOT_FOUND);
//        }
//        Plan plan = optionalPlan.get();
//        plan.setPaused(paused);
//        planRepo.save(plan);
//        return plan;
//    }

    @Override
    public PlanData pauseUnpausePlan(PauseUnpauseDto pauseUnpauseDto){
        Optional <Plan> plan = planRepo.findById(pauseUnpauseDto.getId());
        if(plan.isEmpty()){
            throw new GenericException("Plan doesn't exist",HttpStatus.NOT_FOUND);
        }
        System.out.println(pauseUnpauseDto.isPaused());
        plan.get().setPaused(pauseUnpauseDto.isPaused());
        return this.getById(pauseUnpauseDto.getId());
    }
}


