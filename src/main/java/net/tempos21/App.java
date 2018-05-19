package net.tempos21;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.tempos21.excel.Colors;
import net.tempos21.excel.Excel;
import net.tempos21.metodes.Panell;
import net.tempos21.metodes.Utils;
import net.tempos21.metodes.files.*;
;
public class App 
{
    public static void main( String[] args )
    {
    	//Tests.proces();
        excel();
    
    }
 
    static void fitxers(Fitxers f){
    	f.fitxer(null);
    }
    
    private static void excel() {
    	final String pathOrigin = "C:\\Users\\Agustí\\Desktop\\Ma_documents\\java_i_altres\\Tempos21\\test.xlsx";
    	final String pathDestin = "C:\\Users\\Agustí\\Desktop\\Ma_documents\\java_i_altres\\Tempos21\\test2.xlsx";
    	final String sheetname = "Tab2";
    	
    	if(Panell.atencioAcceptar("Mostrar EXCEL original")){
    	
    		Utils.openDirectory(pathOrigin);
    	}
    	if(Panell.atencioAcceptar("Executar proces")){
        	Excel excel = new Excel(pathOrigin, pathDestin, sheetname);
        	/*
        	double n1 = 2;
        	double n2 = 5;
        	double n3 = 3;
        	Object[] values = {n1,n2,n3};
        	int iniRow = 1;
        	int col = 7;
        	excel.writeRow(iniRow, col, values,null);
        	*/
        	String sheetName = "tab1";
        	excel.createSheet(sheetName);
        	final int N = 32;
        	String[] value = new String[N];
        	int[] color = new int[N];
        	String range = "B1:B300";
        	Object[] values = new Object[N];
        	for(int i=0;i<N;i++) {
        		value[i] = "N"+i;
        		color[i] = i;
        		values[i] = "N"+i;
        	}
        
    		value[8] = "BLAU";
    		color[8] = Colors.BLAU;
    		values[8] = "BLAU";       	
        	excel.setColorToCell(value, color, range,false, sheetName);
        	excel.writeRow(1, 1, values,sheetName);
        	
        	Utils.openDirectory(pathDestin);
    	}
    	

    			
    }

    
    final private static String PATH = "C:\\Users\\Agustí\\Desktop\\Ma_documents\\java_i_altres\\Tempos21\\TestLink\\carga agente venta.xml";
    private static void proces() {
    	/*
    	String[] s = net.tempos21.metodes.Fitxer.read(PATH);
    	for(String str: s) {
    		System.out.println(str);
    	}
    	*/
        try 
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(PATH));
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("testsuite");
            for (int temp = 0; temp < nList.getLength(); temp++) {
            	Node nNode = nList.item(temp);
        		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        			Element eElement = (Element) nNode;

        			System.out.println("testsuite name : " + eElement.getAttribute("name"));
        		}
            }
            
            
            //for (int temp = 0; temp < nList.getLength(); temp++) {
        		Node nNode = nList.item(0);

        		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        			Element eElement = (Element) nNode;

       
        			 NodeList nLnode_order = eElement.getElementsByTagName("node_order");
        			 NodeList nLdetails = eElement.getElementsByTagName("details");
        			 NodeList nLtestcase = eElement.getElementsByTagName("testcase");        			 
        			 NodeList nLexternalid = eElement.getElementsByTagName("externalid");
        			 System.out.println("nLnode_order : "+nLnode_order.getLength());
        			 System.out.println("nLdetails :    "+nLdetails.getLength());
        			 System.out.println("nLtestcase :   "+nLtestcase.getLength());
        			 System.out.println("nLexternalid : "+nLexternalid.getLength());
        		
					for (int i = 0; i < nLtestcase.getLength(); i++) {
						//System.out.println("nLtestcase (" + temp + "): "+ nLtestcase.item(i).getTextContent());
						Node nTestcase = nLtestcase.item(i);
						if (nTestcase.getNodeType() == Node.ELEMENT_NODE) {
		        			Element eTestcase = (Element) nTestcase;
		        			Node nod = eTestcase.getParentNode();
		        			System.out.println("testsuite name : " + ((Element) nod).getAttribute("name"));
		        			
		        			System.out.println("testcase internalid : " + eTestcase.getAttribute("internalid"));	
		        			System.out.println("testcase name : " + eTestcase.getAttribute("name"));
		        			nLnode_order = eTestcase.getElementsByTagName("node_order");
		        			System.out.println("nLnode_order : "+nLnode_order.item(0).getTextContent());
						}
					}
       
        		}
           // }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
