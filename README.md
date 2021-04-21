# numerical-methods-quadraticequation-exercise

This exercise is related to computer arithmetic:

## Computer Arithmetic / Machine Precision (1): Quadratic Equation Solver

1) Implement a class that implements the interface `QuadraticEquation` of the package `info.quantlab.numericalmethods.lecture.computerarithmetics.quadraticequation`.

*Important*: The interface you have to implement is not part of this project. It is imported
from another project that is referenced by this project. To have a look at this interface,
you can select "Open Declaration" in your IDE (right-click on the interface name) or look here:
https://github.com/qntlb/numerical-methods-lecture/blob/master/src/main/java/info/quantlab/numericalmethods/lecture/computerarithmetics/quadraticequation/QuadraticEquation.java

The class implementing `QuadraticEquation` should allow to solve the equation x^2 + p x + q = 0, finding the smallest root of this equation in a *numerically stable way*.

*Note*: As your task is to implement the interface, read the JavaDoc of that interface for a specification of what to do.

2) When done with 1) implement the method `createQuadraticEquation` of the class `QuadraticEquationAssignmentSolution`,
such that it allows to create an object of the class you have implemented in 1).

A class like `QuadraticEquationAssignmentSolution` is called a *Factory*, because it allows to create objects. It allows us to create an object of *your* class, without knowing the name of your class. We will use this method to test your implementation.

*Hint*: This is a trivial task. If your class in 1) is named `QuadraticEquationFromParameters` and if
it has a constructor `QuadraticEquationFromParameters(q,p)`, then the body of the implementation of the factory class
is just

```
  public QuadraticEquation createQuadraticEquation(double q, double p) {
    return new QuadraticEquationFromParameters(q,p);
  }
```

You can test your implementation by running the unit test in `src/test/java`.

## Main Task

The main task of this exercise is to provide a *numerically stable* formula implementation of the method `getSmallestRoot`.

Depending on the value of the coefficients q and p of the quadratic equation,
the well known formulas for the root of the quadratic equation may exhibit
large *cancellation errors*.

