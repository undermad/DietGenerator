import main.Macro;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {



        Map<Macro, Integer> map = new HashMap<>();
        map.put(Macro.PROTEIN,3);
        System.out.println(map.get(Macro.PROTEIN));



    }

}
