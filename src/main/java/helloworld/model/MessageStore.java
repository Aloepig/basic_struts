package helloworld.model;

/**
 * Model class that stores a message.
 * @author Bruce Phillips
 *
 */
public class MessageStore {
    
    private String message;
    
    public MessageStore(String initMessage) {

        if(initMessage.isEmpty()){
            message = "Hello Struts User";
        } else {
            message = initMessage;
        }
    }

    public String getMessage() {
        return message;
    }

}
