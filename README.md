## 🔹 ForgeCraft
_A fantasy blacksmith simulation game built in Java._

ForgeCraft is a text-based crafting and customer-service simulation game where the player takes on the role of a novice blacksmith in the kingdom of Aetheria. Players must fulfill customer weapon and armor requests by selecting the correct item, choosing the correct material, and refining the crafted equipment through a skill-based forging system.

The game combines object-oriented programming, randomized gameplay, score tracking, user interaction, and decision-making mechanics into a complete playable experience.

## 🔹 ForgeCraft simulates the daily life of a fantasy blacksmith.
Each in-game day, customers enter the player’s forge and request custom-crafted weapons, armor, or tools. The player must:

* Accept or reject customer requests
* Choose the correct item to forge
* Select the requested material
* Complete a refinement mini-game to determine item quality
* Earn points based on crafting accuracy and craftsmanship

The better the crafted item matches the customer’s request, the higher the score reward. Incorrect orders or rejected customers lower the player’s performance and overall score.

The game continues day-by-day until the player decides to stop.

## 🔹 ForgeCraft is designed for players who enjoy:
* Fantasy-themed games
* Strategy and decision-making mechanics
* Text-based simulation games
* Resource and management gameplay
* Games similar to ones from the Papa Louie franchise

## 🔹 How to Run the Program
**Requirements**
* Java JDK 17+ (or compatible version)
* IntelliJ IDEA, Eclipse, or any Java IDE
**Running the Program**
1. Clone the repository:
```git clone https://github.com/<your-username>/ForgeCraft.git```
2.) Open the project in your preferred Java IDE
3.) Compile the program
4.) Run:
```Game.java```
5.) Follow the on-screen prompts to play

## 🔹 Technical Overview
Brief description of:
**Main Classes**
* Game - Controls the primary gameplay loop, score tracking, customer flow, and day progression.
* Customer - Represents NPC customers visiting the forge.
* Craft - Handles all crafting mechanics and gameplay systems.
* Item - Represents crafted equipment produced by the player.
**Key Data Structures**
* Arrays - Arrays are heavily used throughout the program for:
  > - Weapon lists
  > - Material lists
  > - Dialogue generation
  > - Random customer generation
  
**Program Logic:**
The program follows a structured gameplay loop:

  Start Day
      ↓
  Generate Customers
      ↓
  Accept/Reject Order
      ↓
  Craft Item
      ↓
  Refinement Mini-Game
      ↓
  Check Accuracy
      ↓
  Award Score
      ↓
  Next Customer
      ↓
  End Day/New Day

## 🔹 Class Diagram
<img width="451" height="511" alt="ForgeCraftDiagram2NEW drawio" src="https://github.com/user-attachments/assets/dbdd98b7-8f1c-4df9-a8d1-4755170400bc" />

## 🔹 Known Limitations / Future Improvements
**Limitations:**
  - Text-based interface only.
  - No save/load functionality.
  - Linear and limited progression system.
  - No inventory or economy system.
  - Customers are fully randomized.
  - Scanner objects could be optimized furthermore.

**Future Improvements:**
  * Player inventory system
  * Currency/shop mechanics
  * Kingdom reputation system
  * NPC storylines and quests
  * Difficulty scaling over time
  * Unique, preset customers.
