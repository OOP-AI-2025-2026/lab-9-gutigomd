package ua.opnu;

import java.util.*;

public class Task {

    public static void main(String[] args) {
    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() <= second.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            String element = list.get(i);
            list.add(i, element);
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String first = list.get(i);
            String second = list.get(i + 1);

            list.set(i, second);
            list.set(i + 1, first);
        }
    }

    public void removeDuplicates(List<String> list) {
        if (list.isEmpty()) return;

        for (int i = 0; i < list.size() - 1; ) {
            String current = list.get(i);
            String next = list.get(i + 1);

            if (current.equals(next)) {
                list.remove(i + 1);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) return true;

        Stack<Integer> stack = new Stack<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            stack.push(n);
            queue.add(n);
        }

        boolean isPalindrome = true;

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            int s = stack.pop();

            if (n != s) {
                isPalindrome = false;
            }

            queue.add(n);
        }

        return isPalindrome;
    }

    public void reorder(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n < 0) {
                stack.push(n);
            } else {
                queue.add(n);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n % 2 == 0) {
                queue.add(n);
            } else {
                stack.push(n);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < size; i++) {
            int n = queue.remove();
            if (n % 2 == 0) {
                queue.add(n);
            } else {
                stack.push(n);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> values = new HashSet<>();
        for (String value : map.values()) {
            if (!values.add(value)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer val1 = entry.getValue();

            if (map2.containsKey(key)) {
                Integer val2 = map2.get(key);
                if (Objects.equals(val1, val2)) {
                    result.put(key, val1);
                }
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) throw new NoSuchElementException("Map is empty");

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer value : map.values()) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        int resultValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (count < minCount) {
                minCount = count;
                resultValue = value;
            } else if (count == minCount) {
                if (value < resultValue) {
                    resultValue = value;
                }
            }
        }

        return resultValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer n : list) {
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        int max = 0;
        for (int count : counts.values()) {
            if (count > max) {
                max = count;
            }
        }

        return max;
    }
}