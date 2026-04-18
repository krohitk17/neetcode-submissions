class Solution {

    public String encode(List<String> strs) {
        int n = strs.size();
        StringBuilder builder = new StringBuilder(2*n);
        for (int i = 0; i < n; i++) {
            builder.append(strs.get(i).length() + (i < n-1 ? "," : "|"));
        }
        for (String s : strs) builder.append(s);
        System.out.println(builder.toString());
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> sol = new ArrayList<>();
        if (str.length() == 0) return sol;
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while (str.charAt(i) != '|') {
            int start = i;
            while (str.charAt(i) != ',' && str.charAt(i) != '|') i++;
            sizes.add(Integer.parseInt(str.substring(start, i)));
            if (str.charAt(i) != '|') i++;
        }
        System.out.println(sizes);
        i++;
        for (int size : sizes) {
            sol.add(str.substring(i, i+size));
            i += size;
        }
        System.out.println(sol);
        return sol;
    }
}
