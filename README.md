# Horse Race Simulator

This project implements a horse race simulation with both textual and graphical versions, as specified for the ECS414U Object-Oriented Programming course.

## Setup Instructions

1. **Install Java**: Ensure you have Java 17 or later installed. Download from [Oracle JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
2. **Install JavaFX**: Download JavaFX SDK from [Gluon](https://gluonhq.com/products/javafx/). Set up as per their instructions.
3. **Clone Repository**: Clone or unzip the `HorseRaceSimulator` directory.
4. **Compile**: Use command-line tools to compile the project:
   - For Part 1: `cd Part1; javac *.java`
   - For Part 2: `cd Part2; javac --module-path /path/to/javafx/lib --add-modules javafx.controls *.java`

## Running the Textual Version
- Navigate to `Part1/`.  cd Part1
- Run: `java Race` 
- The simulation will display a command-line race with horses moving and a winner announced.
- 

## Running the Graphical Version
- Navigate to `Part2/`.
- Run: `java --module-path /path/to/javafx/lib --add-modules javafx.controls RaceGUI`
- A GUI window will open, allowing track configuration and race simulation.

## Dependencies
- Java 17+
- JavaFX SDK for Part 2

## Notes
- Ensure the `.git/` directory is included in the submission.
- The project is IDE-agnostic and runs via command-line tools.
