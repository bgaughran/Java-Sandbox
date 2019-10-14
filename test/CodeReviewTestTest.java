import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodeReviewTestTest {

    private CodeReviewTest codeReviewTest;

    @BeforeEach
    void cleanup() {
        codeReviewTest = null;
    }

    @Test
    void oneMaleTest() {
//        codeReviewTest = new CodeReviewTest(() -> new Person[]{new Person(42, "Tom", "Jones", "Male")});
        codeReviewTest = new CodeReviewTest(() -> new Person[]{new Person(42, "Tom", "Jones")});
        assertEquals(42, codeReviewTest.totalAge);
    }

    @Test
    void oneFemaleTest() {
//        codeReviewTest = new CodeReviewTest(() -> new Person[]{new Person(40, "Delilah", "Jones", "Female")});
        codeReviewTest = new CodeReviewTest(() -> new Person[]{new Person(40, "Delilah", "Jones")});
        assertEquals(40, codeReviewTest.totalAge);
    }

    @Test
    void noPersonTest() {
        codeReviewTest = new CodeReviewTest(() -> new Person[]{});
        assertEquals(0, codeReviewTest.totalAge);
    }

    @Test
        //WARNING - This test will fail with the current implementation. Check code review comments to avoid a 'NullPointerException'
    void nullDBTest() {
        codeReviewTest = new CodeReviewTest(null);
        assertEquals(0, codeReviewTest.totalAge);
    }

    @Test
        //WARNING - This test will fail with the current implementation. Check code review comments to avoid a 'ConcurrentModificationException'
    void manyPersonTest() {
//        codeReviewTest = new CodeReviewTest(
//                () -> new Person[]{
//                    new Person(42, "Tom", "Jones", "Male"),
//                    new Person(40, "Delilah", "Jones", "Female"),
//                    new Person(10, "Mickey", "Jones", "Male"),
//                    new Person(12, "Sarah", "Jones", "Female")}
//        );
        codeReviewTest = new CodeReviewTest(
                () -> new Person[]{
                        new Person(42, "Tom", "Jones"),
                        new Person(40, "Delilah", "Jones"),
                        new Person(10, "Mickey", "Jones"),
                        new Person(12, "Sarah", "Jones")}
        );
        assertEquals(104, codeReviewTest.totalAge);
    }

}
