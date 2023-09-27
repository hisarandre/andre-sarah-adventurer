package org.cirilgroup.service;

import org.cirilgroup.model.Adventurer;
import org.cirilgroup.model.Plan;

/**
 * Interface for managing adventurers and their movement on a map.
 */
public interface IAdventurerService {

    /**
     * Extracts the input file name from the command-line arguments and performs validation checks.
     *
     * @param args The command-line arguments passed to the program.
     * @return The input file name if it exists and is valid, or null if there are issues.
     * @throws NullPointerException If the 'args' parameter is null.
     */
    String extractInputFileName(String[] args);

    /**
     * Loads an adventurer from the specified file.
     *
     * @param adventurerFile The path to the adventurer file.
     * @return The loaded Adventurer object.
     */
    Adventurer loadAdventurer(String adventurerFile);

    /**
     * Moves the adventurer based on a sequence of directions.
     *
     * @param adventurer The Adventurer object to be moved.
     * @param plan       The Plan object representing the map.
     */
    void moveAdventurer(Adventurer adventurer, Plan plan);

    /**
     * Moves the adventurer in a specified direction.
     *
     * @param adventurer The Adventurer object to be moved.
     * @param plan       The Plan object representing the map.
     * @param direction  The direction in which to move the adventurer ("N", "S", "E", or "O").
     */
    void moveAdventurerInDirection(Adventurer adventurer, Plan plan, String direction);
}
