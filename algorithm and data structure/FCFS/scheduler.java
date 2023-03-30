package com.ASD.FCFS;
import java.util.Scanner;

class nodeQ {
    Object data;
    nodeQ next;
    nodeQ prev;

    nodeQ (Object data ){
        this.data = data;
    }
}

class qll {
    nodeQ front;
    nodeQ rear;
    int size = 0;


    public Object makeEmpty(){
        if (front == null || rear == null){
            System.out.println("already");
            return null;
        }
        front = rear = null;
        return null;
    }

    public void enque(Object data){
        nodeQ newNode = new nodeQ(data);
        if (front == null || rear == null){
            front = rear = newNode;
            
        }else{
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;

        
        
    }

    public void deque(){
        if (front == null || rear == null){
            System.out.println("empty");
            return;

        }

        nodeQ p = front;
        front = p.next;
        front.prev = null;
        size--;
    
    }

    public void peek(){
        if (front == null || rear == null){
            System.out.println("empty");
            return;
        }
        System.out.println("front : " + front.data);
        System.out.println("rear  : " + rear.data);

    }



    public void printDone(int x){
        nodeQ currentNode = front;
        for (int i = 0; i < x; i++) {
            if(currentNode == null){
                break;
            }
            System.out.println("task " + currentNode.data + " done");
            currentNode = currentNode.next;
            deque();
        }
    }

    public void printLeft(){
        nodeQ currentNode = front;
        System.out.println("task left : ");
        while (currentNode != null){
            System.out.println("task " + currentNode.data);
            currentNode = currentNode.next;
            deque();
        }
    }

    public int getSize (){
        return size;
    }
    
}


public class scheduler {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        qll test = new qll();

        int x = input.nextInt();
        input.nextLine();
            
        for (;;){
            String thread = input.nextLine();    
            
            if (thread.equals("START")){
                int threadLeft = 0;
                if(test.getSize() == x){
                    threadLeft = 0;
                    
                }else{
                    threadLeft = (x - test.getSize());
                }
                test.printDone(x);
                System.out.println(threadLeft + " idle thread");

            }else if (thread.equals("DONE")){
                test.printLeft();
                break;

            }else{
                test.enque(thread);
            }
            
        }
     
    }
}
   
