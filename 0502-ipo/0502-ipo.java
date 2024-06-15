class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Create an array of projects where each project is a pair (capital, profit)
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        // Sort the projects based on the required capital
        Arrays.sort(projects, Comparator.comparingInt(p -> p.capital));

        // Max-heap to keep track of maximum profits
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int currentCapital = w;
        int index = 0;

        for (int i = 0; i < k; i++) {
            // Add all projects that can be started with the current capital to the max-heap
            while (index < n && projects[index].capital <= currentCapital) {
                maxHeap.add(projects[index].profit);
                index++;
            }

            // If there are no projects that can be started, break the loop
            if (maxHeap.isEmpty()) {
                break;
            }

            // Pick the project with the maximum profit
            currentCapital += maxHeap.poll();
        }

        return currentCapital;
    }

    // Helper class to store project information
    class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
}