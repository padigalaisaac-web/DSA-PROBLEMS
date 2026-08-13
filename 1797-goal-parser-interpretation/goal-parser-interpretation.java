class Solution {
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                result.append('G');
            } else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                result.append('o');
                i++;
            } else if (command.charAt(i) == '(') {
                result.append("al");
                i += 3; // skip "(al)"
            }
        }

        return result.toString();
    }
}
