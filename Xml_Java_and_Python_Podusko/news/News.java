import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class News {

    public static void main(String[] args) {
        try {
           
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();            
            Document doc = builder.parse(new File("news.xml"));
            
            NodeList itemList = doc.getElementsByTagName("item");

            FileWriter htmlWriter = new FileWriter("newsparsresult.html");
 
            htmlWriter.write("<html><body><h1>Результаты парсинга:</h1>");

            for (int i = 0; i < itemList.getLength(); i++) {
                Element item = (Element) itemList.item(i);
                String title = getElementTextByTagName(item, "title");
                String description = getElementTextByTagName(item, "description");
                String pubDate = getElementTextByTagName(item, "pubDate");
                String author = getElementTextByTagName(item, "author");


                htmlWriter.write("<h2>" + title + "</h2>");
                htmlWriter.write("<p><strong>Description:</strong> " + description + "</p>");
                htmlWriter.write("<p><strong>Publication Date:</strong> " + pubDate + "</p>");
                htmlWriter.write("<p><strong>Author:</strong> " + author + "</p>");
                htmlWriter.write("<hr>");
            }

        
            htmlWriter.write("</body></html>");
            htmlWriter.close();

            System.out.println("Парсинг завершон. Результаты сохранены");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String getElementTextByTagName(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            return node.getTextContent();
        }
        return "";
    }
}