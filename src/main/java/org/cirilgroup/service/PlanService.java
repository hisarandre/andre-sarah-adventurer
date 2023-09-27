package org.cirilgroup.service;

import org.cirilgroup.model.Plan;
import org.cirilgroup.model.Tree;
import org.cirilgroup.repository.PlanRepository;

import java.util.List;

/**
 * Service class for managing plans and obstacles.
 */
public class PlanService implements IPlanService {

    private final PlanRepository planRepository;

    /**
     * Constructor.
     */
    public PlanService() {
        this.planRepository = new PlanRepository();
    }

    @Override
    public Plan loadPlan() {
        return planRepository.loadPlan();
    }

    @Override
    public boolean verifyPath(int targetPositionX, int targetPositionY, Plan plan) {
        List<Tree> trees = plan.getTrees();

        for (Tree tree : trees) {
            // Verify if the tree position equals the target position
            if (tree.getPositionX() == targetPositionX && tree.getPositionY() == targetPositionY) {
                System.out.println("Found a tree");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean verifyBorders(int targetPositionX, int targetPositionY, Plan plan) {
        int borderLimitX = plan.getBorderLimitX();
        int borderLimitY = plan.getBorderLimitY();

        // Verify if the target position equals the plan's limits
        if ( targetPositionX > borderLimitX || targetPositionY > borderLimitY || targetPositionX < 0 || targetPositionY < 0) {
            System.out.println("Hit the border");
            return false;
        }

        return true;
    }
}
