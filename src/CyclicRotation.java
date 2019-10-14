import java.util.ArrayList;
import java.util.List;

class CyclicRotation {
    int[] rotate(int[] original, int rotations) {

        //create blank array
        List<Integer> rotated = new ArrayList<>();

        //create blank array of originals
        List<Integer> originalList = new ArrayList<>();
        for (int i : original) {
            originalList.add(i);
        }

        for (int i=0; i<rotations; i++){

            rotated.clear();

            //remove last item from original to new
            Integer lastItem = originalList.get(originalList.size() - 1);
            rotated.add(lastItem);
            originalList.remove(lastItem);

            //add rest of items from old to new
            rotated.addAll(originalList);

            //change the original list to be a copy of the new list if there is another rotation
            originalList.clear();
            originalList.addAll(rotated);
        }

        //convert List to array
        int[] converted = new int[rotated.size()];
        for (int i=0; i<rotated.size(); i++){
            converted[i] = rotated.get(i);
        }

        return converted;

    }
}
