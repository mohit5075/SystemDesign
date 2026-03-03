import java.util.UUID;

public class TextStyle {
    private String fontName;
    private int fontSize;
    private boolean isBold;
    private boolean isItalic;

    public TextStyle(String fontName, int fontSize, boolean isBold, boolean isItalic) {
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.isBold = isBold;
        this.isItalic = isItalic;
    }

    public String getFontName() {
        return fontName;
    }

    public int getFontSize() {
        return fontSize;
    }

    public boolean isBold() {
        return isBold;
    }

    public boolean isItalic() {
        return isItalic;
    }
}
