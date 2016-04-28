package move;
//Michael Harney
import java.util.LinkedList;
public class MoveStack {
	LinkedList<IMove> stack;

	MoveStack(){
		this.stack = new LinkedList<IMove>();
	}
	public void addMove(IMove m){
		this.stack.addFirst(m);
	}
	
	public void undoMove(IMove m){
		if(!this.stack.isEmpty()){
			this.stack.pop().undo();
		}
	}
}
