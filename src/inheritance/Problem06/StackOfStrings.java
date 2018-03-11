package inheritance.Problem06;

import java.util.ArrayList;

/**
 * Created by Chilly on 03.11.2017 г..
 */
public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }
    public void push(String item) {
        data.add(item);
    }
	public String pop() {
        return data.remove(data.size() - 1);
    }

	public String peek() {
        return data.get(data.size() - 1);
    }

	public boolean isEmpty() {
        return data.isEmpty();
    }
}