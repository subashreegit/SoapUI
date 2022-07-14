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
import com.eviware.soapui.model.testsuite.TestSuite;
import com.eviware.soapui.support.SoapUIException;
//rahulonlinetutor@gmail.com



public class MultipleTestSuite {
//java -jar jenkins.war -httpPort=9090
	
	//java -jar jenkins.war --ajp13Port=-1 --httpPort=9090

		// TODO Auto-generated method stub
	@Test// Run all tests from TestSuite
public void SoapTest() throws XmlException, IOException, SoapUIException
{
		// 
	//	A x=new A();
		//Grab the project
		WsdlProject project=new WsdlProject("C:\\Users\\172739724\\Documents\\mis\\SOAPUI\\Calculator-soapui-project1.xml");
		for(int j=0;j<project.getTestSuiteCount();j++)
		{
			WsdlTestSuite TestSuite =project.getTestSuiteAt(j);
			
		
			for(int i=0;i<TestSuite.getTestCaseCount();i++)
			{
				WsdlTestCase testCase =TestSuite.getTestCaseAt(i);
				
				//Run the testcase
				TestRunner runner=testCase.run(new PropertiesMap(), false);
				Assert.assertEquals(Status.FINISHED, runner.getStatus());
				
				
				
			}
				
			
		}
			
	
		
	}

}
