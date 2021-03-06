package chatmodule;


/**
* chatmodule/ConnectionPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from chat.idl
* lundi 25 janvier 2016 22 h 12 CET
*/

public abstract class ConnectionPOA extends org.omg.PortableServer.Servant
 implements chatmodule.ConnectionOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_clients", new java.lang.Integer (0));
    _methods.put ("_set_clients", new java.lang.Integer (1));
    _methods.put ("_get_recivers", new java.lang.Integer (2));
    _methods.put ("_set_recivers", new java.lang.Integer (3));
    _methods.put ("_get_emitter", new java.lang.Integer (4));
    _methods.put ("_set_emitter", new java.lang.Integer (5));
    _methods.put ("connect", new java.lang.Integer (6));
    _methods.put ("disconnect", new java.lang.Integer (7));
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
       case 0:  // chatmodule/Connection/_get_clients
       {
         String $result[] = null;
         $result = this.clients ();
         out = $rh.createReply();
         chatmodule.ClientsHelper.write (out, $result);
         break;
       }

       case 1:  // chatmodule/Connection/_set_clients
       {
         String newClients[] = chatmodule.ClientsHelper.read (in);
         this.clients (newClients);
         out = $rh.createReply();
         break;
       }

       case 2:  // chatmodule/Connection/_get_recivers
       {
         chatmodule.Receiver $result[] = null;
         $result = this.recivers ();
         out = $rh.createReply();
         chatmodule.LesRecepteursHelper.write (out, $result);
         break;
       }

       case 3:  // chatmodule/Connection/_set_recivers
       {
         chatmodule.Receiver newRecivers[] = chatmodule.LesRecepteursHelper.read (in);
         this.recivers (newRecivers);
         out = $rh.createReply();
         break;
       }

       case 4:  // chatmodule/Connection/_get_emitter
       {
         chatmodule.Emitter $result[] = null;
         $result = this.emitter ();
         out = $rh.createReply();
         chatmodule.LesEmmeteursHelper.write (out, $result);
         break;
       }

       case 5:  // chatmodule/Connection/_set_emitter
       {
         chatmodule.Emitter newEmitter[] = chatmodule.LesEmmeteursHelper.read (in);
         this.emitter (newEmitter);
         out = $rh.createReply();
         break;
       }

       case 6:  // chatmodule/Connection/connect
       {
         String nickname = in.read_string ();
         chatmodule.Receiver rcv = chatmodule.ReceiverHelper.read (in);
         chatmodule.Emitter $result = null;
         $result = this.connect (nickname, rcv);
         out = $rh.createReply();
         chatmodule.EmitterHelper.write (out, $result);
         break;
       }

       case 7:  // chatmodule/Connection/disconnect
       {
         String nickname = in.read_string ();
         this.disconnect (nickname);
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
    "IDL:chatmodule/Connection:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Connection _this() 
  {
    return ConnectionHelper.narrow(
    super._this_object());
  }

  public Connection _this(org.omg.CORBA.ORB orb) 
  {
    return ConnectionHelper.narrow(
    super._this_object(orb));
  }


} // class ConnectionPOA
