package main;

import java.util.Scanner;

import model.Node;
import model.TurnsQueue;

public class Main {
	
	public static Scanner rd=new Scanner(System.in);
	public static TurnsQueue que;
	public static int trns;
	
	public static void main(String[] args) {
		trns=1;
		que=new TurnsQueue();
		menu();
	}
	
	public static void addTurn() {
		que.add(new Node(trns));
		trns++;
	}
	
	public static void showTurn(){
		if(que.getHead()==null) {
			System.out.println("No hay turnos en espera.");
		}else {
			System.out.println("El turno actual es: "+que.getTurn().getVal()+".");
		}
	}
	
	public static void passTurn() { 
		System.out.println(que.pass());
	}
	
	public static void deleteTurn() {
		if(que.getTurn()==null) {
			System.out.println("No hay un turno para eliminar.");
		}else {
			que.delete(que.getTurn());
		}
	}
	public static void menu() {
		boolean contnue=true;
		int select=0;
		 do{
			System.out.println("Bienvenido al sistema de turnos de Bancolombia:");
			System.out.println("Seleccione:");
			System.out.println("1. Dar turno.");
			System.out.println("2. Mostrar turno actual.");
			System.out.println("3. Pasar turno actual.");
			System.out.println("4. Eliminar turno actual.");
			System.out.println("9. Salir.");
			
			select=Integer.parseInt(rd.nextLine());
			System.out.print("\033[H\033[2J");
	        System.out.flush();
			
			switch(select) {
			case 1:	addTurn();
					break;
			case 2:	showTurn();
					break;
			case 3:	passTurn();
					break;
			case 4:	deleteTurn();
					break;
			case 9: contnue=false;
					break;
			default:
				System.out.println("Seleccione una opcion correcta.");
			}
			rd.nextLine();
		}while(contnue);
		
	}

}
