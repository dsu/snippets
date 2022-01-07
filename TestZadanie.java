

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestZadanie {
    public static void main(String[] args) {
        String text = "_____Java_is____simple__";

        String[] split = text.split("_");

        boolean lasCharWasBlank = false;
        log.debug("length {}, value {}", split.length, split);
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (String e : split) {
            i++;
            log.debug("char `{}`", e);
            if (!e.equals("")) {
                sb.append(e);
                if (i < split.length) {
                    sb.append("_");
                }
            }
        }
        System.out.println(sb);

    }
}
