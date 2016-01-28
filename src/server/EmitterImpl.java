package server;

import java.util.ArrayList;

import chatmodule.EmitterPOA;
import chatmodule.Receiver;

public class EmitterImpl extends EmitterPOA{

	public String client; 
	@Override
	public void sendMassage(String to, String message) {
		
		ArrayList<Receiver> receivers = ConnectionImpl.receivers;
		for(Receiver r : receivers){
			if(r.client().equals(to)){
				System.out.println("From >> " + client +" >> TO >> "+ to + "  >> " + message);
				r.receive(to, message);
			}
		}
	}

	@Override
	public String client() {
		return client;
	}

	@Override
	public void client(String newClient) {
	client = newClient;
		
	}

}
