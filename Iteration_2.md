# **CMPT276-1231-D2-xray**

## Completed user stories and TDDs:

### User Story: 
### Novice User
As a novice user I want to have a clickable word bank to tap the words in one language and fill them in the puzzle with the other language so that I can easily fill in the puzzle on a mobile device.

### TDD Examples:
When playing the game, there will be 9 buttons under the sudoku puzzle each with one word. When the user wants to change their answer in a cell, the user clicks on that cell and then click on another word in the word bank. If the user wants to remove an answer in a cell, they click on that cell and then click on the clear button next to the word bank to clear the word from that cell.

<!-- <img src="images/Novice_User_-_Filling_in_Puzzle_-_1.png" height="500" alt="Novice User- Fill in Puzzle 1">
<img src="images/Novice_User_-_Filling_in_Puzzle_-_2.png" height="500" alt="Novice User- Fill in Puzzle 2"> 
<img src="images/Novice_User_-_Filling_in_Puzzle.png" height="500" alt="Novice User- Fill in Puzzle 2">-->
<p float="left">
  <img src="images/Select_Cell.png" height ="500" />
  <img src="images/Select_Answer.png" height ="500" /> 
  <img src="images/Clear_Button.png" height ="500"
</p>

#

### User Story: 
### Novice User
As a novice user, I want to be able to check my puzzle solving progress so that I can get feedback on certain words and improve my Sudoku-solving ability. 

### TDD Examples:
At any point in the game, you can finish the puzzle by pressing the checkmark icon in the top right corner. The program will take you to the main menu page, and create a toast saying "Well done! Thanks for playing!" if all the cells are filled and the answer is correct. Otherwise, the program will create a toast saying "The puzzle is not correct!".

<p float="left">
  <img src="images/Submit_Finished.png" height ="500" /> 
  <img src="images/Submit_Unfinished.png" height = "500" />
</p>

#



### User Story: 
### Beginner Language Learner
As a beginner language learner I want to choose pre-set word lists to expose myself to the new language so that I can be introduced to common related words.

### TDD Examples:
When the user clicks to enter a game from the main menu, they can select the "Easy" difficulty by clicking a button which will display several preset categories of basic vocabularies (ex. numbers, pronouns, foods, animals etc.) in which the user can choose by clicking a button that is corresponding to the categories.

<img src="images/Generate_Puzzle.png" height="500" alt="Beginner Language Learner">

When a user taps a filled in cell on the Sudoku game board or a word in the wordbank, a toast of the translation of the word in that cell in the opposing language will be displayed in the space on top of the board.

<!-- <img src="images/Beginner_Language_Learner_-_1.png" height="500" alt="Beginner Language Learner 1">
<img src="images/Beginner_Language_Learner_-_2.png" height="500" alt="Beginner Language Learner 2"> -->

<p float="left">
  <img src="images/Translate_Unfilled.png" height ="500" > 
  <img src="images/Translate_Filled.png" height ="500" > 
  <img src="images/Translate_Board_Cell.png" height ="500" > 
</p>

#

## To be implemented user stories and TDDs
 
### User Story: 
### Novice User
As a novice user, I want to be able to check my puzzle solving progress so that I can get feedback on certain words and improve my Sudoku-solving ability. 

### TDD Examples:
At any point in your game, you can click on a cell with an answer filled in and click the lightbulb on the top right corner. The game will check that cell and then highlight red if the answer is wrong or green if the answer is correct. The user can use this 3 times.

<!-- <img src="images/Novice_User_-_Check_-_1.png" height="500" alt="Novice User- Check 1">
<img src="images/Novice_User_-_Check_-_2.png" height="500" alt="Novice User- Check 2"> -->

<img src="images/Novice_User_-_Check.png" height="500" alt="Novice User- Check">

#

### User Story: 
### Expert User
As an expert user, I want the option to solve more difficult sudoku puzzles so that I can challenge my problem thinking skills without raising the difficulty of words.

### TDD Examples:
The user opens the application and clicks the enter game button from the main menu. After, they are prompted with a menu screen that has preset categories of basic vocabularies (ex. numbers, pronouns, foods, animals etc.) in which the user can select their desired category to play the game in. After that, the user can select their word difficulty and select “hard” for the puzzle difficulty. If choices aren’t made for all three options, a toast will pop up encouraging the user to do so, and will not generate a puzzle until doing so.

<!-- <img src="images/Expert_User_-_1.png" height="500" alt="Expert User 1">
<img src="images/Expert_User_-_2.png" height="500" alt="Expert User 2"> -->

<img src="images/Generate_Puzzle_Error.png" height="500" >

#

### User Story:
### Intermediate Language Learner
As an intermediate language learner, I want to be able to have puzzles made from randomized pre-existing word lists so that I can practice thinking in the language I’m learning and therefore strengthen my knowledge of these words.

