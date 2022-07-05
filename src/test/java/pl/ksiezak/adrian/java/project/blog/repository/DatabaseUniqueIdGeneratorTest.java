package pl.ksiezak.adrian.java.project.blog.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class DatabaseUniqueIdGeneratorTest {

    public static final int DEFAULT_ID_VALUE = 0;
    public static final int EXPECTED_IDS_DIFFERENCE = 1;

    @Test
    void generateId() {
        //given

        //when
        int firstGenerateId = DatabaseUniqueIdGenerator.generateId();
        int secondGenerateId = DatabaseUniqueIdGenerator.generateId();
        int differenceBetweenGeneratedId = secondGenerateId - firstGenerateId;
        //then
        assertAll(
                () -> Assertions.assertTrue(firstGenerateId > DEFAULT_ID_VALUE,"DatabaseUniqueIdGenerator.firstGenerateId() isn't working good."),
                () -> Assertions.assertEquals(differenceBetweenGeneratedId, EXPECTED_IDS_DIFFERENCE,"differenceBetweenGeneratedId isn't equals 1 .")
        );
    }
}