\# Arccos Calculator (Java Swing)



A small scientific calculator that computes \*\*arccos(x)\*\* for `x ∈ \[-1, 1]` using the identity  

`arccos(x) = π/2 – arcsin(x)` where `arcsin(x)` is approximated via its Maclaurin series.



\## Features

\- Java Swing \*\*GUI\*\* with input validation and friendly error messages

\- \*\*Accessibility\*\*: screen‑reader name/description, focusable, tooltip

\- \*\*UI/UX\*\*: clear hierarchy, alignment, consistent typography, feedback on invalid input

\- \*\*Semantic Versioning\*\*: `1.1.0`

\- \*\*Static analysis\*\*: Checkstyle (Google style) and SonarQube issues resolved

\- \*\*Unit tests\*\*: JUnit 5 for core math (arcsin series / arccos calculation)



\## Tech

\- Java 17+ (works on 11+)

\- JUnit 5

\- Checkstyle (Google Java Style)

\- SonarQube for IDE (IntelliJ plugin)



\## Run (IntelliJ)

1\. Open the project in IntelliJ.

2\. Ensure SDK is set (Project SDK: Java 17+).

3\. Run `sep\_project.ArccosCalculatorGui` (green ▶ next to `main`).



\## Run (CLI, quick)

```bash

javac -d out src/sep\_project/ArccosCalculatorGui.java

java -cp out sep\_project.ArccosCalculatorGui



