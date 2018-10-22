package myAssignment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class readData {

    public static List<Table> getData() {
        try {
            String URL = "https://ms.wikipedia.org/wiki/Malaysia";
            Document doc = Jsoup.connect(URL).get();

            System.out.println("\nRead data from " + URL);
            System.out.println();

            List<Table> result = new ArrayList();

            Elements tittle = doc.select("span#Trivia");
            //System.out.println(" "+div.tittle);

            //for(int a=0;a<24;a++){
            //Elements trs = doc.select("#mw-content-text>div>table:nth-child(148)>tbody>tr:nth-child("+a+")>th");
            //Elements tds = doc.select("#mw-content-text>div>table:nth-child(148)>tbody>tr:nth-child("+a+")>th");
            //System.out.printf("%2d", a);
            //System.out.printf(":");
            //System.out.printf("%34s", trs.text());
            //System.out.printf(" ");
            //System.out.printf("%5s", tds.text() +"\n");
            for (Element TList : doc.select("tr[align]")){
                //for (int a=0;a<24;a++) {

                //Elements num = doc.select("th");
                Elements elements = TList.select("th");
                Elements element = TList.select("td");

                //Integer Num = Integer.valueOf(num.text());
                String Info1 = elements.text();
                String Info2 = element.text();

                result.add(new Table(Info1,Info2));
                System.out.printf("%-40s",Info1);
                System.out.print(" "+ Info2);
                System.out.println();


            }return result;
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.out.println("Successfull");
        return null;
    }
}
    /*public static List<Table> ReadData(){

        List<Table> trivia = new ArrayList();
        try {
            System.out.println("Read data from: "+Common.url);
            System.out.println();

            Document document;
            document = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get();
            Elements temp = document.select("span.mw-headline#Trivia");

            String title = temp.text();
            System.out.println("Title: "+title);

            for (Element triviaList : document.select("tr[align]")) {

                String List = triviaList.select("th").text();
                String Info = triviaList.select("td").text();

                trivia.add(new Table(List,Info));
                    System.out.printf("%-40s",List);
                    System.out.print(" "+ Info);
                    System.out.println();
            } return trivia;


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println();
        System.out.println("Done read data table");
        return null;
    }
}*/

