package serviceTest;

import org.cirilgroup.model.Plan;
import org.cirilgroup.model.Tree;
import org.cirilgroup.repository.PlanRepository;
import org.cirilgroup.service.PlanService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlanServiceTest {

    private PlanService planService;
    private PlanRepository planRepository;

    @Before
    public void setUp() {
        planRepository = mock(PlanRepository.class);
        planService = new PlanService();
    }

    @Test
    public void verifyPathWithTreeTest() {
        // GIVEN
        // There is a tree at position 1,1
        List<Tree> trees = new ArrayList<>();
        Tree tree = new Tree(1, 1);
        trees.add(tree);
        Plan plan = new Plan(trees, 3, 3);

        // WHEN
        // Verify a path where a tree is present
        boolean result = planService.verifyPath(1, 1, plan);

        // THEN
        // it should find a tree and return false
        assertFalse(result);
    }

    @Test
    public void verifyPathWithoutTreeTest() {
        // GIVEN
        // There is a tree at position 2,2
        List<Tree> trees = new ArrayList<>();
        Tree tree = new Tree(2, 2);
        trees.add(tree);
        Plan plan = new Plan(trees, 3, 3);

        // WHEN
        // Verify a path where no tree is present
        boolean result = planService.verifyPath(1, 1, plan);

        // THEN
        // it shouldn't find a tree and return true
        assertTrue(result);
    }

    @Test
    public void verifyBordersWithinLimitsTest() {
        // GIVEN
        // The plan's limits are 5,5
        List<Tree> trees = new ArrayList<>();
        Tree tree = new Tree(1, 1);
        trees.add(tree);
        Plan plan = new Plan(trees, 5, 5);

        // WHEN
        // Verify the plan's limits at 3,3
        boolean result = planService.verifyBorders(3, 3, plan);

        // THEN
        // it should be true because (3, 3) is within the plan's limits
        assertTrue(result);
    }

    @Test
    public void verifyBordersOutsideLimitsTest() {
        // GIVEN
        // The plan's limits are 5,5
        List<Tree> trees = new ArrayList<>();
        Tree tree = new Tree(1, 1);
        trees.add(tree);
        Plan plan = new Plan(trees, 5, 5);

        // WHEN
        // Verify the plan's limits at 6,6
        boolean result = planService.verifyBorders(6, 6, plan);

        // THEN
        // it should be true because (6, 6) is outside the plan's limits
        assertFalse(result);
    }
}
