package com.bdmitech.android.huawei.qpay.utils;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class GetMerchantName {
	public static String getMerchantName(String strEncryptMerchantAccountNumber,String strMasterKey) {
		String METHOD_NAME = "QPAY_GetMerchantAccountName";
		String SOAP_ACTION = "http://www.bdmitech.com/m2b/QPAY_GetMerchantAccountName";
		SoapObject request = new SoapObject(GlobalData.getStrNamespace().replaceAll(" ","%20"), METHOD_NAME);

		// Declare the version of the SOAP request
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

		PropertyInfo encryptMerchantAccountNumber = new PropertyInfo();
		encryptMerchantAccountNumber.setName("strMerchantAccountNo");
		encryptMerchantAccountNumber.setValue(strEncryptMerchantAccountNumber);
		encryptMerchantAccountNumber.setType(String.class);
		request.addProperty(encryptMerchantAccountNumber);

		PropertyInfo masterKey = new PropertyInfo();
		masterKey.setName("strMasterKey");
		masterKey.setValue(strMasterKey);
		masterKey.setType(String.class);
		request.addProperty(masterKey);


		envelope.dotNet = true;

		envelope.setOutputSoapObject(request);
		envelope.implicitTypes = true;
		Object objGetMerchantName = null;
		String strGetMerchantNameResponse = "";

		try {
			HttpTransportSE androidHttpTransport = new HttpTransportSE(GlobalData.getStrUrl().replaceAll(" ","%20"), 1000000);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			objGetMerchantName = envelope.getResponse();
			strGetMerchantNameResponse = objGetMerchantName.toString();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return strGetMerchantNameResponse;

	}
}
