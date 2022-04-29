package model;

public class TurnsQueue{
	
	private Node head;
	private Node turn;
	
	public TurnsQueue() {
		
		this.head=null;
		this.turn=null;
	}
	
	public String add(Node nd) {
		String msg="Se ha agregado el turno.";
		if(head==null) {
			nd.setNext(nd);
			nd.setPrev(nd);
			head=nd;
			turn=nd;
		}else {
			nd.setPrev(head.getPrev());
			head.getPrev().setNext(nd);
			head.setPrev(nd);
			nd.setNext(head);
		}
		return msg;
	}
	
	public String pass() {
		String msg="";
		if(head==null) {
			msg+="No hay ningun turno en espera.";
		}else {
			turn.setPass(turn.getPass()+1);
			turn=turn.getNext();
			if(turn.getPrev().getPass()==3) {
				delete(turn.getPrev());
			}
			msg="Se paso el turno.";
		}
		return msg;
	}
	
	public String delete(Node nd) {
		String msg="Turno eliminado.";
		if(nd.getNext()==nd) {
			head=null;
			turn=null;
			msg+=" No quedan mas turnos.";
		}else {
			if(head==nd) {
				head=nd.getNext();
			}
			if(turn==nd) {
				turn=nd.getNext();
			}
			nd.getNext().setPrev(nd.getPrev());
			nd.getPrev().setNext(nd.getNext());
			nd.setNext(null);
			nd.setPrev(null);
		}
		return msg;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTurn() {
		return turn;
	}

	public void setTurn(Node turn) {
		this.turn = turn;
	}
}
