package net.tempos21;

import org.w3c.dom.Element;

import net.tempos21.excel.Excel;

public class Tests {
	final private static String PATH = "C:\\Users\\Agustí\\Desktop\\Ma_documents\\java_i_altres\\Tempos21\\TestLink\\ ";
	protected static void proces(){
		Excel excel = new Excel(PATH.replace("\\ ", "\\TestLink.xlsx") ,"case");
		WriteXML wxml = new WriteXML();
		final int nTestsuite0 = 0;
		final int nName1 = 1; 
		final int nNode_order1 = 2;
		final int nDetails1 = 3;
		final int nTestcase1 = 4;
		final int nInternalid1 = 5;
		final int nNode_order2 = 6;
		final int nExternalid2 = 7;
		final int nVersion2 = 8;
		final int nSummary2 = 9;
		final int nPreconditions2 = 10;
		final int nExecution_type2 = 11;
		final int nImportance2 = 12;
		final int nStep_number2 = 13;
		final int nActions2 = 14;
		final int nExpectedresults2 = 15;
		final int nExpection_type2 = 16;	
		final String STEPS = "steps";
		final String STEP = "step";
		
		String testsuite0 = excel.readCell(0, nTestsuite0);
		String name1 = excel.readCell(0, nName1);
		String node_order1 = excel.readCell(0, nNode_order1);
		String details1 = excel.readCell(0, nDetails1);
		String testcase1 = excel.readCell(0, nTestcase1); 
		String internalid1 = excel.readCell(0, nInternalid1);
		String node_order2 = excel.readCell(0, nNode_order2);
		String externalid2 = excel.readCell(0, nExternalid2);
		String version2 = excel.readCell(0, nVersion2);
		String summary2 = excel.readCell(0, nSummary2);
		String preconditions2 = excel.readCell(0, nPreconditions2);
		String execution_type2 = excel.readCell(0, nExecution_type2);
		String importance2 = excel.readCell(0, nImportance2);
		String step_number2 = excel.readCell(0, nStep_number2);
		String actions2 = excel.readCell(0, nActions2);
		String expectedresults2 = excel.readCell(0, nExpectedresults2);
		String expection_type2 = excel.readCell(0, nExpection_type2);
		
		Element testsuite = wxml.createElement(null, testsuite0, name1, excel.readCell(1, nTestsuite0));
		
		wxml.createCDATASection(testsuite, node_order1, excel.readCell(1, nNode_order1));
		wxml.createCDATASection(testsuite, details1, excel.readCell(1, nDetails1));		
		
		Element testsuite1 = null;
		Element testcase = null;
		Element steps = null;
		Element step = null;
		
		int i = 2;
		
		
		do {
			if(excel.readCell(i, nName1) != null) {
				testsuite1 = wxml.createElement(testsuite, testsuite0, name1, excel.readCell(i, nName1));
				wxml.createCDATASection(testsuite1, node_order1, excel.readCell(i, nNode_order1));
				wxml.createCDATASection(testsuite1, details1, excel.readCell(i, nDetails1," "));
			}

			testcase = wxml.createElement(testsuite1, testcase1, internalid1, excel.readCell(i, nInternalid1),name1,excel.readCell(i, nTestcase1));
			wxml.createCDATASection(testcase, node_order2, excel.readCell(i, nNode_order2));
			wxml.createCDATASection(testcase, externalid2, excel.readCell(i, nExternalid2));
			wxml.createCDATASection(testcase, version2, excel.readCell(i, nVersion2));
			wxml.createCDATASection(testcase, summary2, excel.readCell(i, nSummary2));
			wxml.createCDATASection(testcase, preconditions2, excel.readCell(i, nPreconditions2," "));
			wxml.createCDATASection(testcase, execution_type2, excel.readCell(i, nExecution_type2));	
			wxml.createCDATASection(testcase, importance2, excel.readCell(i, nImportance2));
			

			if(excel.readCell(i, nStep_number2) != null) {
				steps = wxml.createElement(testcase,STEPS);
				do {
					step = wxml.createElement(steps,STEP);
					wxml.createCDATASection(step, step_number2, excel.readCell(i, nStep_number2));
					wxml.createCDATASection(step, actions2, excel.readCell(i, nActions2));
					wxml.createCDATASection(step, expectedresults2, excel.readCell(i, nExpectedresults2));
					wxml.createCDATASection(step, expection_type2, excel.readCell(i, nExpection_type2));

					i++;
				}while(excel.readCell(i, nTestcase1) == null && excel.readCell(i, nStep_number2) != null);
			} else {
				i++;				
			}

		}while(excel.readCell(i, nTestcase1) != null || excel.readCell(i, nStep_number2) != null);
	

		System.out.println(wxml.displyXML().replace("<![CDATA[ ]]>", "<![CDATA[]]>"));
	}
}
