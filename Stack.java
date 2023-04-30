//class Stack{
//   public int topIndex;
//   private static final int MAX_SIZE = 30;
//   public Position [] stack = new Position[MAX_SIZE];
//   
//   constructor for a new stack
//   public Stack(){
//      topIndex = 0;
//   }//stack
//   
//   push a new char on stack
//   public void push(Position c){
//     if(topIndex < MAX_SIZE){
//      stack[topIndex] = c;
//      topIndex++;
//     }
//   }//push
//   
//   pop the top element from stack
//   public Position pop(){
//     System.out.print(peek() + " ");
//     if(topIndex>0)
//      return stack[--topIndex];
//     else
//       return null;
//   }//pop
//   
//   peek at the top element in the stack
//   public Position peek(){
//     if(topIndex > 0)
//      return stack[topIndex-1];
//     else
//       return null;
//   }//peek
//   
//   check if stack is empty
//   public boolean isEmpty(){
//      return (topIndex == 0);
//   }//isEmpty
//}//Stack