package binarysearch;

/**
 * Created by CamiloH on 1/4/2017.
 */
public class BinarySearchService implements SearchService {

    private static SearchService INSTANCE;

    private BinarySearchService() {
    }

    public boolean containsKey(final int key, final int[] list) {

        int start = 0;
        int end = list.length - 1;

        while (start <= end) {

            int mid = (start+end) / 2;

            if (list[mid] == key) {
                return true;
            }

            if (key > list[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return false;
    }

    public static SearchService instance() {
        if (INSTANCE == null) {
            INSTANCE = new BinarySearchService();
        }
        return INSTANCE;
    }
}
