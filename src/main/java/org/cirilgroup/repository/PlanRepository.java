package org.cirilgroup.repository;

import org.cirilgroup.model.Plan;
import org.cirilgroup.model.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository class for loading plans from files.
 */
public class PlanRepository {

    /**
     * Loads a plan from the specified file.
     *
     * @return The loaded Plan object.
     */
    public Plan loadPlan() {
        InputStream inputStream = getClass().getResourceAsStream("/carte.txt");

        int maxLines = 0;
        int maxCharacters = 0;
        int lineNumber = 0;
        List<Tree> trees = new ArrayList<>();

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    maxLines++;

                    // Update maxCharacters if needed
                    if (line.length() > maxCharacters) {
                        maxCharacters = line.length();
                    }

                    // Read each character of the line
                    for (int i = 0; i < line.length(); i++) {
                        char character = line.charAt(i);

                        if (character == '#') {
                            // Create a Tree object with coordinates
                            Tree tree = new Tree(i , lineNumber);
                            trees.add(tree);
                        }
                    }
                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new Plan (trees, maxCharacters, maxLines);
    }
}
