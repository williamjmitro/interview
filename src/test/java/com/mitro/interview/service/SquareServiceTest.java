package com.mitro.interview.service;

import com.mitro.interview.InterviewApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = InterviewApplication.class)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class SquareServiceTest
{

    @Autowired
    SquareService squareService;

    @Test
    public void testApp()
    {
        String        input      = "1 33 4 16 9 55 2";
        List<Integer> sortedList = squareService.findSquares(input);

        assertEquals(sortedList.toString(), "[1, 4, 9, 16]");
    }
}
