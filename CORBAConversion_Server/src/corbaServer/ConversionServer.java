package corbaServer;

import Service.ConversionImpl;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ConversionServer {
    public static void main(String[] args) {
        try {
            // Initialisation de l'ORB (Object Request Broker)
            ORB orb = ORB.init(args, null);

            // Obtention du POA (Portable Object Adapter)
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            // Création de l'objet distant (servant) et obtention de la référence
            ConversionImpl conversionImpl = new ConversionImpl();

            Context ctx = new InitialContext();

            ctx.rebind("0D", rootPOA.servant_to_reference(conversionImpl));
            // Attente des appels du client
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
