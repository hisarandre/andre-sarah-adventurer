package org.cirilgroup.service;

import org.cirilgroup.model.Adventurer;
import org.cirilgroup.model.Plan;
import org.cirilgroup.repository.AdventurerRepository;

import java.io.File;

/**
 * Service class for managing adventurers and their movement on a map.
 */
public class AdventurerService implements IAdventurerService {

    private final AdventurerRepository adventurerRepository;
    private final PlanService planService;

    /**
     * Constructor.
     */
    public AdventurerService() {
        this.adventurerRepository = new AdventurerRepository();
        this.planService = new PlanService();
    }

    @Override
    public String extractInputFileName(String[] args){
        if (args.length != 1) {
            System.out.println("Usage: java -jar adventurer-1.0.jar input_file.txt");
            return null;
        }

        String inputFileName = args[0];
        File file = new File(inputFileName);

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return null;
        }

        return inputFileName;
    }

    @Override
    public Adventurer loadAdventurer(String adventurerFile) {
        return adventurerRepository.loadAdventurer(adventurerFile);
    }

    @Override
    public void moveAdventurer(Adventurer adventurer, Plan plan) {
        String[] directions = adventurer.getDirection();

        if (directions != null) {
            // Iterates on each direction and moves the adventurer
            for (String dir : directions) {
                moveAdventurerInDirection(adventurer, plan, dir);
            }
        }

        System.out.println("Le personnage se trouve en " + adventurer);
    }

    @Override
    public void moveAdventurerInDirection(Adventurer adventurer, Plan plan, String direction) {
        int newPositionX = adventurer.getPositionX();
        int newPositionY = adventurer.getPositionY();

        switch (direction) {
            case "S":
                newPositionY++;
                break;
            case "N":
                newPositionY--;
                break;
            case "E":
                newPositionX++;
                break;
            case "O":
                newPositionX--;
                break;
            default:
                return;
        }

        // Verify if the path is clear from obstacles and plan's limits
        if (planService.verifyPath(newPositionX, newPositionY, plan) && planService.verifyBorders(newPositionX, newPositionY, plan)) {
            adventurer.setPositionX(newPositionX);
            adventurer.setPositionY(newPositionY);
        }
    }
}
