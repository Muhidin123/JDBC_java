package muhidinCliProjectJava;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    @DisplayName("Should return 0 for integer n == 1")
    void shouldReturnOneForIntN1 () {
        assertArrayEquals(new int[]{0}, solution.sumZero(1));
    }

    @Test
    @DisplayName("If int n is odd should return 0 at the index 0 in the array")
    void test2() {
        assertEquals(new int[]{0,-2,2,-1,1}[0], solution.sumZero(5)[0]);
    }

    @Test
    @DisplayName("Should return array with uniq n  numbers that add up to 0")
    void test1 () {
        assertArrayEquals(new int[]{0,-2,2,-1,1}, solution.sumZero(5));
    }


    @Test
    @DisplayName("Should return 0 for n == 1")
    void testReturn0ForNEqualsOne() {
        assertEquals(0, solution.minSteps(1));
    }

    @Test
    @DisplayName("Should return 5 for n == 6")
    void test3() {
        assertEquals(5, solution.minSteps(6));
    }


    @Test
    @DisplayName("Should return 0 for n = 0 or arr.length <= 1")
    void test4() {
        assertEquals(1, solution.searchInsert(new int[]{1}, 5));
        assertEquals(0, solution.searchInsert(new int[]{}, 5));
        assertEquals(0, solution.searchInsert(new int[]{4}, 2));

    }





}