package others;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArrayListTest.class, LinkedListOneSideTest.class, LinkedListTwoSidesTest.class, NodeOneSideTest.class,
		NodeTwoSidesTest.class })
public class AllTests {

}
