public class Level0SupportHandler implements SupportHandler{
    private SupportHandler supportHandler;
    @Override
    public void handleSupportRequest(String request) {
        if(request.equalsIgnoreCase("level 0 issue")){
            System.out.println("Level 0 Support Handler is handling the request: " + request);
        } else {
            if(supportHandler != null){
                System.out.println("Level 0 Support Handler is passing the request to the next handler.");
                supportHandler.handleSupportRequest(request);
            } else {
                System.out.println("No handler available to process the request: " + request);
            }
        }
    }

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.supportHandler = nextHandler;
    }
}
