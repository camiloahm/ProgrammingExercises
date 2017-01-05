package binarysearch;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * Created by dev-camiloh on 1/4/17.
 */
public class BinarySearchTest {

    @Test
    public void searchKeyInArray() {

        int key = 7;
        int list[] = {3, 4, 5, 6, 7, 8, 10};

        SearchService searchService = BinarySearchService.instance();
        boolean result = searchService.containsKey(key, list);

        assertThat(result, is(true));
    }


}
