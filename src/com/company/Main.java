package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Character> openedBrackets = new ArrayList<>();
        ArrayList<Character> closedBrackets = new ArrayList<>();

        Collections.addAll(openedBrackets, '(', '{', '[');
        Collections.addAll(closedBrackets, ')', '}', ']');

        //Stack<Character> brackets = new Stack<>();

        Deque<Character> brackets = new LinkedList<>();

        String expression = "([]])";

        boolean isValidExpression = true;

        for (int i = 0; i < expression.length(); i++) {
            char currentSymbol = expression.charAt(i);

            if (openedBrackets.contains(currentSymbol)) {
                brackets.push(currentSymbol);
            } else if (closedBrackets.contains(currentSymbol)) {
                if (brackets.size() == 0) {
                    isValidExpression = false;
                    break;
                } else {
                    char poppedBracket = brackets.pop();

                    int indexOpenBracket = openedBrackets.indexOf(poppedBracket);
                    int indexClosedBracket = closedBrackets.indexOf(currentSymbol);

                    if (indexOpenBracket != indexClosedBracket) {
                        isValidExpression = false;
                        break;
                    }
                }
            }
        }

        System.out.println(isValidExpression);
    }
}
