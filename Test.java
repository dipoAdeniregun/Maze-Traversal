Position p1 = new Position(2,1,Path.PATH);
    Position p2 = new Position(1,1,Path.WALL);
    Position p3 = new Position(1,1,Path.START);
    Position p4 = new Position(1,1,Path.FINISH);
    
    
    System.out.println("p1: " + p1.printPathCoord() + " " + p1.printPath());
    System.out.println("p2: " + p2.printPathCoord() + " " + p2.printPath());
    System.out.println("p3: " + p3.printPathCoord() + " " + p3.printPath());
    System.out.println("p4: " + p4.printPathCoord() + " " + p4.printPath());
    
    Stack s1 = new Stack();
    System.out.println("Is the stack empty? " + s1.isEmpty());
    s1.push(p1);
    System.out.println("Is the stack empty? " + s1.isEmpty());
    System.out.println(s1.peek());
    s1.push(p2);
    s1.push(p3);
    s1.push(p4);
    System.out.println(s1.pop());
    System.out.println(s1.pop());
    System.out.println(s1.pop());
    System.out.println(s1.pop());
    System.out.println("Is the stack empty? " + s1.isEmpty());
    System.out.println(s1.pop());
    
    Queue q1 = new Queue();
    System.out.println("Making new empty queue...");
    System.out.println("\nIs the Queue empty? " + q1.isEmpty());
    q1.enqueue(p1);
    System.out.println("Adding to queue...");
    System.out.println("Is the Queue empty? " + q1.isEmpty());
    System.out.println("Peeking...");
    System.out.println(q1.peek());
    System.out.println("Adding to queue...");
    q1.enqueue(p2);
    System.out.println("Adding to queue...");
    q1.enqueue(p3);
    System.out.println("Adding to queue...");
    q1.enqueue(p4);
    System.out.println("Removing from queue...");
    System.out.println(q1.dequeue());
    System.out.println("Removing from queue...");
    System.out.println(q1.dequeue());
    System.out.println("Removing from queue...");
    System.out.println(q1.dequeue());
    System.out.println("Removing from queue...");
    System.out.println(q1.dequeue());
    System.out.println("Is the Queue empty? " + q1.isEmpty());
    System.out.println("Removing from queue...");
    System.out.println(q1.dequeue());
    System.out.println("Is the Queue empty? " + q1.isEmpty());
    
    Maze m1 = new Maze("maze1.txt");
    System.out.println(m1);
    int[] start = m1.findStartOrFinish(Path.START);
    System.out.println("Start = [" + start[0] + ", " + start[1] + "]");
    
    
    
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 7; j++){
        System.out.println("Cecking neighbours for (" + i + ", " + j + ")");
        Position[] validNeighbour = m1.validNeighbours(i,j);
        int k = 0;
        while(validNeighbour[k] != null){
          System.out.print(validNeighbour[k++]);
        }//while
        System.out.println("");
      }
    }
    
    System.out.println(m1.queueSearch());
    System.out.println(m1.maze[2][1].visited);
    m1.resetMaze();
    System.out.println(m1.maze[2][1].visited);