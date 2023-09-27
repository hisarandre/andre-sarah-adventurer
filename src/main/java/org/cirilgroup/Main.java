package org.cirilgroup;

import org.cirilgroup.model.Adventurer;
import org.cirilgroup.model.Plan;
import org.cirilgroup.service.AdventurerService;
import org.cirilgroup.service.PlanService;

public class Main {

    public static void main(String[] args) {
        PlanService planService = new PlanService();
        AdventurerService adventurerService = new AdventurerService();

        // Check input file name from command line arguments
        String inputFileName = adventurerService.extractInputFileName(args);

        if (inputFileName != null) {
            // Load the plan and adventurer
            Plan plan = planService.loadPlan();
            Adventurer adventurer = adventurerService.loadAdventurer(inputFileName);

            // Move the adventurer on the plan
            adventurerService.moveAdventurer(adventurer, plan);
        } else {
            System.exit(1);
        }
    }
}