import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Scrabble {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String scoreWords = request.queryParams("scoreWord");
      char[] charArray = scoreWords.toCharArray();
      Integer scrabbleScore = ScrabbleSum(charArray);

      model.put("scrabbleScore", scrabbleScore);
      model.put("scoreWord", request.queryParams("scoreWord"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
}

    public static Integer ScrabbleSum(char[] charArray) {

        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
        myMap.put('a', 1);
        myMap.put('e', 1);
        myMap.put('i', 1);
        myMap.put('o', 1);
        myMap.put('u', 1);
        myMap.put('l', 1);
        myMap.put('n', 1);
        myMap.put('r', 1);
        myMap.put('s', 1);
        myMap.put('t', 1);
        myMap.put('d', 2);
        myMap.put('g', 2);
        myMap.put('b', 3);
        myMap.put('c', 3);
        myMap.put('m', 3);
        myMap.put('p', 3);
        myMap.put('f', 4);
        myMap.put('h', 4);
        myMap.put('v', 4);
        myMap.put('w', 4);
        myMap.put('y', 4);
        myMap.put('k', 5);
        myMap.put('j', 8);
        myMap.put('x', 8);
        myMap.put('q', 10);
        myMap.put('f', 10);

        Integer sum = 0;

        for (Integer i = 0; i < charArray.length; i++) {
            char letter = charArray[i];
            Integer letterTotal = myMap.get(letter);
            sum += letterTotal;
        }
        return sum;

        }
}
