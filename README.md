# Game-of-Dice
Game of Dice Simulator

1. Build and run through Ant:-

Program take two cmd line args : 

players => integer value denotes how many players are playing.

maxPoints => integer value denotes points to accumulate.

Cmd to run(Example): 

      ant compile jar -Dplayers=3 -DmaxPoints=20 run









2. Run executable jar directly :-

Find the jar GameOfDice.jar @ ~/build/jar
Run following cmd(Example): 

    java -cp GameOfDice.jar com.him.github.game.GameOfDice 3 20
