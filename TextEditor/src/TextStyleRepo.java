import java.util.HashMap;
import java.util.Map;

public class TextStyleRepo {
    private Map<String,TextStyle> textStyleMap = new HashMap<>();
    public TextStyle getTextStyle(String fontName, int fontSize,boolean isBold,boolean isItalic){
        String id = fontName+"-"+fontSize+"-"+isBold+"-"+isItalic;
        TextStyle textStyle = new TextStyle(fontName,fontSize,isBold,isItalic);
        return textStyleMap.putIfAbsent(id,textStyle);
    }
}
