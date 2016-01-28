package client;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import chatmodule.Connection;
import chatmodule.ConnectionHelper;
import chatmodule.Emitter;
import chatmodule.ReceiverHelper;

public class Client2  {

	public static void main(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, AdapterInactive, ServantNotActive, WrongPolicy {

		// Create the ORB (or connect to it in our case)
					ORB orb = ORB.init(args,null);
					org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
					// load the corba Naming Servce 
					NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
					Connection connexion = (Connection) ConnectionHelper.narrow(ncRef.resolve_str("ABC"));
					
					ReceiverImpl receiverImpl = new ReceiverImpl();
					
					POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
					rootpoa.the_POAManager().activate();
					org.omg.CORBA.Object ref = rootpoa.servant_to_reference(receiverImpl);
				
					chatmodule.Receiver receiver = ReceiverHelper.narrow(ref);
					receiver.client("Achraf");
					
					Emitter emitter= connexion.connect("Achraf",  receiver);// je me connect et j'envoi le message à Achraf ! 
					emitter.sendMassage("titi", "Salut TITI , je t'envoi mon message, je suis Achraf ajoute moi  !");
					
					
					
					
					// je lance un thread pour afficher les messages des autres utilisateurs ! 
					new Thread(){
				        public void run(){
				        
				       while(true) {
				             
				         if(!"".equals(receiver.message())){
				          System.out.println(receiver.message());
				         receiver.message(""); // je donne  à ce message un vide car il est déja affiché ! 
				         }
				          try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				        }
				       
				        }
				     
				      }.start();
					

	}

	
}
