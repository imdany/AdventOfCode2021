package com.imdany.AdventOfCode2021.day10;

import java.util.Stack;

public class Line {

    private char[] value;
    private boolean isValid;
    private boolean isIncomplete;
    private long score;
    private long cost;
    private Stack<Character> stack;
    private char[] missingChars;

    Line(String line) {
        this.score = 0;
        this.value = line.toCharArray();
        this.stack = new Stack<Character>();
        this.isIncomplete = true;
        this.isValid = this.validateLine();

        if(this.isValid && !this.stack.isEmpty()) {
            this.completeLine();
        }
    }

    public String getMissingChar() {
        return String.valueOf(this.missingChars);
    }

    public boolean getIsValid(){
        return this.isValid;
    }

    public boolean getIsIncomplete(){
        return this.isIncomplete;
    }

    public long getCost(){
        return this.cost;
    }

    public long getTotalScore(){
        return this.score;
    }

    private boolean validateLine(){
        for (int i = 0; i< this.value.length; i++){
            char x = value[i];
            if(x == '(' || x == '{' || x == '<' || x == '['){
                this.stack.push(x);
            } else if (stack.isEmpty()) {
                this.isIncomplete = false;
                return this.score == 0 ? true : false;
            } else if (x == ')' && this.stack.peek() == '(' ||
                       x == '}' && this.stack.peek() == '{' ||
                       x == '>' && this.stack.peek() == '<' ||
                       x == ']' && this.stack.peek() == '[') {
                stack.pop();
            } else {
                this.score += getScore(x);
                break;
            }
        }
        return this.score == 0 ? true : false;
    }

    private void completeLine(){
        // Check remaining values in stack and complete them
        int it = this.stack.size();
        this.missingChars = new char[it];
        for (int i = 0; i< it; i++){
            char currentValue = this.stack.pop();
            this.missingChars[i] = this.getMissingValue(currentValue);
            long preScore = this.getCompletionCost(currentValue);
            this.cost = this.calculateCost(preScore);
        }
    }

    public long calculateCost(long cost) {
        return this.cost * 5 + cost;
    }

    public char getMissingValue(char x){
        char c = ' ';
        switch (x) {
            case '(' ->  c = ')';
            case '[' ->  c = ']';
            case '{' ->  c = '}';
            case '<' ->  c = '>';
        }
        return c;
    }

    public long getCompletionCost(char x) {
        int cost = 0;
        switch (x) {
            case '(' ->  cost = 1;
            case '[' ->  cost = 2;
            case '{' ->  cost = 3;
            case '<' ->  cost = 4;
        }
        return cost;
    }

    public long getScore(char x) {
        int score = 0;
        switch (x) {
            case ')' ->  score = 3;
            case ']' ->  score = 57;
            case '}' ->  score = 1197;
            case '>' ->  score = 25137;
        }
        return score;
    }


}
