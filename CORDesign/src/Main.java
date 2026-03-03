public class Main {
    public static void main(String[] args) {
        SupportHandler level0Handler = new Level0SupportHandler();
        SupportHandler level1Handler = new Level1SupportHandler();
        level0Handler.setNextHandler(level1Handler);
        SupportHandler level2Handler = new Level2SupportHandler();
        level1Handler.setNextHandler(level2Handler);
        level0Handler.handleSupportRequest("level 3 issue");
    }
}