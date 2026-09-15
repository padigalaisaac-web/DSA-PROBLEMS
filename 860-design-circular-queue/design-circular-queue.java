class MyCircularQueue {
    int [] cq;
 int size;
 int front;
 int currsize;
    public MyCircularQueue(int k)
     {
        cq=new int[k];
        size=k;
        front=0;
        currsize=0;

    }
    
    public boolean enQueue(int value) {
        if(isFull())
        return false;
        else{
            int rear=(front+currsize)%size;
            cq[rear]=value;
            currsize++;
            return true;

        }
    }
    
    public boolean deQueue() {
         if(isEmpty())
        return false;
        else{
            cq[front]=0;
            front=(front+1)%size;

            currsize--;
            return true;
            
        }
    }
    
    public int Front() {
        if(isEmpty())
        return -1;
        else
        return cq[front];
    }
    
    public int Rear() {
        if(isEmpty())
        return -1;
        else
        {
            int rear=(front+currsize-1)%size;
            return cq[rear];
        }
    }
    
    public boolean isEmpty() {
        return currsize==0;
    }
    
    public boolean isFull() {
        return currsize==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */