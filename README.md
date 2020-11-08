# About
Hive project "Computor v1": polynomial equation solver (constant, linear, quadratic). First attempt at Java. Very much WIP.

# Goal
To be able to solve constant, linear and quadratic equations given as a parameter string.

# Instructions
```shell
cd src
make
java com.computor.Main "insert valid equation"
```

# Possible improvements
* Third degree equation support
* Division support for terms
* Parenthesis support
* A more robust `sqrt()`
* Multivariate support (e.g. "x + y = y")
* Fractional output support for all kinds of equations

# Example
```
$ ./example.sh
javac com/computor/*.java com/computor/Equations/*.java

Input: 'X^2 = 0' =>
Reduced form: X^2 = 0
Polynomial degree: 2
The discriminant is 0, the single solution is:
0

Input: '5 * X^2 = X + 7' =>
Reduced form: -7 - 1 * X + 5 * X^2 = 0
Polynomial degree: 2
Discriminant is strictly positive, the two solutions are:
-1.087434
1.287434

Input: 'X^2 + 4 * X + 4 = 0' =>
Reduced form: 4 + 4 * X + X^2 = 0
Polynomial degree: 2
The discriminant is 0, the single solution is:
2

Input: 'X^2 + X + 0.25 = 0' =>
Reduced form: 0.250000 + X + X^2 = 0
Polynomial degree: 2
The discriminant is 0, the single solution is:
-1 / 2

Input: 'X^3 = 0' =>
Reduced form: X^3 = 0
Polynomial degree: 3
The polynomial exponents are not integers or are outside the range [0..2], cannot solve.

Input: 'X^1.5 = 0' =>
Reduced form: X^1.500000 = 0
Polynomial degree: 1.500000
The polynomial exponents are not integers or are outside the range [0..2], cannot solve.

Input: '3 * X = 17' =>
Reduced form: -17 - 3 * X = 0
Polynomial degree: 1
The single solution is: 17 / 3

Input: 'X = X + 5' =>
Reduced form: -5 = 0
Polynomial degree: 0
The equation is false

Input: '4 * X^2 + 18 * X = 4 * X^2 + 18 * X' =>
Reduced form: 0 = 0
Polynomial degree: 0
The equation is true with all values of 'X'
```
