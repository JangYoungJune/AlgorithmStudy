package AlgorithmStudy.fromProgrammers;

import java.util.*;

/*
 * problem URL: https://programmers.co.kr/learn/courses/30/lessons/42627?language=java
 * */
public class Heap3 {
    static class Job implements Comparable<Job>{
        private int inputTime;
        private int processTime;
        public Job(int inputTime, int processTime){
            this.inputTime = inputTime;
            this.processTime = processTime;
        }
        public int getInputTime (){
            return inputTime;
        }
        public int getProcessTime (){
            return processTime;
        }
        @Override
        public int compareTo(Job p) {
            if(this.getInputTime() > p.getInputTime()) {
                return 1;
            }
            return -1;
        }
    }

    public static int solution(int[][] jobs) {
        int jobCount = jobs.length;
        int totalTime = 0;
        int calcTime = 0;
        PriorityQueue<Job> jobQueue = new PriorityQueue<>(Comparator.comparing(Job::getProcessTime));
        List<Job> jobList = new ArrayList<>(jobCount);

        // transfer array to list
        for(int i=0;i<jobs.length;i++){
            jobList.add(new Job(jobs[i][0], jobs[i][1]));
        }
        // sort by input time
        Collections.sort(jobList);
        // while loop - whne joblist is empty and jobQueue is empty, the loop will be end
        while(!jobList.isEmpty() || !jobQueue.isEmpty()){
            // in jobList, index input value is less or same then totalTime, add queue
            while(!jobList.isEmpty() && totalTime >= jobList.get(0).getInputTime()){
                jobQueue.offer(jobList.remove(0));
            }
            // if jobqueue is idle, find minimum processTime job - if it is, process and
            //                                                   - if job queue is empty, add totalTime 1
            if(!jobQueue.isEmpty()){
                Job processJob = jobQueue.poll();
                int processDoneTime = totalTime - processJob.getInputTime() + processJob.getProcessTime(); //waitTime + processTime;
                calcTime += processDoneTime;
                totalTime += processJob.getProcessTime();
            } else{
                totalTime++;
            }
        }

        return (calcTime / jobCount);
    }

    public static void main(String args[]) {
        int[][] a = {{2,6}, {0,3}, {1,9}};

        int answer = solution(a);
        System.out.println(answer);
    }
}
