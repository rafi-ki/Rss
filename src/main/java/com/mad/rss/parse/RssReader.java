import java.lang.RuntimeException;
import java.net.URL;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

public class RssReader
{
    private URL url;

    public RssFeed readFeed(String strURL)
    {
        if (strURL == null) //can not be parsed
            return null;

        this.url = new URL(strURL);
        RssFeed feed = null;

        try
        {
            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = url.openStream();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // Read the XML document
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement())
                {
                    String localPart = event.asStartElement().getName().getLocalPart();

                }
            }
        } catch (XMLStreamException e)
        {
            throw new RuntimeException(e);
        }

        return feed;
    }
}