package corbaClient;

import corbaConversion.IConversionRemote;
import corbaConversion.IConversionRemoteHelper;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConversionClient {
    public static void main(String[] args) {
        Context ctx = null;
        try {
            ctx = new InitialContext();
        java.lang.Object  ref = ctx.lookup("0D");

            IConversionRemote stub = IConversionRemoteHelper.narrow((org.omg.CORBA.Object)ref);
            System.out.println(stub.conversionMontant(70.00));
            System.out.println(stub.conversionMontant(150.00));
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
