import org.cirilgroup.model.Adventurer;
import org.cirilgroup.model.Plan;
import org.cirilgroup.repository.AdventurerRepository;
import org.cirilgroup.repository.PlanRepository;
import org.cirilgroup.service.AdventurerService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdventurerIntegrationTest {

    private AdventurerService adventurerService;

    @Before
    public void setUp() {
        adventurerService = new AdventurerService();
    }

    @Test
    public void AdventurerMovesWithoutObstaclesTest() {
        // GIVEN
        // The adventurer starts at 3,0
        AdventurerRepository adventurerRepository = new AdventurerRepository();
        PlanRepository planRepository = new PlanRepository();
        Adventurer adventurer = adventurerRepository.loadAdventurer("src/test/resources/aventurier_test1.txt");
        Plan plan = planRepository.loadPlan();

        // WHEN
        // The adventurer moves on plan
        adventurerService.moveAdventurer(adventurer, plan);

        // THEN
        // It should stop at 9,2
        assertEquals(9, adventurer.getPositionX());
        assertEquals(2, adventurer.getPositionY());
    }

    @Test
    public void AdventurerMovesWithObstaclesTest() {
        // GIVEN
        // The adventurer starts at 9,6
        AdventurerRepository adventurerRepository = new AdventurerRepository();
        PlanRepository planRepository = new PlanRepository();
        Adventurer adventurer = adventurerRepository.loadAdventurer("src/test/resources/aventurier_test2.txt");
        Plan plan = planRepository.loadPlan();

        // WHEN
        // The adventurer moves on plan
        adventurerService.moveAdventurer(adventurer, plan);

        // THEN
        // It should stop at 5,7
        assertEquals(5, adventurer.getPositionX());
        assertEquals(7, adventurer.getPositionY());
    }
}
