package server;

import java.util.ArrayList;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import chatmodule.ConnectionPOA;
import chatmodule.Emitter;
import chatmodule.EmitterHelper;
import chatmodule.Receiver;

public class ConnectionImpl extends ConnectionPOA{
 
	private ORB orb ;
    public static ArrayList<Emitter> emitters = new ArrayList<Emitter>();
    public static ArrayList<Receiver> receivers = new ArrayList<Receiver>();
    public static ArrayList<String> clients = new ArrayList<String>();

    public void setOrb(ORB orb){
    	this.orb = orb;
    }
    
    @Override
	public Emitter connect(String nickname, Receiver rcv) {
    
    	
    if(isConnected(nickname)){
    	for(Emitter e : emitters){
    		
    		if(nickname.equals(e.client())){
    			System.out.println(nickname+ " est déjà connécté  ");
    			return e; // je sort et je retourne l'émeteur ! 
    		}
    		}
    	
    }	
    	
    
     EmitterImpl emitter = new EmitterImpl();
     receivers.add(rcv); //  J'ajoute le receiver dans le ArrayList
     clients.add(nickname);
     System.out.println("Le client " + nickname  + " vient de se connecter ! ");
     Emitter em  = null;
 	
     POA rootpoa;
 	try {
	
		rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		rootpoa.the_POAManager().activate();
		org.omg.CORBA.Object ref = rootpoa.servant_to_reference(emitter);
		em = EmitterHelper.narrow(ref);
		em.client(nickname);
		emitters.add(em); // on ajoute cet emmetteur ! 
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return em;
	}

    public boolean isConnected(String user){
    	
    	for(Receiver r :  receivers){ // on va pou
    		
    		if(user.equals(r.client()))
    				return true;
    		
    	}
    	
    	
    	return false;
    }
    
	@Override
	public void disconnect(String nickname) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String[] clients() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void clients(String[] newClients) {
	}


	@Override
	public Receiver[] recivers() { // je recois les recpteurs de mes clients ! 
		System.out.println("'entrr");
		Receiver[] ems = new Receiver[receivers.size()];
		int k =0;
		for(Receiver e : receivers){
			ems[k] = e;
			k++;
		}
		return ems;
	}


	@Override
	public void recivers(Receiver[] newRecivers) {
	}


	@Override
	public Emitter[] emitter() {
		System.out.println("'entrr");
		Emitter[] ems = new Emitter[emitters.size()];
		int k =0;
		for(Emitter e : emitters){
			ems[k] = e;
			k++;
		}
		return ems;
	}


	@Override
	public void emitter(Emitter[] newEmitter) {
	}

}
