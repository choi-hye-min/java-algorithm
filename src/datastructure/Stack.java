package datastructure;

public class Stack {

    public static class StackData{
        private Object[] stackData;
        private int position = -1;

        public StackData(int size) {
            this.stackData = new Object[size];
        }

        public void push(int val){
            stackData[++position] = val;
        }

        public Object pop(){
            isEmpty();
            return stackData[position--];
        }

        public Object peek(){
            isEmpty();
            return stackData[position];
        }

        private void isEmpty() {
            if(position == -1){
                throw new ArrayIndexOutOfBoundsException("Stack Size Empty!");
            }
        }
    }


    public static void main(String[] args){
        StackData stack = new StackData(5);
        stack.push(5);
        stack.push(3);
        stack.push(8);

        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
