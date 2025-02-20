//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends

class Solution {
    // Max heap to store the smaller half of the numbers
    private PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);
    // Min heap to store the larger half of the numbers
    private PriorityQueue<Integer> minheap = new PriorityQueue<>();

    // Function to insert a number into the heaps and balance them
    private void insertHeap(int x) {
        if (maxheap.isEmpty() || x <= maxheap.peek()) {
            maxheap.add(x);
        } else {
            minheap.add(x);
        }
        balanceHeaps();
    }

    // Function to balance the heaps
    private void balanceHeaps() {
        int diff = Math.abs(maxheap.size() - minheap.size());
        if (diff > 1) {
            if (maxheap.size() > minheap.size()) {
                minheap.add(maxheap.poll());
            } else {
                maxheap.add(minheap.poll());
            }
        }
    }

    // Function to calculate the current median
    private double getMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        } else {
            if (maxheap.size() > minheap.size()) {
                return maxheap.peek();
            } else {
                return minheap.peek();
            }
        }
    }

    // Function to process the array and return medians after each insertion
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> medians = new ArrayList<>();
        for (int num : arr) {
            insertHeap(num); // Insert the current number into the heaps
            medians.add(getMedian()); // Calculate and store the current median
        }
        return medians;
    }
}