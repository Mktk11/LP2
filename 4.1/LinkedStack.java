import java.util.LinkedList;

class LinkedStack implements IStackable{
	public LinkedList<Integer> LinkLista = new LinkedList<Integer>();

	public int size(){
		return LinkLista.size();
	}
	public void push(int v){
		LinkLista.addFirst(v);
	}
	public int pop(){
		return (int) LinkLista.removeFirst();
	}

}
