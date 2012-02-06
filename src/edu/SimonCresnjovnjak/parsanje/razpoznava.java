package edu.SimonCresnjovnjak.parsanje;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import edu.SimonCresnjovnjak.android.Application1;
import edu.SimonCresnjovnjak.android.pars;


public class razpoznava {


	public static ArrayList<String> lista_opis;
	public static ArrayList<pars> lista_opis_naslov;
	public static ArrayList<String> lista_naslov;
	public static ArrayList<String> lista_naslov2;
	public static ArrayList<String> lista_slika;
	
	static pars p;
	
	public static ArrayList<pars> pozeni()
	{
		
		lista_opis=new ArrayList<String>();
		lista_naslov=new ArrayList<String>();
		lista_naslov2=new ArrayList<String>();
		lista_opis_naslov=new ArrayList<pars>();
		lista_slika=new ArrayList<String>();
		TagNode tagNode1;
		tagNode1 = xmlCleaner("http://www.krka.si/sl/zdravila-in-izdelki/");
		lista_opis.addAll(dobi_opis(tagNode1,"//div[@class=\"product-search-results\"]//dd"));
		
		lista_naslov2.addAll(dobi_naslov(tagNode1,"//div[@class=\"product-search-results\"]//h3/a"));
//		lista_slika.addAll(dobisliko(tagNode1,"//div[@class=\"product-search-results\"]//div[@class=\"photo\"]/a/img"));
		int b=1;
		
		for(int x=0; x< lista_naslov2.size();x++)
		{
			p=new pars();
			p.setNaslov(lista_naslov2.get(x));
			p.setOpis(lista_opis.get(x));
//			p.setLink(lista_slika.get(x));
			lista_opis_naslov.add(p);
		}
		return lista_opis_naslov;
	}
	
	public static ArrayList<String> pozeninaslovi()
	{
		ArrayList<String> news = new ArrayList<String>();
		
		TagNode tagNode1;
		tagNode1 = xmlCleaner("http://www.krka.si/sl/zdravila-in-izdelki/");
		
		
		news.addAll(dobi_naslov(tagNode1,"//div[@class=\"product-search-results\"]//h3/a"));
		int b=1;
		
		
		return news;
	}
	
	public static ArrayList<pars> pozenicrke(String e)
	{
		
		lista_opis=new ArrayList<String>();
		lista_naslov=new ArrayList<String>();
		lista_naslov2=new ArrayList<String>();
		lista_opis_naslov=new ArrayList<pars>();
		TagNode tagNode1;
		tagNode1 = xmlCleaner("http://www.krka.si/sl/zdravila-in-izdelki/izdelki-brez-recepta?letter="+e);
		lista_opis.addAll(dobi_opis(tagNode1,"//div[@class=\"product-search-results\"]//dd"));
		
		lista_naslov2.addAll(dobi_naslov(tagNode1,"//div[@class=\"product-search-results\"]//h3/a"));
		int b=1;
		
		for(int x=0; x< lista_naslov2.size();x++)
		{
			p=new pars();
			p.setNaslov(lista_naslov2.get(x));
			p.setOpis(lista_opis.get(x));
			lista_opis_naslov.add(p);
		}
		return lista_opis_naslov;
	}
	public static ArrayList<pars> isci(String e)
	{
		
		lista_opis=new ArrayList<String>();
		lista_naslov=new ArrayList<String>();
		lista_naslov2=new ArrayList<String>();
		lista_opis_naslov=new ArrayList<pars>();
		TagNode tagNode1;
		tagNode1 = xmlCleaner("http://www.krka.si/sl/zdravila-in-izdelki/izdelki-brez-recepta?keyword="+e);
		lista_opis.addAll(dobi_opis(tagNode1,"//div[@class=\"product-search-results\"]//dd"));
		
		lista_naslov2.addAll(dobi_naslov(tagNode1,"//div[@class=\"product-search-results\"]//h3/a"));
		int b=1;
		
		for(int x=0; x< lista_naslov2.size();x++)
		{
			p=new pars();
			p.setNaslov(lista_naslov2.get(x));
			p.setOpis(lista_opis.get(x));
		
			lista_opis_naslov.add(p);
		}
		return lista_opis_naslov;
	}
	public static TagNode xmlCleaner(String urlName) 
	{
		CleanerProperties props = new CleanerProperties();
		props.setTranslateSpecialEntities(true);
		props.setTransResCharsToNCR(true);
		props.setOmitComments(true);
		TagNode tagNode;
		
		try 
		{
			tagNode = new HtmlCleaner(props).clean(new URL(urlName));
			return tagNode;
		} 
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static ArrayList<String> dobi_opis(TagNode node, String XPathExpression) 
	{
		ArrayList<String> Temp=new ArrayList<String>();
		TagNode description_node = null;
		NodeList nodes;
		try 
		{
			
//			description_node = (TagNode) node.evaluateXPath(XPathExpression)[0];
			for (int x=0;x<node.evaluateXPath(XPathExpression).length;x++)
			{
			description_node = (TagNode) node.evaluateXPath(XPathExpression)[x];
//			System.out.println(description_node.getText()+"\n"+"---------------------------------------");
			Temp.add(description_node.getText().toString());
			}
		} 
		catch (XPatherException e) 
		{
			e.printStackTrace();
		}
		return Temp;
//		System.out.println(description_node.getText()+"\n"+"---------------------------------------");
	}
	public static ArrayList<String> dobi_naslov(TagNode node, String XPathExpression) 
	{
		ArrayList<String> Temp=new ArrayList<String>();
		TagNode description_node = null;
		NodeList nodes;
		try 
		{
//			description_node = (TagNode) node.evaluateXPath(XPathExpression)[0];
			
			for (int x=0;x<node.evaluateXPath(XPathExpression).length;x++)
			{
			description_node = (TagNode) node.evaluateXPath(XPathExpression)[x];
//			System.out.println(description_node.getText()+"\n"+"---------------------------------------");
			
			Temp.add(description_node.getText().toString());
			}
			
		} 
		catch (XPatherException e) 
		{
			e.printStackTrace();
		}
		return Temp;
//		System.out.println(description_node.getText()+"\n"+"---------------------------------------");
	}
	public static ArrayList<String> dobisliko(TagNode node, String XPathExpression) 
	{
		TagNode description_node = null;
		ArrayList<String> Temp=new ArrayList<String>();
		NodeList nodes;
		try 
		{
//			description_node = (TagNode) node.evaluateXPath(XPathExpression)[0];
			for (int x=0;x<node.evaluateXPath(XPathExpression).length;x++)
			{
			description_node = (TagNode) node.evaluateXPath(XPathExpression)[x];
//			System.out.println("http://www.krka.si"+description_node.getAttributeByName("src")+"\n"+"---------------------------------------");
			Temp.add("http://www.krka.si"+description_node.getAttributeByName("src").toString());
			}
		} 
		catch (XPatherException e) 
		{
			e.printStackTrace();
		}
		return Temp;
//		System.out.println(description_node.getText()+"\n"+"---------------------------------------");
	}
}