### TDD Examples:
When the user clicks to enter a game from the main menu, they can select the "Normal" difficulty by clicking a button which will generate a puzzle with a word bank that consists of vocabularies that are randomly chosen and mixed from the categories available in the "Easy" difficulty.

<!-- <img src="images/Intermediate_Language_Learner_-_1.png" height="500" alt="Intermediate Language User 1">
<img src="images/Intermediate_Language_Learner_-_2.png" height="500" alt="Intermediate Language User 2"> -->

<img src="images/Intermediate_Language_Learner.png" height="500" alt="Intermediate Language User">

#

### User Story:
### Expert Language Learner
As an expert language learner, I want to be able to solve Sudoku puzzles without a word bank and type the words in French so that I can push my French knowledge even further by remembering their spelling.

### TDD Examples:
When a user is generating a new puzzle and selects “Hard” difficulty from the language difficulty setting, all nine words will be on the puzzle at least once and the user will add words to the puzzle by typing them in the other language.

For example, when the user selects a Sudoku square to add a word, a typing box with keyboard pops up to type the word in French, which will not accept the response unless it’s properly spelled and the correct translation to one of the nine English words in the word bank. When the user is finished typing a word, it will fill the Sudoku square with the English word. If the word is spelled incorrectly or not a match, a toast will pop up encouraging the user to retry/re-spell the word.

<!-- <img src="images/Expert_Language_Learner_-_1.png" height="500" alt="Expert Language Learner-Correct 1">
<img src="images/Expert_Language_Learner_-_2.png" height="500" alt="Expert Language Learner-Correct 2">

<img src="images/Expert_Language_Learner_-_Incorrect_-_1.png" height="500" alt="Expert Language Learner-Incorrect 1">
<img src="images/Expert_Language_Learner_-_Incorrect_-_2.png" height="500" alt="Expert Language Learner-Incorrect 2"> -->

<img src="images/Expert_Language_Learner.png" height="500" alt="Expert Language Learner-Correct">

<img src="images/Expert_Language_Learner_-_Incorrect.png" height="500" alt="Expert Language Learner-Incorrect">
#

### User Story:
### Language Teacher
As a language teacher I want my students to be able to choose different language modes to select between English and French to pick words and fill in the puzzle so that my language students can interact with the French language in different dynamic ways that suit their preferences.

### TDD Examples:
When a user is generating a new puzzle, they can choose between two buttons “English/French” for the “Language Mode”, which will be the language for the word bank. If a user selects “English” for “Language Mode”, the word bank will contain English words for beginner and intermediate language levels; advanced doesn’t have a word bank. The user will tap on / type an English word then tap a Sudoku square to insert a word, which will be displayed in French.


<img src="images/Generate_Puzzle.png" height="500" alt="Language Teacher">


#

### User Story:
### Different Devices
As a vocabulary learner practicing at home, I want to use my tablet for Sudoku vocabulary practice, so that the words will be conveniently displayed in larger, easier to read fonts.

### TDD Examples:
After a user generates a puzzle, if the device has the display size of a tablet, the app will enlarge everything onscreen, and change the font and text size to a larger one so it is easier to read and solve.


<img src="images/Tablet_9x9.png" height="500" >


As a vocabulary learner taking the bus, I want to use my phone in landscape mode for Sudoku vocabulary practice, so that longer words are displayed in a larger font than standard mode.

### TDD Examples:
When playing on a phone in portrait mode, the user can rotate the phone sideways to put the app in landscape mode. This will put the puzzle on the left of the screen and increase the space in each cell along with the size of the text.

<p float="left">
  <img src="images/Phone_9x9_Mock.png" height ="500" > 
  <img src="images/Phone_9x9_Landscape.png" height ="500" >  
</p>
#

### User Story:
### Different Size Sudoku Grids
As a teacher of elementary and junior high school children, I want scaled versions of Sudoku that use 4x4 and 6x6 grids. In the 6x6 grid version, the overall grid should be divided into rectangles of six cells each (2x3).

As a vocabulary learner who wants an extra challenging mode, I want a 12x12 version of Sudoku to play on my tablet. The overall grid should be divided into rectangles of 12 cells each (3x4).

### TDD Examples:
When a user is generating a new puzzle, they can choose between 4 sizes: 4x4, 6x6, 9x9, 12x12. Depending on their choice the app will generate different sizes of the sudoku board and the wordbank will contain the corresponding number of words.

<p float="left">
  <img src="images/Puzzle_Size_Mock.png" height ="500" > 
  <img src="images/Phone_4x4.png" height ="500" >  
</p>

<p float="left">
  <img src="images/Puzzle_Size_Mock.png" height ="500" > 
  <img src="images/Phone_6x6.png" height ="500" >  
</p>

<p float="left">
  <img src="images/Puzzle_Size_Mock.png" height ="500" >
  <img src="images/Tablet_12x12.png" height ="500" >  
</p>

#
