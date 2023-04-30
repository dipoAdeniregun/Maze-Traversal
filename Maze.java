//import java.io.*;
//import java.util.Scanner;
//
//class Maze{
//  public int totalRows;
//  public int totalCols;
//  public Position [][] maze;
//  
//  //constructor
//  public Maze(String fileName){
//    fillMaze(readFile(fileName));
//  }//Maze
//  
//  //toSTring 
//  public String toString(){
//    String s = "";
//    for(int i = 0; i < totalRows; i++){
//      for(int j = 0; j < totalCols; j++){
//        s += maze[i][j];
//      }
//      s += "\n";
//    }//endfor
//    return s;
//  }//toString
//  
//  
//  /***********************************************************
//    * (input) sof: a Path enum type to choose to find either 
//    *              the start or finish tile in the maze
//    * 
//    * (output): outputs an array [row,col] of the start or finish position
//    *           in the maze
//    * 
//    * (method): find the start or finsih by examining the path type of all positions
//    *           in the maze array
//    **********************************************************/
//  public int[] findStartOrFinish(Path sof ){
//    int [] startPosition = new int[2];
//    
//    for(int i = 0; i < totalRows; i++){
//      for(int j = 0; j < totalCols; j++){
//        if(maze[i][j].pathType == sof){
//          startPosition[0] = i;
//          startPosition[1] = j;
//          i = totalRows; //to break out of top loop as well
//          break;
//        }//endif
//      }//endfor
//    }//endfor
//    return startPosition;
//  }//endStart
//  
//  
//  
//  /***********************************************************
//    * (input)row,col: the row and col index of the maze position we 
//    *                 need valid neighbours to
//    * (output): an array of all visitable postions. 
//    * (method): checks the top bottom left and right(where valid) 
//    *           neighbours to see if theyre visitable
//    **********************************************************/
//  public Position[] validNeighbours(int row, int col){
//    //using four because thats max amount of neighbours in a 2d array.
//    //could have used arrayList or Linked list but not worth the stress
//    Position [] validNeighbours = new Position[4];
//    int count = 0;
//    
//    if(col < (totalCols - 1)){
//      //System.out.println("Checking for right neighbour...");
//      if(maze[row][col+1].canBeVisited()){
//        //System.out.println("right neighbour found...");
//        validNeighbours[count++] = maze[row][col+1];
//      }
//    }//endif
//    
//    if(col > 0){
//      //System.out.println("Checking for left neighbour...");
//      if(maze[row][col-1].canBeVisited()){
//        //System.out.println("left neighbour found...");
//        validNeighbours[count++] = maze[row][col-1];
//      }
//    }//endif
//    
//    if(row > 0){
//      //System.out.println("Checking for top neighbour...");
//      if(maze[row-1][col].canBeVisited()){
//        //System.out.println("top neighbour found...");
//        validNeighbours[count++] = maze[row-1][col];
//      }
//    }//endif
//    
//    if(row < (totalRows - 1)){
//      //System.out.println("Checking for bottom neighbour...");
//      if(maze[row+1][col].canBeVisited()){
//        //System.out.println("bottom neighbour found...");
//        validNeighbours[count++] = maze[row+1][col];
//      }
//    }//endif
//    return validNeighbours;
//  }//validNeighbours
//  
//  
//  
//  /***********************************************************
//    * (output)current: outputs the final position we land on after
//    *                  running our pathfinding algorithm
//    * (method): uses a depth first pathfinding algorithm to
//    *           traverse the maze  
//    **********************************************************/
//  public Position stackSearch(){
//    int[] startIndex = findStartOrFinish(Path.START);
//    Position mazeStart = maze[startIndex[0]][startIndex[1]];
//    Stack mazeStack = new Stack();
//    
//    mazeStack.push(mazeStart);
//    mazeStart.visited = true;
//    
//    Position current = null;
//    Position [] validNeighbour;
//    int currentNeighbour;
//    while(!mazeStack.isEmpty()){
//      current = mazeStack.pop();
//      
//      
//      if(current.pathType == Path.FINISH){
//        break;
//      }//if
//      
//      validNeighbour = validNeighbours(current.row, current.col);
//      currentNeighbour = 0;
//      while(validNeighbour[currentNeighbour] != null){
//        if(validNeighbour[currentNeighbour].visited == false){
//          validNeighbour[currentNeighbour].visited = true;
//          validNeighbour[currentNeighbour].visitedFrom = current;
//          mazeStack.push(validNeighbour[currentNeighbour]);
//        }
//        currentNeighbour++;
//      }
//    }//while
//    return current;
//  }//stackMaze
//  
//  
//  
//  /***********************************************************
//    * (output)current: outputs the final position we land on after
//    *                  running our pathfinding algorithm
//    * (method): uses a breadth first pathfinding algorithm to
//    *           traverse the maze  
//    **********************************************************/
//  public Position queueSearch(){
//    int[] startIndex = findStartOrFinish(Path.START);
//    Position mazeStart = maze[startIndex[0]][startIndex[1]];
//    Queue mazeQueue = new Queue();
//    
//    mazeQueue.enqueue(mazeStart);
//    mazeStart.visited = true;
//    
//    Position current = null;
//    Position [] validNeighbour;
//    int currentNeighbour;
//    
//    boolean queueMT = mazeQueue.isEmpty();
//    while(!mazeQueue.isEmpty()){
//      queueMT = mazeQueue.isEmpty();
//      current = mazeQueue.dequeue();
//      
//      
//      if(current.pathType == Path.FINISH){
//        break;
//      }//if
//      
//      validNeighbour = validNeighbours(current.row, current.col);
//      currentNeighbour = 0;
//      while(validNeighbour[currentNeighbour] != null){
//        if(validNeighbour[currentNeighbour].visited == false){
//          validNeighbour[currentNeighbour].visited = true;
//          validNeighbour[currentNeighbour].visitedFrom = current;
//          mazeQueue.enqueue(validNeighbour[currentNeighbour]);
//        }
//        currentNeighbour++;
//      }
//    }//while
//    return current;
//  }//queueSearch
//  
//  
//  
//  /***********************************************************
//    * (method): resets our maze after using a pathFinding algorithm
//    *           by making every tile unvisited again
//    **********************************************************/
//  public void resetMaze(){
//    for(int i = 0; i < totalRows; i++){
//      for(int j = 0; j < totalCols; j++){
//        maze[i][j].visited = false;
//        maze[i][j].visitedFrom = null;
//        if(maze[i][j].pathType == Path.FINAL_PATH)
//          maze[i][j].pathType = Path.PATH;
//      }
//    }
//  }//resetMaze 
//  
//  
//  
//  /**************************************************************************
//    * (input)finalPosition: an object of class Position representing the
//    *                       last position reached after searching the maze
//    * 
//    * (output)s:  a string representing either the coordinates from start to 
//    *             finish that our search algorithm took to find its way through
//    *             the maze or a message saying a path wasn't found                     
//    * 
//    * Method:     if the finalPosition supplied isn't of Path.FINISH, we know that
//    *             the search algorithm couldnt find a path and we return an appropriate message
//    *             otherwise, we backtrack from Fiish to Start adding the coordinates to our
//    *             final return message using a stack.
//    ******************************************************************************/
//  public String finalPath(Position finalPosition){
//    String s = "";
//    if(finalPosition.pathType == Path.FINISH){
//      Stack finalPath = new Stack();
//      finalPath.push(finalPosition);
//      Position currentPos = finalPosition.visitedFrom;
//      
//      while(currentPos.pathType != Path.START){
//        finalPath.push(currentPos);
//        currentPos.pathType = Path.FINAL_PATH;
//        currentPos = currentPos.visitedFrom;
//      }//while
//      
//      s = currentPos.printPathCoord();
//      
//      while(!finalPath.isEmpty()){
//        s += " " + finalPath.pop().printPathCoord();
//      }//while
//      
//    }//if
//    else{
//      s = "No path could be found through the maze!";
//    }//else
//    
//    return s;
//  }//finalPath
//  
//  
//  
//  /*******************************HELPER METHODS*********************************/
//  
//  /***********************************************************
//    * (input)fileName: a string containingthe name of the file 
//    *                  containing our Maze in the form "fileName.txt"
//    * 
//    * (output)sc: a scanner object containing our maze filestream
//    * 
//    * (method): reads our file and sends it to the scanner within a try-catch block 
//    **********************************************************/
//  private Scanner readFile(String fileName){
//    Scanner sc = null;
//    
//    try{
//      File mazeFile = new File(fileName);
//      sc = new Scanner(mazeFile);
//    }//try
//    catch(IOException e){
//      System.out.println("Error reading file: " + e.getMessage());
//    }//catch
//    
//    return sc;
//  }//readFile
//  
//  
//  
//  /***********************************************************
//    * (input)sc : scanner containing our maze file stream
//    * 
//    * (method): read through each line of our maze file and initialize
//    *           each position in the maze array with the right path type
//    **********************************************************/
//  private void fillMaze(Scanner sc){
//    totalRows = sc.nextInt();
//      totalCols = sc.nextInt();
//      
//      String s = "";
//      
//      maze = new Position[totalRows][totalCols];
//      
//      //fill maze
//      s = sc.nextLine(); //mysterious length 0 line between first line and second line 
//      for(int i = 0; i < totalRows; i++){
//        s = sc.nextLine();
//        for(int j = 0; j < totalCols; j++){
//          switch(s.charAt(j)){
//            case 'S':
//              maze[i][j] = new Position(i,j,Path.START);
//              break;
//            case 'F':
//              maze[i][j] = new Position(i,j,Path.FINISH);
//              break;
//            case '.':
//              maze[i][j] = new Position(i,j,Path.PATH);
//              break;
//            default:
//              maze[i][j] = new Position(i,j,Path.WALL);
//              break;
//          }//switch
//        }//endfor
//      }//endfor
////    try{
////      
////      
////    }//try
////    catch(Exception e){
////      System.out.println("Error building maze from file: " + e.getMessage());
////    }//catch
//  }//fillMaze
//  
//}//Maze