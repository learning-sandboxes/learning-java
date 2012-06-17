import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dmitry
 * Date: 17.06.12
 * Time: 4:31
 * To change this template use File | Settings | File Templates.
 */
public class SubsequenceImpl implements Subsequence {
    public boolean find(List x, List y) {
        int j = 0;
        for (int i=0; i<x.size(); i++) {
            while (x.get(i) != y.get(j)) {
                j++;
                if (j >= y.size()) {
                    return false;
                }
            }
        }
        return true;
    }
}
