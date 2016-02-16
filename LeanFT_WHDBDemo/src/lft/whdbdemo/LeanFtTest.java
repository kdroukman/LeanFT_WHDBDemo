package lft.whdbdemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;
import com.hp.lft.sdk.web.*;
import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {

	private Browser browser;
	
	public LeanFtTest() {
		//Change this constructor to private if you supply your own public constructor
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = new LeanFtTest();
		globalSetup(LeanFtTest.class);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		globalTearDown();
	}

	@Before
	public void setUp() throws Exception {
		browser = BrowserFactory.launch(BrowserType.CHROME);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void nagivate() throws GeneralLeanFtException {
		browser.navigate("http://www.waikatodhb.health.nz/");
		browser.sync();
	}
	
	@Test
	public void selectMenuItem() throws GeneralLeanFtException {
		browser.describe(Link.class, new LinkDescription.Builder()
				.tagName("A").innerText("For patients and visitors  ").build()).hoverTap();
		
		browser.describe(Link.class, new LinkDescription.Builder()
				.tagName("A").innerText("Visiting patients").index(0).build()).click();
		
		WebElement header = browser.describe(WebElement.class, new WebElementDescription.Builder()
				.tagName("H1").innerText("Visiting patients").build());
		
		assertEquals(header.getInnerText(), "Visiting patients");
	}



}
 