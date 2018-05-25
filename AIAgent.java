import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Stack;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class AIAgent{
  Random rand;


  public AIAgent(){
    rand = new Random();
  }

/*
  The method randomMove takes as input a stack of potential moves that the AI agent
  can make. The agent uses a rondom number generator to randomly select a move from
  the inputted Stack and returns this to the calling agent.
*/

public Move AgentPicked(int picked,Stack possibilities, Stack possibilitiesBlack, int moveID){
  Move selectedMove = new Move();
  if(picked==0){
    selectedMove = randomMove(possibilities, moveID);
    return selectedMove;
  }
  else if(picked==1){
    selectedMove = nextBestMove(possibilities, possibilitiesBlack);
    return selectedMove;
  }
  else{
    selectedMove = twoLevelsDeep(possibilities);
    return selectedMove;
  }
}

  public Move randomMove(Stack possibilities, int moveID){

    // int moveID = rand.nextInt(possibilities.size());
    System.out.println("Agent randomly selected move : "+moveID);
    for(int i=1;i < (possibilities.size()-(moveID));i++){
      possibilities.pop();
    }
    Move selectedMove = (Move)possibilities.pop();
    return selectedMove;
  }
// nextBestMove will make a move with the highest value if there is no moves available it will make a random move
  public Move nextBestMove(Stack possibilities, Stack possibilitiesBlack){
    Stack white = (Stack) possibilities.clone();//clone the Initial Stack to allow for randomMove later on if no move of value is found
    int moveID = rand.nextInt(possibilities.size());
    int value = 0;
    Move selectedMove= null;
    System.out.println("Agent picked the best piece to take");
    while(0<(white.size())){// move through the stack to check the value of each move being made
    Move move = (Move) white.pop();
    if(!(white.size()==1)){
      if((value) < (move.getPoints())){
        value = move.getPoints();
        selectedMove = move;
      }
    }
    if((white.size()==1)&&value==0){
      for(int i=1;i < (possibilities.size()-(moveID));i++){
        possibilities.pop();
      }
      Move random = (Move)possibilities.pop();
      selectedMove = random;
    }
  }
  return selectedMove;
}

  public Move twoLevelsDeep(Stack possibilities){
    Move selectedMove = new Move();
    return selectedMove;
  }
}
