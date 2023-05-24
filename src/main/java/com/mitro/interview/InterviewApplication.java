package com.mitro.interview;

import com.mitro.interview.service.SquareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@SpringBootApplication
public class InterviewApplication
{

    @Autowired
    SquareService squareService;

    public static void main(String[] args)
    {
        SpringApplication.run(InterviewApplication.class, args);
    }

    @Bean
    @Profile("!test")
    public CommandLineRunner run()
    {
        return args -> {
            boolean loop = true;
            do
            {
                System.out.println("Enter any numbers and get all that perfect squares back");
                Scanner scanner = new Scanner(System.in);
                System.out.println(squareService.findSquares(scanner.nextLine()));

                System.out.println("Enter 0 to quit or 1 to enter another set of numbers");
                String line = scanner.nextLine();

                if (Integer.valueOf(line) == 0)
                {
                    loop = false;
                }

            } while (loop);

        };
    }
}
