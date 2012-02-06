package edu.SimonCresnjovnjak.web;

import org.ksoap2.*;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;
import org.w3c.dom.Text;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DeloZWebService {

	private static final String SOAP_ACTION1="http://ws.apache.org/axis2/DobiKolicinaZdravila";
    private static final String METHOD_NAME1="DobiKolicinaZdravila";
    private static final String SOAP_ACTION2="http://ws.apache.org/axis2/VstaviZdravilaKolicina";
    private static final String METHOD_NAME2="VstaviZdravilaKolicina";
    private static final String SOAP_ACTION3="http://ws.apache.org/axis2/DodajZalogoZdravil";
    private static final String METHOD_NAME3="DodajZalogoZdravil";
    private static final String SOAP_ACTION4="http://ws.apache.org/axis2/DodajOpomnike";
    private static final String METHOD_NAME4="DodajOpomnike";
    private static final String SOAP_ACTION5="http://ws.apache.org/axis2/DobiOpomnike";
    private static final String METHOD_NAME5="DobiOpomnike";
    private static final String SOAP_ACTION6="http://ws.apache.org/axis2/DobiImeZdravila";
    private static final String METHOD_NAME6="DobiImeZdravila";
    private static final String SOAP_ACTION7="http://ws.apache.org/axis2/ZmanjsajZalogoZdravil";
    private static final String METHOD_NAME7="ZmanjsajZalogoZdravil";
    private static final String NAMESPACE="http://ws.apache.org/axis2";
    private static final String URL="http://192.168.0.232:8080/webTabletar/services/web?wsdl";
	
    public String GetData() {
    	SoapObject Request=new SoapObject(NAMESPACE, METHOD_NAME1);
    	//Request.addProperty("Celsius",param);
    	SoapSerializationEnvelope soapEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	soapEnvelope.dotNet=false;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION1, soapEnvelope);              
	        final Object response = soapEnvelope.getResponse(); 
		return response.toString();
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
    	soapEnvelope.dotNet=false;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION2, soapEnvelope);              
    	        final Object response = soapEnvelope.getResponse(); 
    		return response.toString();
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
    	soapEnvelope.dotNet=false;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION3, soapEnvelope);              
	        final Object response = soapEnvelope.getResponse(); 
		return response.toString();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return "NAPAKA!!";
	}
    public String ZamnjsajZdravilo(String a, int b) {
    	SoapObject Request=new SoapObject(NAMESPACE, METHOD_NAME7);
    	Request.addProperty("zdr",a);
    	Request.addProperty("kol",b);
    	SoapSerializationEnvelope soapEnvelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	soapEnvelope.dotNet=false;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION7, soapEnvelope);              
	        final Object response = soapEnvelope.getResponse(); 
		return response.toString();
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
    	soapEnvelope.dotNet=false;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION4, soapEnvelope);              
	        final Object response = soapEnvelope.getResponse(); 
		return response.toString();
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
    	soapEnvelope.dotNet=false;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION5, soapEnvelope);              
	        final Object response = soapEnvelope.getResponse(); 
		return response.toString();
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
    	soapEnvelope.dotNet=false;
    	soapEnvelope.setOutputSoapObject(Request);
    	
    	HttpTransportSE aht=new HttpTransportSE(URL);
    	try
    	{
    		aht.call(SOAP_ACTION6, soapEnvelope);              
	        final Object response = soapEnvelope.getResponse(); 
		return response.toString();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return "NAPAKA!!";
	}
}
