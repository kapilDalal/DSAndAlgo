package challenge.monthly.November;

import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class MinCostToMoveChips_5 {

    public int minCostToMoveChips(int[] position) {
        if (position.length <= 1)
            return 0;

        int even = 0;
        int odd = 0;
        for (int i = 0; i < position.length; i++) {
            if(position[i]%2==0)
                even++;
            else
                odd++;
        }

        return Math.min(even,odd);
    }
}
