public class Level2SupportHandler implements SupportHandler{
    private SupportHandler supportHandler;
    @Override
    public void handleSupportRequest(String request) {
        if(request.equalsIgnoreCase("level 2 issue")){
            System.out.println("Level 2 Support Handler is handling the request: " + request);
        } else {
            System.out.println("No handler available to process the request: " + request);
        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.supportHandler = nextHandler;
    }
}
