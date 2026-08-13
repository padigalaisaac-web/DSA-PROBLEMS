class Solution {

    class Node {
        int left, right;
        int prefix, suffix, max;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
            this.prefix = 1;
            this.suffix = 1;
            this.max = 1;
        }
    }

    char[] s;
    Node[] tree;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        this.s = s.toCharArray();

        int n = s.length();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            this.s[index] = ch;

            update(1, 0, n - 1, index);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    private void build(int node, int left, int right) {

        tree[node] = new Node(left, right);

        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        merge(node);
    }

    private void update(int node, int left, int right, int index) {

        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, right, index);
        }

        merge(node);
    }

    private void merge(int node) {

        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];
        Node current = tree[node];

        current.prefix = left.prefix;
        current.suffix = right.suffix;

        current.max = Math.max(left.max, right.max);



        if (s[left.right] == s[right.left]) {

            current.max = Math.max(
                current.max,
                left.suffix + right.prefix
            );

            int leftLength = left.right - left.left + 1;
            int rightLength = right.right - right.left + 1;

            if (left.prefix == leftLength) {
                current.prefix = leftLength + right.prefix;
            }

            if (right.suffix == rightLength) {
                current.suffix = rightLength + left.suffix;
            }
        }
    }
}


        
    
