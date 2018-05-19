/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tempos21.temps;

/**
 *
 * @author Usuario
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;

public class Data {
	public Data() {
		setFormat("yyyy-MM-dd HH:mm:ss");
		// TODO Auto-generated constructor stub
	}
	public Data(String format) {
		setFormat(format);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the format
	 */
	public static String getFormat() {
		return format;
	}
	/**
	 * @param format the format to set
	 */
	public static void setFormat(String format) {
		Data.format = format;
	}

	private static String format;

	public String retornaDataActual(){
        Date tempsActual = new Date();
        SimpleDateFormat temps = new SimpleDateFormat(getFormat());
		return temps.format(tempsActual);
	}
	public Temps retornarDataRespecteLactual(int dies){
        SimpleDateFormat sdf = new SimpleDateFormat(getFormat());
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(retornaDataActual()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c.add(Calendar.DATE, dies);
        return new Temps(c.get(Calendar.YEAR),
        				 c.get(Calendar.MONTH),
        				 c.get(Calendar.DAY_OF_MONTH),
        				 c.get(Calendar.DAY_OF_WEEK),
        				 c.get(Calendar.WEEK_OF_MONTH),
        				 c.get(Calendar.WEEK_OF_YEAR),
        				 c.get(Calendar.DAY_OF_YEAR));
	}


	public String retornaDataEspecificada(int dia,int mes,int any){
		//recordar que el Gener és 0 i el desembre 11.
		Calendar c = Calendar.getInstance();
		c.set(any, mes, dia);
		Date date = c.getTime();
        SimpleDateFormat temps = new SimpleDateFormat(getFormat());
		return temps.format(date);

	}

	public long diferenciaDates(String dataIn,String dataFi){
        Calendar cIn = calendari(dataIn);
        Calendar cFi = calendari(dataFi);
        long lcIn = cIn.getTimeInMillis();
        long lcFi = cFi.getTimeInMillis();
        return (lcFi/(1000*60*60*24))-(lcIn/(1000*60*60*24));
	}

	public Temps diferenciaEntreDates(String dataIn,String dataFi){
        Calendar cIn = calendari(dataIn);
        Calendar cFi = calendari(dataFi);
        long lcIn = cIn.getTimeInMillis();
        long lcFi = cFi.getTimeInMillis();
        //System.out.println(((lcFi-lcIn)/1000)/(60*60*24));
        long l = (lcFi/1000-lcIn/1000);
        long dies = l/(60*60*24);
        long hores = (l-dies*(60*60*24))/(60*60);
        long minuts = (l-dies*(60*60*24)-hores*(60*60))/60;
        long segons = (l-dies*(60*60*24)-hores*(60*60)-minuts*60);
        return new Temps(dies, hores, minuts, segons);
	}

	public String modificarData(String data,int any,int mes, int dia,int hora,int minut,int segon){
        SimpleDateFormat sdf = new SimpleDateFormat(getFormat());
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(data));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c.add(Calendar.SECOND, segon);
        c.add(Calendar.MINUTE, minut);
        c.add(Calendar.HOUR, hora);
        c.add(Calendar.DATE, dia);
        c.add(Calendar.MONTH, mes);
        c.add(Calendar.YEAR, any);
        return sdf.format(c.getTime());
	}
	public Temps retornarDadesDeLaDataEspecificada(String data,int dies){
        SimpleDateFormat sdf = new SimpleDateFormat(getFormat());
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(data));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c.add(Calendar.DATE, dies);
        return new Temps(c.get(Calendar.YEAR),
        				 c.get(Calendar.MONTH),
        				 c.get(Calendar.DAY_OF_MONTH),
        				 c.get(Calendar.DAY_OF_WEEK),
        				 c.get(Calendar.WEEK_OF_MONTH),
        				 c.get(Calendar.WEEK_OF_YEAR),
        				 c.get(Calendar.DAY_OF_YEAR));
	}

    public Calendar calendari(String dt){
        SimpleDateFormat sdf = new SimpleDateFormat(getFormat());
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return c;

    }
    public long retornarTempActual(){
        Date tempsActual = new Date();
    	return tempsActual.getTime();
    }
    public Temps diferenciaEntreTemps(long t1,long t2){
    	long l = (t1-t2);
    	if(l<0) l = (t2-t1);
        long dies = l/(60*60*24*1000);
        long hores = (l-dies*(60*60*24*1000))/(60*60*1000);
        long minuts = (l-dies*(60*60*24*1000)-hores*(60*60*1000))/(60*1000);
        long segons = (l-dies*(60*60*24*1000)-hores*(60*60*1000)-minuts*(60*1000))/1000;
        long millessimesDeSegon = (l-dies*(60*60*24*1000)-hores*(60*60*1000)-minuts*(60*1000)-segons*1000);
    	return new Temps(dies, hores, minuts, segons,millessimesDeSegon);
    }


    public void compararDades(Calendar c1,Calendar c2){
        SimpleDateFormat sdf = new SimpleDateFormat(getFormat());
        sdf.format(c1.getTime());
        if(c1.before(c2)){
            System.out.println(sdf.format(c1.getTime())+" < "+sdf.format(c2.getTime()));
        }else if(c1.after(c2)){
            System.out.println(sdf.format(c1.getTime())+" > "+sdf.format(c2.getTime()));
        }else{
            System.out.println(sdf.format(c1.getTime())+" = "+sdf.format(c2.getTime()));
        }
    }
}
