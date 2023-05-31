package com.mitro.interview.service;

import com.mitro.interview.InterviewApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.function.IntBinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = InterviewApplication.class)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class SquareServiceTest {

    @Autowired
    SquareService squareService;

    @Test
    public void testApp() {
        String input = "1 33 4 16 9 55 2";
        List<Integer> sortedList = squareService.findSquares(input);

        assertEquals(sortedList.toString(), "[1, 4, 9, 16]");
    }

    /**
     * All odds should return empty list
     * All evens should return a list of the same size as the input
     * <p>
     * <p>
     * Rewrote this test to make use of the new requirement.
     */
    @Test
    public void testEvens() {
        List<Integer> testList = List.of(4);

        IntBinaryOperator expression = (left, right) -> left / right;

        List<Integer> sortedList = squareService.findEvensAndSquare(testList, expression, 4);

        assertEquals(sortedList.toString(), "[1]");
    }
}
