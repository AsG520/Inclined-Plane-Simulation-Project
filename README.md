# Inclined-Plane-Simulation-Project

Visual of Simulation

Features in Simulation
- Inclined ramp, floor, and ball are designed from paint method.
- Force of gravity components are broken into trigonometric functions from sine and cosine.
- Smart horizontal position detection by conditionals are enhanced to prevent ball from sinking. 
- Vertical motion is not present for the ball, meaning sum of force in this direction is zero.
- Newton's law of motion is applied to forces in the horizontal direction.
- Elevation of ramp above the plane is determined from some angle theta.

Physics & Math Concepts in Simulation
- Trigonometric Functions (Sine & Cosine).
- Kinetic Friction (Fk).
- Force of Gravity (Fg, FgX, FgY).
- Normal Force (Fn).
- Newton's Second Law of Motion (F = ma).

How it Works
- JFrame initializes floor, ball, and ramp for the overall simulation.
- Program declares variables for ramp, ball, forces, and other major components.
- Demonstrates how a ball slides down a inclined ramp with different type of forces.
- Force of friction acts in the opposite direction slowing down the motion of the ball.
- Net force in vertical and horizontal direction update the position of ball.
- Models a free-body diagram for all forces acting on the ball from programming.

Requirements
- Java (JDK or higher).
- IDE (e.g., VS Code, Eclipse, or IntelliJ).

How to Run
- Copy the code into a Java file named "InclinedPlaneSimulation.java".
- Compile the program: "javac InclinedPlaneSimulation.java".
- Run the program: "java InclinedPlaneSimulation".