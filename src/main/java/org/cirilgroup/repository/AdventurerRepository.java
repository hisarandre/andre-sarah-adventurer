package org.cirilgroup.repository;

import org.cirilgroup.model.Adventurer;

import java.io.*;

/**
 * Repository class for loading adventurers from files.
 */
public class AdventurerRepository {

    /**
     * Loads an adventurer from the specified file.
     *
     * @param adventurerFile The path to the adventurer file to be loaded.
     * @return The loaded Adventurer object.
     */
    public Adventurer loadAdventurer(String adventurerFile) {

        if (adventurerFile != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(adventurerFile));
                String line ;

                // Read the first line and get the initial position
                if ((line = reader.readLine()) != null) {
                    String[] position = line.split(",");

                    int positionX = Integer.parseInt(position[0]);
                    int positionY = Integer.parseInt(position[1]);

                    // Read the second line and get the direction
                    if ((line = reader.readLine()) != null) {
                        String[] direction = new String[line.length()];

                        // Convert each character to a string and store it in the array
                        for (int i = 0; i < line.length(); i++) {
                            direction[i] = String.valueOf(line.charAt(i));
                        }

                        // Initialize adventurer position and direction
                        return new Adventurer(positionX, positionY, direction);
                    }
                }

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
