class MinStack 
{
    private Deque<int[]> s;

    public MinStack() 
    {
        s = new ArrayDeque<>();
    }
    
    public void push(int value) 
    {
        if (s.isEmpty()) 
        {
            s.push(new int[]{value, value});
        }
        else 
        {
            int minval = Math.min(value, s.peek()[1]);
            s.push(new int[]{value, minval});
        }
    }
    
    public void pop() 
    {
        s.pop();
    }
    
    public int top() 
    {
        return s.peek()[0];
    }
    
    public int getMin() 
    {
        return s.peek()[1];
    }
}