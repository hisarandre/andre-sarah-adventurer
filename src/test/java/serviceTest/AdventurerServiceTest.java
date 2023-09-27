package serviceTest;

import org.cirilgroup.model.Adventurer;
import org.cirilgroup.model.Plan;
import org.cirilgroup.model.Tree;
import org.cirilgroup.repository.AdventurerRepository;
import org.cirilgroup.service.AdventurerService;
import org.cirilgroup.service.PlanService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AdventurerServiceTest {

    private AdventurerService adventurerService;
    private AdventurerRepository adventurerRepository;
    private PlanService planService;

    @Before
    public void setUp() {
        adventurerRepository = Mockito.mock(AdventurerRepository.class);
        planService = Mockito.mock(PlanService.class);
        adventurerService = new AdventurerService();
    }

    @Test
    public void moveAdventurerWithoutObstacleTest() {
        // GIVEN
        // There is an adventurer and no obstacle on map
        Adventurer adventurer = new Adventurer(0, 0, new String[]{"S"});
        List<Tree> trees = new ArrayList<>();
        Tree tree = new Tree(2,2);
        trees.add(tree);
        Plan plan = new Plan(trees, 3, 3);

        // WHEN
        // the adventurer moves to south and the path is clear
        Mockito.when(planService.verifyPath(anyInt(), anyInt(), eq(plan))).thenReturn(true);
        Mockito.when(planService.verifyBorders(anyInt(), anyInt(), eq(plan))).thenReturn(true);
        adventurerService.moveAdventurerInDirection(adventurer, plan, "S");

        // THEN
        // the adventurer should have moved from 1y
        assertEquals(0, adventurer.getPositionX());
        assertEquals(1, adventurer.getPositionY());
    }

    @Test
    public void moveAdventurerWithObstacleTest() {
        // GIVEN
        // There is an adventurer and an obstacle on map
        Adventurer adventurer = new Adventurer(0, 0, new String[]{"S"});
        List<Tree> trees = new ArrayList<>();
        Tree tree = new Tree(0,1);
        trees.add(tree);
        Plan plan = new Plan(trees, 3, 3);

        // WHEN
        // the adventurer moves to south and there is a tree
        Mockito.when(planService.verifyPath(0, 1, plan)).thenReturn(false);
        Mockito.when(planService.verifyBorders(0, 1, plan)).thenReturn(true);
        adventurerService.moveAdventurerInDirection(adventurer, plan, "S");

        // THEN
        // the adventurer should not move
        assertEquals(0, adventurer.getPositionX());
        assertEquals(0, adventurer.getPositionY());
    }

    @Test
    public void moveAdventurerWithBorderTest() {
        // GIVEN
        // There is an adventurer and an obstacle on map
        Adventurer adventurer = new Adventurer(2, 2, new String[]{"S"});
        List<Tree> trees = new ArrayList<>();
        Tree tree = new Tree(0,1);
        trees.add(tree);
        Plan plan = new Plan(trees, 2, 2);

        // WHEN
        // the adventurer moves to south and it's the limit of the map
        Mockito.when(planService.verifyPath(2, 2, plan)).thenReturn(true);
        Mockito.when(planService.verifyBorders(2, 2, plan)).thenReturn(false);
        adventurerService.moveAdventurerInDirection(adventurer, plan, "S");

        // THEN
        // the adventurer should not move
        assertEquals(2, adventurer.getPositionX());
        assertEquals(2, adventurer.getPositionY());
    }

}
