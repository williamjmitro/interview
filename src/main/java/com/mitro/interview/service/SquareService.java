package com.mitro.interview.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SquareService
{
    public List<Integer> findSquares(String line)
    {
        String[] rawInput = line.split(" ");
        List<Integer> input = Arrays.stream(rawInput)
                                    .map(Integer::valueOf)
                                    .collect(Collectors.toList());

        return input.stream()
                    .filter(integer -> checkForPerfect(integer))
                    .sorted()
                    .collect(Collectors.toList());

    }

    public static boolean checkForPerfect(int input)
    {
        int num = ((int) Math.sqrt(input));

        return num * num == input;
    }
}
