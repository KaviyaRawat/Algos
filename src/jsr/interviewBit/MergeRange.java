package jsr.interviewBit;

import java.util.ArrayList;

public class MergeRange {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        @Override
        public String toString(){
            return "[" + start + "," + end + "]";
        }
    }

    public static  class Solution {
        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            int i = 0;
            while(i<intervals.size() && intervals.get(i).start<newInterval.start){
                i++;
            }

            if(i!=0 && intervals.get(i-1).end>=newInterval.start){

                if(intervals.get(i-1).end>=newInterval.end){
                    return intervals;
                }
                else{
                    newInterval.start = intervals.get(i-1).start;
                    intervals.remove(i-1);
                    i=i-1;
                }

            }
            while(i<intervals.size() && intervals.get(i).end<newInterval.end){
                intervals.remove(i);
            }
            if(i<intervals.size() &&
                    intervals.get(i).start<=newInterval.end){
                newInterval.end = intervals.get(i).end;
                intervals.remove(i);
                intervals.add(i, newInterval);
            }
            else{
                intervals.add(i, newInterval);
            }

            return intervals;


        }
    }


    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1,2));
        list.add(new Interval(3,7));
        list.add(new Interval(10, 15));
        list.add(new Interval(20,21));
        System.out.println(new Solution().insert(list, new Interval(2,14)));
    }

}
