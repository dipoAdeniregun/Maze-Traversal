///*****************************CLASS: POSITION***************************/
//class Position{
//  public int row;
//  public int col;
//  public Path pathType;
//  public boolean visited;
//  public Position visitedFrom;
//    
//  //constructor
//  public Position(int row, int col, Path pathType){
//    this.row = row;
//    this.col = col;
//    this.pathType = pathType;
//    visited = false;
//    visitedFrom = null;
//  }//Position
//  
//  //returns true if the position can be visited. i.e a START, FINISH or PATH
//  // path type
//  public boolean canBeVisited(){
//    return (pathType == Path.START) || (pathType == Path.FINISH) || (pathType == Path.PATH);
//  }//canBeVisited
//  
//  /*************************output functions*************************************/
//  //Return a string containing the path coordinates
//  public String printPathCoord(){
//    String s = "(";
//    s += row + ", " + col + ")";
//    return s;
//  }//printPathCoord
//  
//  /********************************************************
//   * return a string representing the path as its type. 
//   * '.' = An open space you can walk on
//   * '#' = A wall or blocked space that can't be acessed
//   * 'S' = the starting point of the maze
//   * 'F' = finish point of the maze
//   * ******************************************************/
//  public String printPath(){
//    String s;
//    switch(pathType){
//      case START:
//        s = "S";
//        break;
//      case FINISH:
//        s = "F";
//        break;
//      case PATH:
//        s = ".";
//        break;
//      case FINAL_PATH:
//        s = "*";
//        break;
//      default:
//        s = "#";
//        break;
//    }//switch
//    return s;
//  }//printPath
//  
//  public String toString(){
//    return printPath() /*+ " " + printPathCoord()*/;
//  }//toString
//}//Position
