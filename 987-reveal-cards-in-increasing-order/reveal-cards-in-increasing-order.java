class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        Arrays.sort(deck);
        Queue<Integer> q=new LinkedList<>();
        for(int i=n-1;i>=0;i--){
            if(!q.isEmpty()){
                q.offer(q.poll());
            }
            q.offer(deck[i]);
        }
        int [] res =new int [n];
        for(int i=n-1;i>=0;i--){
            res[i]=q.poll();

        }
        return res;
    }
}