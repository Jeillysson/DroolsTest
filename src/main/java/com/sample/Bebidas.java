package com.sample;

public class Bebidas {
	
	public enum tipoBebida{
		REFRIGERANTES (1),SUCOS (2), CAFE (3);
		
		private int valor;
		
		private tipoBebida(int valorN){
			this.valor = valorN;
		}
		
		public int getValor(){
			return valor;
		}
		
	}
	
	public enum tipoRefrigerante{
		CocaCola(1,3.00f),Guarana(2,3.00f),Fanta(3,3.00f),Sprite(4,3.00f),Dolly(5,7.50f);
		
		private int valor;
		private float preco;
		
		private tipoRefrigerante(int valor, float preco){
			this.valor = valor;
			this.preco = preco;
		}
		
		public int getValor(){
			return valor;
		}
		
		public float getPreco(){
			return preco;
		}
		
	}
	
	public enum tipoSucos{
		Graviola(1,2.00f), Caja(2,2.00f),Acerola(3,2.00f);
		
		private int valor;
		private float preco;
		
		private tipoSucos(int valor,float preco){
			this.valor = valor;
			this.preco = preco;
		}
		
		public int getValor(){
			return valor;
		}
		
		public float getPreco(){
			return preco;
		}
	}
	
	public enum tipoCafe{
		ComLeite(1,2.00f), SemLeite(2,1.00f);
		
		private int valor;
		private float preco;
		
		private tipoCafe(int valor,float preco){
			this.valor = valor;
			this.preco = preco;
		}
		
		public int getValor(){
			return valor;
		}
		
		public float getPreco(){
			return preco;
		}
	
	}
	
	public Bebidas(){}

}


