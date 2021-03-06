package by.learning.composite.parser;

import by.learning.composite.component.ComponentType;
import by.learning.composite.component.TextComponent;
import by.learning.composite.component.TextComposite;
import by.learning.composite.component.CustomSymbol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SymbolParser extends AbstractParser {

    private static final Logger logger = LogManager.getLogger(SymbolParser.class);
    private static final String SYMBOL_REGEX = "";

    public SymbolParser() {
        super(null);
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent result = new TextComposite(ComponentType.WORD);
        List<String> symbols = parseText(text);
        for (String symbol : symbols) {
            CustomSymbol leaf = new CustomSymbol(symbol.charAt(0));
            result.add(leaf);
        }
        return result;
    }

    private List<String> parseText(String text) {
        String[] splitText = text.split(SYMBOL_REGEX);
        List<String> result = Arrays.stream(splitText).filter(x -> !x.equals("")).collect(Collectors.toList());
        return result;
    }
}
