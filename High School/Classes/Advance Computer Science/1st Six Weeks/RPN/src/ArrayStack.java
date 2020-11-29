
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 180869
 */
//public class ArrayStack implements IStack {
public class ArrayStack {

    public ArrayList<Double> li = new ArrayList<>();
    public int index = 0;

    public int size() {
        return li.size();
    }

    public double pop() {
        if (!(isEmpty())) {
            return li.remove(--index);
        }
        return 0;
    }

    public void clear() {
        li.clear();
        index = -1;
    }

    public void push(double a) {
        if (!(isFull())) {
            li.add(a);
            index++;
        }
    }

    public double peek() {
        return li.get(li.size() - 1);
    }

    public boolean isEmpty() {
        return index == -1;
    }

    public boolean isFull() {
        return false || index > li.size();
    }

    public String[] toStringA() {
        String x[] = new String[li.size()];
        for (int i = 0; i < li.size(); i++) {
            x[i] = li.get(i).toString() + "";
        }
        return x;
    }
}
