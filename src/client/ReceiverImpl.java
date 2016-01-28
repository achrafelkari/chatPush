package client;

import java.util.ArrayList;

import chatmodule.ReceiverPOA;

public class ReceiverImpl extends ReceiverPOA {

	public String client = "" ; 
	public String message = "";
	@Override
	public void receive(String from, String message) {
		
		this.message = from + " : " + message; 
	}

	@Override
	public void initClients(String[] clients) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClient(String client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remClient(String client) {
		// TODO Auto-generated method stub
	}

	@Override
	public String client() {
		return client;
	}

	@Override
	public void client(String newClient) {
	client = newClient;
		
	}

	@Override
	public String message() {
		return message;
	}

	@Override
	public void message(String newMessage) {
		
		message= newMessage;
	}

}
