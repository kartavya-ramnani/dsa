package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Process {
    int start;
    int end;
    int load;

    Process(int start, int end, int load) {
        this.start = start;
        this.end = end;
        this.load = load;
    }
}

// We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
// Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
// Jobs: [[1,4,3], [2,5,4], [7,9,6]]
// Output: 7
// Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
// jobs are running at the same time i.e., during the time interval (2,4).
public class MaximumCPULoad {

    public static int findMaxCPULoad(ArrayList<Process> processes) {

        if (processes == null || processes.size() == 0) {
            return 0;
        }
        int maxLoad = 0;
        int currentLoad = 0;
        PriorityQueue<Process> minHeap = new PriorityQueue<>(processes.size(), Comparator.comparingInt(a -> a.end));

        for (Process process : processes) {
            while (!minHeap.isEmpty() && process.start >= minHeap.peek().end) {
                Process removeProcess = minHeap.poll();
                currentLoad -= removeProcess.load;
            }
            minHeap.offer(process);
            currentLoad += process.load;
            maxLoad = Integer.max(maxLoad, currentLoad);
        }

        return maxLoad;

    }


    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>(Arrays.asList(new Process(1, 4, 3), new Process(2, 5, 4),
                new Process(7, 9, 6)));
        int rooms = MaximumCPULoad.findMaxCPULoad(processes);
        System.out.println("Max Load  : " + rooms);
    }

}
