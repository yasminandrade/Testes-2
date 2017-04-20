package br.sceweb.modelo;

import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Months;
import org.joda.time.Years;

public class ManipulaDatas {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(ManipulaDatas.class);
		DateTime dataFinal = new DateTime();
		System.out.println("data final - hoje = " + dataFinal.toString("dd-MM-YYYY"));
		DateTime dataInicio = new DateTime(2015, 1, 1, 0, 0);
		System.out.println("data inicio - inicio do ano = " + dataInicio.toString("dd-MM-YYYY"));
		Days d = Days.daysBetween(dataInicio, dataFinal);
		System.out.println("Diferença dias:" + d.getDays());
		Years y = Years.yearsBetween(dataInicio, dataFinal);
		System.out.println("Diferença anos:" + y.getYears());
		Hours h = Hours.hoursBetween(dataInicio, dataFinal);
		System.out.println("Diferença horas:" + h.getHours());
		Months m = Months.monthsBetween(dataInicio, dataFinal);
		System.out.println("Diferença meses:" + m.getMonths());
	}

	}