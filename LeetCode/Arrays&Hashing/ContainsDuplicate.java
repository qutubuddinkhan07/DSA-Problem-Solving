import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicateSolution obj = new ContainsDuplicateSolution();
        System.out.println(obj.containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}

class ContainsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums)
            if (!seen.add(num))
                return true;
        return false;
    }
}
