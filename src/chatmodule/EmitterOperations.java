package chatmodule;


/**
* chatmodule/EmitterOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from chat.idl
* lundi 25 janvier 2016 22 h 12 CET
*/

public interface EmitterOperations 
{
  String client ();
  void client (String newClient);
  void sendMassage (String to, String message);
} // interface EmitterOperations
