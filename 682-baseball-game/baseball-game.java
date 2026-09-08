class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> rec= new Stack<>();
        for(String op: operations){
            if(op.equals("+")){
                int ls=rec.pop();
                int sls=rec.peek();
                rec.push(ls);
                rec.push(ls+sls);
            }
            else if(op.equals("D")){
                rec.push(rec.peek()*2);

            }
            else if(op.equals("C"))
            rec.pop();
            else
            {
                rec.push(Integer.parseInt(op));
            }

        }
        int t=0;
        while(!rec.isEmpty()){
            t+=rec.pop();
        }
        return t;
    }
}