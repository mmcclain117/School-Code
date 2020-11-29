package Aparts;

/**
 *
 * @author Master
 */
public class BodyVar {

    String body;

    BodyVar(String y) {
        body = narrowBody(y);
    }

    public static String narrowBody(String a) {
        String b = a.substring(a.indexOf("<body>"));
        String c = b.substring(b.indexOf("<div id=\"body\">"));
        String d = c.substring(c.indexOf("<div style=\"position: relative;\">"));
        String e = d.substring(d.indexOf("<div id=\"pageContent\" class=\"content-with-sidebar\">"));
        String f = e.substring(e.indexOf("<div class=\"problemindexholder\" problemindex="));
        String g = f.substring(f.indexOf("<div class=\"ttypography\">"));
        String h = g.substring(g.indexOf("<div class=\"problem-statement\">"));
        return h.substring(0, h.indexOf("<script type=\"text/javascript\">"));
    }

    public String getTitle() {
        String title = body.substring(body.indexOf("title\">"));
        title = title.substring(7, title.indexOf("</div"));
        return title;
    }

    public String getTimeLimit() {
        String timeLimit = body.substring(body.indexOf("time limit per test") + 25);
        timeLimit = timeLimit.substring(0, timeLimit.indexOf(" "));
        return timeLimit;
    }

    public String getMemoryLimit() {
        String te = body.substring(body.indexOf("memory limit per test") + 27);
        String memoryLimit = te.substring(0, te.indexOf(" "));
        return memoryLimit;
    }

    public String getInput() {
        String te = body.substring(body.indexOf(">input<") + 12);
        String input = te.substring(0, te.indexOf("<"));
        return input;
    }

    public String getOutput() {
        String te = body.substring(body.indexOf(">output<") + 13);
        String output = te.substring(0, te.indexOf("<"));
        return output;
    }

    public String getStory() {
        String parPattern = "</p><p>";
        String parts[] = body.split(parPattern);
        String story = "";
        for (int i = 0; i < parts.length - 1; i++) {
            story += parts[i] + "\n";
        }
        String partsCur = parts[parts.length - 1];
        story += partsCur.substring(0, partsCur.indexOf("<"));
        return story;
    }

    public String getInputStory() {
        String te = body.substring(body.indexOf(">Input<") + 15);
        String inputStory = te.substring(0, te.indexOf("</p"));
        return inputStory;
    }

    public String getOutputStory() {
        String te = body.substring(body.indexOf(">Output<") + 16);
        String outputStory = te.substring(0, te.indexOf("</p"));
        return outputStory;
    }

    public String getInputVar() {
        String Examples = body.substring(body.indexOf(">Examples<") + 9);
        Examples = Examples.substring(Examples.indexOf(">Input<") + 17);
        String inputVal = Examples.substring(0, Examples.indexOf("</p")).replaceAll("<br />", "\n");
        return inputVal;
    }

    public String getOutputVar() {
        String Examples = body.substring(body.indexOf(">Examples<") + 9);
        Examples = Examples.substring(Examples.indexOf(">Output<") + 18);
        String outputVal = Examples.substring(0, Examples.indexOf("</p")).replaceAll("<br />", "\n");
        return outputVal;
    }

    public String getName() {
        String title = getTitle();
        String fin = "";
        String name = title.replace('.', '_');
        String x[] = name.split("\\s+");
        for (String u : x) {
            fin += u.substring(0, 1).toUpperCase() + u.substring(1);
        }
        fin = fin.replaceAll("[?!-:/+,.]+", "");
        return fin;
    }
}
