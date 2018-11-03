package jsr.interviewBit;

import java.util.ArrayList;
import java.util.List;

public class MinInRotatedArray {

    // DO NOT MODIFY THE LIST
    public static int findMin(final List<Integer> a) {

        int left = 0;
        int N = a.size();
        int right = N - 1;
        int mid;

        if (N == 0) {
            return -1;
        }
        if (N == 1) {
            return a.get(0);
        }


        while (left - 1 < right) {
            mid = left + (right - left) / 2;
            if (a.get(left) < a.get(right)) {
                return a.get(left);
            }
            if (a.get(mid) < a.get((mid - 1 + N) % N) && (a.get(mid) < a.get((mid + 1) % N))) {
                return a.get(mid);

            }

            if (a.get(mid) > a.get(right)) {
                left= mid +1;
            } else if (a.get(mid) < a.get(left)) {
                right = mid -1;
            }


        }
        if (a.get(left) > a.get(right)) {
            return a.get(right);
        } else {
            return a.get(left);
        }


    }


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        Integer[] array = {93240, 93357, 93745, 94622, 94742, 96173, 97712, 98000,
                98616, 99102, 1396, 1577, 2682, 3644, 4749, 5623, 6522, 7245,
                8564, 8675, 9671, 10500, 11276, 12033, 12682, 13977, 14324,
                14626, 14804, 15036, 15070, 15656, 15660, 16227, 16436, 17591, 18442,
                18674, 18770, 19825, 19904, 20836, 21503, 21666, 21755, 22345, 22580, 24128,
                24640, 25200, 25610, 25852, 26424, 26675, 28115, 28433, 29053, 29957, 29975,
                30020, 30396, 30567, 31821, 33292, 33319, 34040, 34696, 34781, 35770, 36239,
                37460, 37507, 38910, 39310, 39947, 40097, 40170, 40354, 40436, 40670, 44373,
                44461, 44790, 45024, 45154, 45526, 45758, 46648, 48852, 51549, 54652, 55102,
                55455, 55501, 55690, 56135, 56161, 56509, 56674, 57017, 57571, 57821, 58353,
                58904, 58906, 59057, 59119, 59443, 60226, 60687, 60973, 61863, 62346, 62475,
                63106, 63254, 65085, 65251, 65472, 65529, 66723, 67327, 68770, 69656, 69867,
                70632, 71155, 72148, 72185, 72277, 72440, 73058, 73223, 74078, 75208, 76131, 76214, 76776};
        for (int i = 0; i < array.length; i++) {
            a.add(array[i]);
        }

        findMin(a);

    }


}
