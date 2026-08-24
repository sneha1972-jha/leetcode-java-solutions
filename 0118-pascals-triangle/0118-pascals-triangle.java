class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();
            long value = 1;

            for (int j = 0; j <= i; j++) {

                row.add((int) value);

                value = value * (i - j) / (j + 1);
            }

            ans.add(row);
        }

        return ans;
    }
}