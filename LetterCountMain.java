import java.util.*;

class LetterCountMain {

    public static String LetterCount(String str) {

        String[] words = str.split(" ");

        Map<String, Integer> maxOccurs = new TreeMap<>();

        for (String word : words) {
            Map<Integer, Integer> count = new HashMap<>();
            word.chars().forEach(c -> count.put(c, count.getOrDefault(c, 0) + 1));
            Optional<Map.Entry<Integer, Integer>> maxEntry = count.entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue));
            int value = maxEntry.get().getValue();
            if (value == 1) {
                value = -1;
            }
            maxOccurs.put(word, value);
        }

        Integer maxValue = Collections.max(maxOccurs.values());

        // zla kolejnosc
        //List<String> collect = maxOccurs.entrySet().stream().filter(e -> e.getValue() == maxValue).map(e -> e.getKey()).collect(toList());
        //System.out.println(collect);

        for (Map.Entry<String, Integer> w : maxOccurs.entrySet()) {
            System.out.println(w.getKey() + " " + w.getValue());
            if (w.getValue().equals(maxValue)) {
                return w.getKey();
            }
        }

        return "-1";
    }

    public static void main(String[] args) {
        // keep this function call here

        System.out.print(LetterCount("Hello apple pie"));
    }

}
