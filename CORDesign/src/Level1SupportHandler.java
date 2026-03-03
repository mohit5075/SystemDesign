public class Level1SupportHandler implements SupportHandler{
    private SupportHandler supportHandler;
    @Override
    public void handleSupportRequest(String request) {
        if(request.equalsIgnoreCase("Level 1 Issue")){
            System.out.println("Level 1 Support Handler is handling the request: " + request);
        } else {
            if(supportHandler != null){
                System.out.println("Level 1 Support Handler is passing the request to the next handler.");
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
