import java.io.*;
import java.util.*; 
import java.util.Scanner;
public class Tudo{ 
	public void primeiro(int n1, int n2, int n3, int n4){
		int[] nums = new int[]{n1,n2,n3,n4}; 
		int ma = 0;
		int me = n1;
		int reserva;	
		for(int i =0; i<4; i++){
			if (nums[i]> ma){
				ma = nums[i]; 
			}
			if (nums[i] < me){
				me = nums[i];  
			} 
		}
		while(ma != nums[0] || me != nums[3]){
			int c = 0;
			for (int i = 0; i <nums.length; i++){
				if(nums[i] < nums[i+1]){
					reserva = nums[i+1];
					nums[i+1] = nums[i];
					nums[i] = reserva;
				}
				if (i == 2){
					break;
				}	
			}
		}
		
		System.out.println("\nSequencia em ordem decrescente \n"); 
		for(int i = 0; i<4;i++){
			System.out.println(nums[i]);
		}					
	} 
	public static void main(String[] args){
		Scanner ler = new Scanner(System.in); 
		Tudo atividades = new Tudo();
		int opc;			
		System.out.println("Qual Atividade deseja ver?");
		while(true){
			System.out.println("1 - Ordenar Numeros\n");
			opc = ler.nextInt();
		
			switch(opc){
				case 1: 
					System.out.println("Digite os 4 numeros: ");
					int n1;
					int dig = 0;
					int[] nums = new int[4]; 
					for (int i=0; i < 4; i++){ 
						n1 = ler.nextInt();
						for( int c=0; c <nums.length; c++){
							if (n1 == nums[c]){
								System.out.println("Digite nmeros distintos");
								dig =1; 
								break;
							} 
						}
						if (dig==1){
							break; 
						} 
						else{
							nums[i]=n1;
						} 
					} 
					if(dig==1){
						break;
					} 
					atividades.primeiro(nums[0],nums[1],nums[2],nums[3]);
					break;
				case 999:	
					break;
			}
		}	
	}
} 
