import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ExerciseTest {

    int[] arrayTest = {3, 3, 4, 6};
    private Exercise7 checkBalance;
    private Exercise8 displacementArr;

    @BeforeEach
    public void startUp() {
        System.out.println("Test is START");
        checkBalance = new Exercise7();
    }

    @AfterEach
    public void shutsown() {
        System.out.println("Test is END");
    }

    @DisplayName("Check Exercise7")
    @ParameterizedTest
    @MethodSource("data7")
    public void paramTest7(boolean result, int[] arr) {
        checkBalance = new Exercise7();
        Assertions.assertEquals(result, checkBalance.checkBalance(arr));
    }

    static Stream<Arguments> data7() {
        return Stream.of(
                Arguments.arguments(true, new int[]{1, 2, 3, 4, 1, 3, 2, 4}),
                Arguments.arguments(true, new int[]{4, 1, 3, 2}),
                Arguments.arguments(false, new int[]{2, 1, 3, 7, 10})/*,
                Arguments.arguments(true,  new int[]{29, 8, 3, 7, 10})*/
        );
    }

    @DisplayName("Check Exercise8")
    @ParameterizedTest
    @MethodSource("data8")
    public void paramTest8(int[] expectedArr, int[] arr, int n) {
        displacementArr = new Exercise8();
        Assertions.assertArrayEquals(expectedArr, displacementArr.displacementArr(arr, n));
    }

    static Stream<Arguments> data8() {
        return Stream.of(
                Arguments.arguments(new int[]{5, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5}, 1),
                Arguments.arguments(new int[]{3, 4, 5, 1, 2}, new int[]{1, 2, 3, 4, 5}, 3),
                Arguments.arguments(new int[]{3, 4, 5, 1, 2}, new int[]{1, 2, 3, 4, 5}, -2)

        );
    }

}