package SJF;
import java.util.*;

public class SJF {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get number of processes from user
        System.out.print("Enter number of processes: ");
        int numProcesses = scanner.nextInt();

        // Get burst time for each process from user
        int[] burstTimes = new int[numProcesses];
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Enter burst time for process " + (i+1) + ": ");
            burstTimes[i] = scanner.nextInt();
        }

        // Sort burst times in ascending order
        int[] sortedBurstTimes = Arrays.copyOf(burstTimes, numProcesses);
        Arrays.sort(sortedBurstTimes);

        // Initialize variables
        int currentTime = 0;
        boolean[] finished = new boolean[numProcesses];
        int numFinished = 0;

        // Execute processes using shortest job first scheduling
        while (numFinished < numProcesses) {
            int shortestJobIndex = -1;
            for (int i = 0; i < numProcesses; i++) {
                if (!finished[i] && (shortestJobIndex == -1 || burstTimes[i] < burstTimes[shortestJobIndex])) {
                    shortestJobIndex = i;
                }
            }
            currentTime += burstTimes[shortestJobIndex];
            finished[shortestJobIndex] = true;
            numFinished++;
            System.out.println("Process " + (shortestJobIndex+1) + " finished at time " + currentTime);
        }
    }
}