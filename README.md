# Advent of Code 2021

Solutions using Java. This code doesn't pretend to be perfect or efficient. 

I haven't used Java in years, so I just want to re-learn it, practice it a little bit, try some design parterns and have fun! :)


## CI / CD
Using Github actions for running the code. Check the logs of the "Run" step.

[![workflow](https://github.com/imdany/AdventOfCode2021/actions/workflows/maven.yml/badge.svg)](https://github.com/imdany/AdventOfCode2021/actions/workflows/maven.yml)

## Lessons Learnt  

- Day 10

Use of Stack:

```java
Stack<Character> stack = new Stack<Character>();

stack.push(x); // Adds new element to top of stack

stack.pop(); // Removes top element from stack

stack.peek(); // Checks top element without removing it

```

Lambda expressions:

```java
// Filtering values of an array
Arrays.stream(cost).filter(x -> x !=0 ).toArray(Long[]::new);
```

