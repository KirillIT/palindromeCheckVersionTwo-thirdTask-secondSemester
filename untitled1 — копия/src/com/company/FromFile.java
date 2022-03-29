package com.company;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

import java.util.Stack;

public class FromFile {

    public Stack<Character> FromFile(String Path) {

        File file = new File(Path);

        Scanner scanner = null;

        Stack<Character> stack = new Stack();

        try {

            scanner = new Scanner(file);

        }

        catch (FileNotFoundException ex) {

            System.out.println("Error: 0");

            System.exit(0);

        }

        String[] s;

        String line;

        line = scanner.nextLine();

        s = line.split(" ");

        Character temp;

        for (String number : s) {

            temp = number.toCharArray()[0];

            stack.push(temp.charValue());
        }

        return stack;

    }
}
