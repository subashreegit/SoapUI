package soap;
import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class testSeperatly {

	
	@Test
	public void singleTest() throws XmlException, IOException, SoapUIException
	{
		WsdlProject project=new WsdlProject("C:\\Users\\172739724\\Documents\\mis\\SOAPUI\\Calculator-soapui-project1.xml");
		//Grab the Test suite in the project
		WsdlTestSuite testsuite=project.getTestSuiteByName("CalculatorSoap TestSuite");
		
		WsdlTestCase testCase1= testsuite.getTestCaseByName("Add TestCase");
		WsdlTestCase testCase2= testsuite.getTestCaseByName("Subtract TestCase");
		TestRunner runner1=testCase1.run(new PropertiesMap(), false);
		TestRunner runner2=testCase2.run(new PropertiesMap(), false);
		Assert.assertEquals(Status.FINISHED, runner1.getStatus());
		Assert.assertEquals(Status.FINISHED, runner2.getStatus());
		
		
	}
}