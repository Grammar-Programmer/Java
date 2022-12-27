package diaSemana;

public enum DiaDaSemana {
	SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO;

	public DiaDaSemana nextDay() {
		int index = ordinal() + 1;
		if (index < values().length)
			return values()[index];

		return values()[0];
	}
}

/******************************************************************************
 * Written By: Grammar-Programmer.
 ******************************************************************************/
