package edu.SimonCresnjovnjak.web;

import org.ksoap2.*;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;
import org.w3c.dom.Text;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DeloZWebService {

	private static final String SOAP_ACTION1="http://tempuri.org/DobiKolicinaZdravila";
    private static final String METHOD_NAME1="DobiKolicinaZdravila";
    private static final String SOAP_ACTION2="http://tempuri.org/VstaviZdravilaKolicina";
    private static final String METHOD_NAME2="VstaviZdravilaKolicina";
    private static final String SOAP_ACTION3="http://tempuri.org/DodajZalogoZdravil";
    private static final String METHOD_NAME3="DodajZalogoZdravil";
    private static final String SOAP_ACTION4="http://tempuri.org/DodajOpomnike";
    private static final String METHOD_NAME4="DodajOpomnike";
    private static final String SOAP_ACTION5="http://tempuri.org/DobiOpomnike";
    private static final String METHOD_NAME5="DobiOpomnike";
    private static final String SOAP_ACTION6="http://tempuri.org/DobiImeZdravila";
    private static final String METHOD_NAME6="DobiImeZdravila";
    private static final String NAMESPACE="http://tempuri.org/";
    private static final String URL="http://10.0.2.2:51748/Service1.asmx";
	
    public String GetData() {
    	SoapObject Request=new SoapObject(NAMESPACE, METHOD_NAME1);
    	//Request.addProperty("Celsius",param);
    	SoapSerializationEnvelope soapEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	soapEnvelope.dotNet=true;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION1,soapEnvelope);
    		SoapPrimitive result=(SoapPrimitive)soapEnvelope.getResponse();
    		return result.toString();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return "NAPAKA!!";
	}
    
    public String SendData(String a, int b) {
    	SoapObject Request=new SoapObject(NAMESPACE, METHOD_NAME2);
    	Request.addProperty("naz",a);
    	Request.addProperty("kol",b);
    	SoapSerializationEnvelope soapEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	soapEnvelope.dotNet=true;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION2,soapEnvelope);
    		SoapPrimitive result=(SoapPrimitive)soapEnvelope.getResponse();
    		return result.toString();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return "NAPAKA!!";
	}
    
    public String InsertZdravilo(String a, int b) {
    	SoapObject Request=new SoapObject(NAMESPACE, METHOD_NAME3);
    	Request.addProperty("zdr",a);
    	Request.addProperty("kol",b);
    	SoapSerializationEnvelope soapEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	soapEnvelope.dotNet=true;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION3,soapEnvelope);
    		SoapPrimitive result=(SoapPrimitive)soapEnvelope.getResponse();
    		return result.toString();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return "NAPAKA!!";
	}
    public String InsertOpomnik(String a, String b, int c) {
    	SoapObject Request=new SoapObject(NAMESPACE, METHOD_NAME4);
    	Request.addProperty("naz",a);
    	Request.addProperty("Time",b);
    	Request.addProperty("kol",c);
    	SoapSerializationEnvelope soapEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	soapEnvelope.dotNet=true;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION4,soapEnvelope);
    		SoapPrimitive result=(SoapPrimitive)soapEnvelope.getResponse();
    		return result.toString();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return "NAPAKA!!";
	}
    public String DobiOpomnik() {
    	SoapObject Request=new SoapObject(NAMESPACE, METHOD_NAME5);
    	SoapSerializationEnvelope soapEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	soapEnvelope.dotNet=true;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION5,soapEnvelope);
    		SoapPrimitive result=(SoapPrimitive)soapEnvelope.getResponse();
    		return result.toString();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return "NAPAKA!!";
	}
    
    public String GetImeOP() {
    	SoapObject Request=new SoapObject(NAMESPACE, METHOD_NAME6);
    	//Request.addProperty("Celsius",param);
    	SoapSerializationEnvelope soapEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	soapEnvelope.dotNet=true;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION6,soapEnvelope);
    		SoapPrimitive result=(SoapPrimitive)soapEnvelope.getResponse();
    		return result.toString();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return "NAPAKA!!";
	}
}
