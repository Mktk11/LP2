import java.util.ArrayList;

class ArrayStack implements IStackable{
	public ArrayList<Integer> ArrayLista = new ArrayList<Integer>();

	public int size(){
		return ArrayLista.size();
	}
	public void push(int v){
		ArrayLista.add(v);
	}
	public int pop(){
		return (int) ArrayLista.remove(ArrayLista.size()-1);
	}
}
