package Aparts;

/**
 *
 * @author Master
 */
public class TagVar {

    String tag;

    public TagVar(String a) {
        tag = narrowTags(a);
    }

    private static String narrowTags(String a) {
        String b = a.substring(a.indexOf("<body>"));
        String c = b.substring(b.indexOf("<div id=\"body\">"));
        String d = c.substring(c.indexOf("<div style=\"position: relative;\">"));
        String e = d.substring(d.indexOf("<div id=\"sidebar\">"));
        String f = e.substring(e.indexOf("<span class=\"tag-box\""));
        return f.substring(0, f.indexOf("<div style"));
    }
// Dont know if use

    public String tagsVariable() {
        String[] sst = tag.split("<span");
        String ret = "";
        for (int i = 1; i < sst.length; i++) {
            String y[] = getTag(sst[i]).split("\\s+");
            ret += y[y.length - 1] + "\n";
        }
        return ret; // 11
    }

    public String getTag(String a) {
        String b = a.substring(a.indexOf("title=") + 5);
        String c = b.substring(1, b.indexOf("</span>"));
        String d = c.replaceAll(">", "\n");
        return d.replace("\"", "");
    }
}
