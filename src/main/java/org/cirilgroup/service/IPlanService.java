package org.cirilgroup.service;

import org.cirilgroup.model.Plan;

/**
 * Interface for managing plans and obstacles.
 */
public interface IPlanService {

    /**
     * Loads a plan from a specified file.
     *
     * @return The loaded Plan object.
     */
    Plan loadPlan();

    /**
     * Verifies if the path at the specified target position is clear of obstacles.
     *
     * @param targetPositionX The X-coordinate of the target position.
     * @param targetPositionY The Y-coordinate of the target position.
     * @param plan            The Plan object representing the map.
     * @return True if the path is clear; otherwise, false.
     */
    boolean verifyPath(int targetPositionX, int targetPositionY, Plan plan);

    /**
     * Verifies if the specified target position is within the borders of the map.
     *
     * @param targetPositionX The X-coordinate of the target position.
     * @param targetPositionY The Y-coordinate of the target position.
     * @param plan            The Plan object representing the map.
     * @return True if the position is within the borders; otherwise, false.
     */
    boolean verifyBorders(int targetPositionX, int targetPositionY, Plan plan);
}
