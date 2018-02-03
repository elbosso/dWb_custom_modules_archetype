/*
Copyright (c) 2012-2018.

Juergen Key. Alle Rechte vorbehalten.

Weiterverbreitung und Verwendung in nichtkompilierter oder kompilierter Form,
mit oder ohne Veraenderung, sind unter den folgenden Bedingungen zulaessig:

   1. Weiterverbreitete nichtkompilierte Exemplare muessen das obige Copyright,
die Liste der Bedingungen und den folgenden Haftungsausschluss im Quelltext
enthalten.
   2. Weiterverbreitete kompilierte Exemplare muessen das obige Copyright,
die Liste der Bedingungen und den folgenden Haftungsausschluss in der
Dokumentation und/oder anderen Materialien, die mit dem Exemplar verbreitet
werden, enthalten.
   3. Weder der Name des Autors noch die Namen der Beitragsleistenden
duerfen zum Kennzeichnen oder Bewerben von Produkten, die von dieser Software
abgeleitet wurden, ohne spezielle vorherige schriftliche Genehmigung verwendet
werden.

DIESE SOFTWARE WIRD VOM AUTOR UND DEN BEITRAGSLEISTENDEN OHNE
JEGLICHE SPEZIELLE ODER IMPLIZIERTE GARANTIEN ZUR VERFUEGUNG GESTELLT, DIE
UNTER ANDEREM EINSCHLIESSEN: DIE IMPLIZIERTE GARANTIE DER VERWENDBARKEIT DER
SOFTWARE FUER EINEN BESTIMMTEN ZWECK. AUF KEINEN FALL IST DER AUTOR
ODER DIE BEITRAGSLEISTENDEN FUER IRGENDWELCHE DIREKTEN, INDIREKTEN,
ZUFAELLIGEN, SPEZIELLEN, BEISPIELHAFTEN ODER FOLGENDEN SCHAEDEN (UNTER ANDEREM
VERSCHAFFEN VON ERSATZGUETERN ODER -DIENSTLEISTUNGEN; EINSCHRAENKUNG DER
NUTZUNGSFAEHIGKEIT; VERLUST VON NUTZUNGSFAEHIGKEIT; DATEN; PROFIT ODER
GESCHAEFTSUNTERBRECHUNG), WIE AUCH IMMER VERURSACHT UND UNTER WELCHER
VERPFLICHTUNG AUCH IMMER, OB IN VERTRAG, STRIKTER VERPFLICHTUNG ODER
UNERLAUBTE HANDLUNG (INKLUSIVE FAHRLAESSIGKEIT) VERANTWORTLICH, AUF WELCHEM
WEG SIE AUCH IMMER DURCH DIE BENUTZUNG DIESER SOFTWARE ENTSTANDEN SIND, SOGAR,
WENN SIE AUF DIE MOEGLICHKEIT EINES SOLCHEN SCHADENS HINGEWIESEN WORDEN SIND.
 */

package ${package};

import de.netsysit.dataflowframework.modules.ModuleBase;

@de.elbosso.util.lang.annotations.BeanInfo
public class Adder extends ModuleBase
{
	Number[] numbers;

	public Adder()
	{
		super();
		numbers = new Number[0];
	}

	@de.elbosso.util.lang.annotations.Method(
			keyValueStore = {
					//@de.elbosso.util.lang.annotations.KeyValueStore(key="de.netsysit.dataflowframework.ui.Slot.AUTOCONNECTALLOWEDATTRIBUTE",value="java.lang.Boolean.TRUE"),
					@de.elbosso.util.lang.annotations.KeyValueStore(key="\"VariablePortCount\"", value="Boolean.TRUE")
		}
	)
	public void input(Number in, String spec)
	{
		java.lang.String remainder = spec.substring("input".length());
		int i = remainder.length();
		if (i > 0)
			i = java.lang.Integer.parseInt(remainder);
		while (i >= numbers.length)
		{
			Number[] nt = new Number[i + 1];
			System.arraycopy(numbers, 0, nt, 0, numbers.length);
			numbers = nt;
		}
		numbers[i] = in;
		process();
	}

	private double processed;

	@de.elbosso.util.lang.annotations.Property
	public double getProcessed()
	{
		return processed;
	}

	private void process()
	{
		double old = getProcessed();
		double t = 0.0;
		for (Number number : numbers)
		{
			if (number != null)
			{
				t += number.doubleValue();
			}
		}
		processed = t;
		send("processed", old, getProcessed());
	}
	@de.elbosso.util.lang.annotations.Event(
			unicast = true
	)
	@Override
	public void addPropertyChangeListener(java.beans.PropertyChangeListener l)
	{
		super.addPropertyChangeListener(l);
	}

	@de.elbosso.util.lang.annotations.Event(
			inDefaultEventSet = true
	)
	@Override
	public void removePropertyChangeListener(java.beans.PropertyChangeListener l)
	{
		super.removePropertyChangeListener(l);
	}
}	
