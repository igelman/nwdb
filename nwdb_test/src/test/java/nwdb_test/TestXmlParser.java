package nwdb_test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestXmlParser {
	private String hardCodedXml;
	private String firstDescription;
	private String lastDescription;
	
	@Before
	public void setUp() throws Exception {
		// String from http://www.thedailybeast.com/feed/articles.rss.xml?limit=5
		//   contains five articles
		hardCodedXml = "<?xml version=1.0 encoding=UTF-8?><rss xmlns:media=http://search.yahoo.com/mrss/ version=2.0>  <channel>    <title>articles</title>    <link>http://www.thedailybeast.com/feed/articles.rss.xml</link>    <description>articles</description>    <item>      <title>If You Build It, They Will Skate</title>      <link>http://www.thedailybeast.com/articles/2013/07/16/if-you-build-it-they-will-skate</link>      <description>Maysoon Zayid tells the incredible story of a West Bank man determined to bring skateboarding to Palestine.</description>      <enclosure url=http://www.thedailybeast.com/articles/2013/07/16/if-you-build-it-they-will-skate/_jcr_content/image.img.410.273.jpg/1374072282190.cached.jpg type=image/jpg />      <pubDate>Wed, 17 Jul 2013 14:45:00 GMT</pubDate>      <author>Maysoon Zayid</author>      <guid isPermaLink=false>/content/dailybeast/articles/2013/07/16/if-you-build-it-they-will-skate</guid>      <media:group>        <media:content height=90 type=image/jpg width=135 url=http://www.thedailybeast.com/articles/2013/07/16/if-you-build-it-they-will-skate/_jcr_content/image.img.135.90.jpg/1374072282190.cached.jpg />        <media:content height=200 type=image/jpg width=300 url=http://www.thedailybeast.com/articles/2013/07/16/if-you-build-it-they-will-skate/_jcr_content/image.img.300.200.jpg/1374072282190.cached.jpg />        <media:content height=273 type=image/jpg width=410 url=http://www.thedailybeast.com/articles/2013/07/16/if-you-build-it-they-will-skate/_jcr_content/image.img.410.273.jpg/1374072282190.cached.jpg />        <media:credit role=author scheme=urn:ebu>Amir Terkel</media:credit>        <media:description type=html />        <media:thumbnail url=http://www.thedailybeast.com/articles/2013/07/16/if-you-build-it-they-will-skate/_jcr_content/image.img.135.90.jpg/1374072282190.cached.jpg />      </media:group>    </item>    <item>      <title>Gay People Exist</title>      <link>http://www.thedailybeast.com/articles/2013/07/17/processing-the-murder-of-eric-ohena-lembembe</link>      <description>An outspoken voice for gay rights was tortured and killed in Cameroon.</description>      <enclosure url=http://www.thedailybeast.com/articles/2013/07/17/processing-the-murder-of-eric-ohena-lembembe/_jcr_content/image.img.410.273.jpg/1374070442413.cached.jpg type=image/jpg />      <category>world</category>      <pubDate>Wed, 17 Jul 2013 13:40:00 GMT</pubDate>      <author>Neela Ghoshal</author>      <guid isPermaLink=false>/content/dailybeast/articles/2013/07/17/processing-the-murder-of-eric-ohena-lembembe</guid>      <media:group>        <media:content height=90 type=image/jpg width=135 url=http://www.thedailybeast.com/articles/2013/07/17/processing-the-murder-of-eric-ohena-lembembe/_jcr_content/image.img.135.90.jpg/1374070442413.cached.jpg />        <media:content height=200 type=image/jpg width=300 url=http://www.thedailybeast.com/articles/2013/07/17/processing-the-murder-of-eric-ohena-lembembe/_jcr_content/image.img.300.200.jpg/1374070442413.cached.jpg />        <media:content height=273 type=image/jpg width=410 url=http://www.thedailybeast.com/articles/2013/07/17/processing-the-murder-of-eric-ohena-lembembe/_jcr_content/image.img.410.273.jpg/1374070442413.cached.jpg />        <media:credit role=author scheme=urn:ebu>Sunday Alamba/AP</media:credit>        <media:description type=html>People walk past a campaign billboard for President Paul Biya, in Yaounde, Cameroon. In power since 1982, under his government the country has increasingly discriminated against gays.</media:description>        <media:thumbnail url=http://www.thedailybeast.com/articles/2013/07/17/processing-the-murder-of-eric-ohena-lembembe/_jcr_content/image.img.135.90.jpg/1374070442413.cached.jpg />      </media:group>    </item>    <item>      <title>Israel to Approve 900 Settlement Homes in West Bank</title>      <link>http://www.thedailybeast.com/articles/2013/07/17/israel-to-approve-900-settlement-homes-in-west-bank</link>      <description>&amp;quot;A new generation of Europeans has grown, which expect us to initiate, to offer real offers for an agreement (with the Palestinians), to stop with the statements about anti-Semitism and about how they have no right to preach to us morals.&amp;quot;&lt;br /&gt;&#xD;&lt;b&gt;--Yedioth&amp;apos;s senior political commentator Shimon Shiffer describes the writing that was on the wall before the EU made its decision to boycott settlers and settlements.&lt;/b&gt;&lt;b /&gt;</description>      <pubDate>Wed, 17 Jul 2013 13:30:00 GMT</pubDate>      <author>Orly Halpern</author>      <guid isPermaLink=false>/content/dailybeast/articles/2013/07/17/israel-to-approve-900-settlement-homes-in-west-bank</guid>    </item>    <item>      <title>Operation Dark Sky</title>      <link>http://www.thedailybeast.com/articles/2013/07/17/is-light-pollution-the-easiest-environmental-problem-to-fix</link>      <description>Author Paul Bogard talks to Mindy Farabee about light pollution, an environmental problem that we can easily do something about.</description>      <enclosure url=http://www.thedailybeast.com/articles/2013/07/17/is-light-pollution-the-easiest-environmental-problem-to-fix/_jcr_content/image.img.410.273.jpg/1374061692403.cached.jpg type=image/jpg />      <category>books</category>      <pubDate>Wed, 17 Jul 2013 11:38:00 GMT</pubDate>      <author>Mindy Farabee</author>      <guid isPermaLink=false>/content/dailybeast/articles/2013/07/17/is-light-pollution-the-easiest-environmental-problem-to-fix</guid>      <media:group>        <media:content height=90 type=image/jpg width=135 url=http://www.thedailybeast.com/articles/2013/07/17/is-light-pollution-the-easiest-environmental-problem-to-fix/_jcr_content/image.img.135.90.jpg/1374061692403.cached.jpg />        <media:content height=200 type=image/jpg width=300 url=http://www.thedailybeast.com/articles/2013/07/17/is-light-pollution-the-easiest-environmental-problem-to-fix/_jcr_content/image.img.300.200.jpg/1374061692403.cached.jpg />        <media:content height=273 type=image/jpg width=410 url=http://www.thedailybeast.com/articles/2013/07/17/is-light-pollution-the-easiest-environmental-problem-to-fix/_jcr_content/image.img.410.273.jpg/1374061692403.cached.jpg />        <media:credit role=author scheme=urn:ebu>Uschools University Images/Getty</media:credit>        <media:description type=html>Los Angeles City Skyline, California</media:description>        <media:thumbnail url=http://www.thedailybeast.com/articles/2013/07/17/is-light-pollution-the-easiest-environmental-problem-to-fix/_jcr_content/image.img.135.90.jpg/1374061692403.cached.jpg />      </media:group>    </item>    <item>      <title>Honey Boo Boo: A Glossary</title>      <link>http://www.thedailybeast.com/articles/2013/07/17/here-comes-honey-boo-boo-a-glossary</link>      <description>What is Honey Boo Boo saying? In time for the season premiere, a guide to the country-fried jargon.</description>      <enclosure url=http://www.thedailybeast.com/articles/2013/07/17/here-comes-honey-boo-boo-a-glossary/_jcr_content/image.img.410.273.jpg/1374060323206.cached.jpg type=image/jpg />      <pubDate>Wed, 17 Jul 2013 11:17:00 GMT</pubDate>      <author>Kevin Fallon</author>      <guid isPermaLink=false>/content/dailybeast/articles/2013/07/17/here-comes-honey-boo-boo-a-glossary</guid>      <media:group>        <media:content height=90 type=image/jpg width=135 url=http://www.thedailybeast.com/articles/2013/07/17/here-comes-honey-boo-boo-a-glossary/_jcr_content/image.img.135.90.jpg/1374060323206.cached.jpg />        <media:content height=200 type=image/jpg width=300 url=http://www.thedailybeast.com/articles/2013/07/17/here-comes-honey-boo-boo-a-glossary/_jcr_content/image.img.300.200.jpg/1374060323206.cached.jpg />        <media:content height=273 type=image/jpg width=410 url=http://www.thedailybeast.com/articles/2013/07/17/here-comes-honey-boo-boo-a-glossary/_jcr_content/image.img.410.273.jpg/1374060323206.cached.jpg />        <media:credit role=author scheme=urn:ebu>TLC</media:credit>        <media:description type=html>Alana (Honey Boo Boo) reads a book to her baby doll.</media:description>        <media:thumbnail url=http://www.thedailybeast.com/articles/2013/07/17/here-comes-honey-boo-boo-a-glossary/_jcr_content/image.img.135.90.jpg/1374060323206.cached.jpg />      </media:group>    </item>  </channel></rss>";
		firstDescription = "The Daily Pic: Josephine Meckseper plucks her art from our commodity culture.";
		lastDescription = "What is Honey Boo Boo saying? In time for the season premiere, a guide to the country-fried jargon.";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFirstDescriptions() {
		String xExpression = "rss/channel/item/description";
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("articles.rss.xml");
		
		XmlParser xp = new XmlParser(in);
		String actualFirstDescription = xp.nodeContent(xExpression);
		assertEquals(firstDescription, actualFirstDescription);
	}
	
	@Ignore @Test
	public void testExceptionHandlers() {
		fail("xmlParser() exceptions are not yet implemented");
		// ParserConfigurationException
		// SAXException
		// IOException
		// XPathExpressionException
	}
	
	@Ignore @Test
	public void testNumberOfDescriptions() {
		fail("Not yet implemented");
		int expectedCount = 5;
		int actualCount;
		
		XmlParser xp = new XmlParser(hardCodedXml); 
	}

}
