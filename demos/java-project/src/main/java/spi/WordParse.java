package spi;

public class WordParse implements IParseDoc {
    @Override
    public void parse() {
        System.out.println("解析word");
    }
}
