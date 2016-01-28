package chatmodule;


/**
* chatmodule/ReceiverPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from chat.idl
* lundi 25 janvier 2016 22 h 12 CET
*/

public abstract class ReceiverPOA extends org.omg.PortableServer.Servant
 implements chatmodule.ReceiverOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_message", new java.lang.Integer (0));
    _methods.put ("_set_message", new java.lang.Integer (1));
    _methods.put ("_get_client", new java.lang.Integer (2));
    _methods.put ("_set_client", new java.lang.Integer (3));
    _methods.put ("receive", new java.lang.Integer (4));
    _methods.put ("initClients", new java.lang.Integer (5));
    _methods.put ("addClient", new java.lang.Integer (6));
    _methods.put ("remClient", new java.lang.Integer (7));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // chatmodule/Receiver/_get_message
       {
         String $result = null;
         $result = this.message ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // chatmodule/Receiver/_set_message
       {
         String newMessage = in.read_string ();
         this.message (newMessage);
         out = $rh.createReply();
         break;
       }

       case 2:  // chatmodule/Receiver/_get_client
       {
         String $result = null;
         $result = this.client ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // chatmodule/Receiver/_set_client
       {
         String newClient = in.read_string ();
         this.client (newClient);
         out = $rh.createReply();
         break;
       }

       case 4:  // chatmodule/Receiver/receive
       {
         String from = in.read_string ();
         String message = in.read_string ();
         this.receive (from, message);
         out = $rh.createReply();
         break;
       }

       case 5:  // chatmodule/Receiver/initClients
       {
         String clients[] = chatmodule.ClientsHelper.read (in);
         this.initClients (clients);
         out = $rh.createReply();
         break;
       }

       case 6:  // chatmodule/Receiver/addClient
       {
         String client = in.read_string ();
         this.addClient (client);
         out = $rh.createReply();
         break;
       }

       case 7:  // chatmodule/Receiver/remClient
       {
         String client = in.read_string ();
         this.remClient (client);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:chatmodule/Receiver:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Receiver _this() 
  {
    return ReceiverHelper.narrow(
    super._this_object());
  }

  public Receiver _this(org.omg.CORBA.ORB orb) 
  {
    return ReceiverHelper.narrow(
    super._this_object(orb));
  }


} // class ReceiverPOA
