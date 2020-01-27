import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
// tagi: errorCheck, numCheck, nullCheck, substTests
@RunWith(JUnitPlatform.class)
@SelectClasses(CalcAppTest.class)
@IncludeTags({"errorCheck", "substTests"})
@ExcludeTags({"numCheck"})
public class SelectedTests {
}
