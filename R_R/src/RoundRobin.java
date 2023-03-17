import java.util.*;

public class RoundRobin {

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

        // Get time quantum from user
        System.out.print("Enter time quantum: ");
        int quantum = scanner.nextInt();

        // Initialize variables
        int[] remainingTimes = Arrays.copyOf(burstTimes, numProcesses);
        int currentTime = 0;
        boolean[] finished = new boolean[numProcesses];
        int numFinished = 0;

        // Execute processes using round robin scheduling
        while (numFinished < numProcesses) {
            boolean found = false;
            for (int i = 0; i < numProcesses; i++) {
                if (!finished[i] && remainingTimes[i] > 0) {
                    found = true;
                    if (remainingTimes[i] <= quantum) {
                        currentTime += remainingTimes[i];
                        remainingTimes[i] = 0;
                        finished[i] = true;
                        numFinished++;
                        System.out.println("Process " + (i+1) + " finished at time " + currentTime);
                    } else {
                        currentTime += quantum;
                        remainingTimes[i] -= quantum;
                        System.out.println("Process " + (i+1) + " interrupted at time " + currentTime);
                    }
                }
            }
            if (!found) {
                currentTime++;
            }
        }
    }
}