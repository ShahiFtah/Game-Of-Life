# Conway's Game of Life - Java Implementation

This repository contains an implementation of Conway's Game of Life in Java, developed as part of the IN1010 course (Spring 2023). The program simulates the evolution of cells on a grid where each cell can be alive or dead, and its future state is determined by the number of living neighbors it has.

## Purpose
This project was originally implemented in Python for IN1000 but has now been rewritten in Java as part of the IN1010 course. The goal is to deepen the understanding of object-oriented programming and simulation techniques.

## Features
- **Generational Evolution**: The simulation progresses through multiple generations according to Conway's rules.
- **User Interaction**: The user can observe the grid as it updates generation by generation.
- **Dynamic Grid**: The simulation works on a configurable grid size, where each cell is either "alive" or "dead" based on its neighbors.

## Game of Life Rules
- A live cell with fewer than two live neighbors dies (underpopulation).
- A live cell with two or three live neighbors survives.
- A live cell with more than three live neighbors dies (overpopulation).
- A dead cell with exactly three live neighbors becomes alive (reproduction).

## File Structure
- **Celle.java**: Defines the `Celle` class, handling the state of individual cells.
- **Rutenett.java**: Manages the grid of cells and their interactions.
- **Verden.java**: Controls the simulation, tracking generations and updating cell states.
- **GameOfLife.java**: The main program that initializes the simulation and allows user interaction.

## How to Run
1. Compile all `.java` files:
   ```sh
   javac *.java
   ```
2. Run the main program:
   ```sh
   java GameOfLife
   ```

## Source
For more details on Conway's Game of Life, visit [Wikipedia](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).
