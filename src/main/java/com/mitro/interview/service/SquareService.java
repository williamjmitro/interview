package com.mitro.interview.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

@Service
public class SquareService {
    public List<Integer> findSquares(String line) {
        String[] rawInput = line.split(" ");
        return Arrays.stream(rawInput)
                .map(Integer::valueOf)
                .filter(SquareService::checkForPerfect)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> findEvensAndSquare(List<Integer> input, IntBinaryOperator operator, Integer numberToUse) {

        return input.stream()
                .map(integer -> integer % 2 == 0 ? operator.applyAsInt(integer, numberToUse) : integer)
                .sorted()
                .toList();
    }

    public List<Integer> findOddsAndMultiple(List<Integer> inputList) {

        return inputList.stream()
                .map(integer -> integer % 2 == 1 ? integer / 3 : integer)
                .sorted()
                .toList();
    }

    public static boolean checkForPerfect(int input) {
        int num = ((int) Math.sqrt(input));

        return num * num == input;
    }
}
