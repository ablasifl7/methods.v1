/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tempos21.temps;

/**
 *
 * @author Usuario
 */
public class Temps {


	public Temps(long dies, long hores, long minuts, long segons) {
		super();
		this.dies = dies;
		this.hores = hores;
		this.minuts = minuts;
		this.segons = segons;
	}

	public Temps(long dies, long hores, long minuts, long segons,
			long millessimesDeSegon) {
		super();
		this.dies = dies;
		this.hores = hores;
		this.minuts = minuts;
		this.segons = segons;
		this.millessimesDeSegon = millessimesDeSegon;
	}

	public Temps(int any, int mes, int dia, int setmana, int setmanaMes,
			int setmanaAny, int diaAny) {
		super();
		this.any = any;
		this.mes = mes;
		this.dia = dia;
		this.setmana = setmana;
		this.setmanaMes = setmanaMes;
		this.setmanaAny = setmanaAny;
		this.diaAny = diaAny;
	}


	/**
	 * @return the dies
	 */
	public long getDies() {
		return dies;
	}
	/**
	 * @param dies the dies to set
	 */
	public void setDies(long dies) {
		this.dies = dies;
	}
	/**
	 * @return the hores
	 */
	public long getHores() {
		return hores;
	}
	/**
	 * @param hores the hores to set
	 */
	public void setHores(long hores) {
		this.hores = hores;
	}
	/**
	 * @return the minuts
	 */
	public long getMinuts() {
		return minuts;
	}
	/**
	 * @param minuts the minuts to set
	 */
	public void setMinuts(long minuts) {
		this.minuts = minuts;
	}
	/**
	 * @return the segons
	 */
	public long getSegons() {
		return segons;
	}
	/**
	 * @param segons the segons to set
	 */
	public void setSegons(long segons) {
		this.segons = segons;
	}

	public long getMillessimesDeSegon() {
		return millessimesDeSegon;
	}
	public void setMillessimesDeSegon(long millessimesDeSegon) {
		this.millessimesDeSegon = millessimesDeSegon;
	}
	/**
	 * @return the any
	 */
	public int getAny() {
		return any;
	}
	/**
	 * @return the mes
	 */
	public int getMes() {
		return mes;
	}
	/**
	 * @return the dia
	 */
	public int getDia() {
		return dia;
	}
	/**
	 * @return the setmana
	 */
	public int getSetmana() {
		if(setmana==1) return 6;
		return setmana - 2;
	}
	/**
	 * @return the setmanaMes
	 */
	public int getSetmanaMes() {
		return setmanaMes;
	}
	/**
	 * @return the setmanaAny
	 */
	public int getSetmanaAny() {
		return setmanaAny;
	}
	/**
	 * @return the diaAny
	 */
	public int getDiaAny() {
		return diaAny;
	}
	public String strDia(){
		return String.format("%02d", dia);
	}
	public String strMes(){
		return String.format("%02d", mes+1);
	}
	public String strAny(){
		return String.format("%04d", any);
	}


	private int any;
	private int mes;
	private int dia;
	private int setmana;
	private int setmanaMes;
	private int setmanaAny;
	private int diaAny;

	private long dies;
	private long hores;
	private long minuts;
	private long segons;
	private long millessimesDeSegon;

	public static void espera(long milisegons){
		try {
			Thread.sleep(milisegons);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}