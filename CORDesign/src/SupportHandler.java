public interface SupportHandler {
    public void handleSupportRequest(String request);
    public void setNextHandler(SupportHandler nextHandler);
}
