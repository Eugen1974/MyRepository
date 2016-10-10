package others;

public interface INode<T> {

	String toString();

	void clear();

	T getData();

	void setNext(INode<T> next);
	
	INode<T> getNext();
	
	void setPrevious(INode<T> previous);
	
	INode<T> getPrevious();
}