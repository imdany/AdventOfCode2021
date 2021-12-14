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


- Day 14
Use of IntStream
```java
    IntStream.range(0, String.valueOf(this.currentSequence).length() - 1)
        .mapToObj(i -> String.valueOf(this.currentSequence).substring(i, i + 2))

    // Creates a range from 0 to X... and then you can map each of those elements to an object
```

Use of Compute in HashMap

```java
    map.compute(key, (key, v) -> v == null ? count : v + count);
    // Allows you to add or update a key on a map
```