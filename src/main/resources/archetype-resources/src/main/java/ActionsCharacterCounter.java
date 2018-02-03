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
import de.netsysit.dataflowframework.ui.ActionsProvider;

import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

public class ActionsCharacterCounter extends ModuleBase implements
		ActionsProvider
{
	private String lastInput;

	public void input(String in)
	{
		lastInput = in;
		countCharacters();
	}

	private int characterCount;

	public int getCharacterCount()
	{
		return characterCount;
	}

	private boolean ignoreSpaces;

	public boolean isIgnoreSpaces()
	{
		return ignoreSpaces;
	}

	public void setIgnoreSpaces(boolean ignoreSpaces)
	{
		boolean old = isIgnoreSpaces();
		this.ignoreSpaces = ignoreSpaces;
		send("ignoreSpaces", old, isIgnoreSpaces());
	}

	private void countCharacters()
	{
		int old = getCharacterCount();
//Algorithmus-Implementierung hier
		send("characterCount", old, getCharacterCount());
	}

	public Action[] provideCustomActions()
	{
		return new Action[]{
				new AbstractAction("action")
				{
					public void actionPerformed(ActionEvent e)
					{
						JOptionPane.showMessageDialog(null, new Date().toString());
					}
				}
		};
	}

	public void preparePopupShow()
	{
	}
}
