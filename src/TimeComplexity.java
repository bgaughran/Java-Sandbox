class TimeComplexity {
    int solution(int start, int end, int jumpSize) {

        int size = end - start;
        if (size % jumpSize == 0) {
            return size / jumpSize;
        } else {
            return size / jumpSize + 1;
        }


    }
}
