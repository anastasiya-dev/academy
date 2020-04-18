package by.academy.lesson4.Homework2.HW2_Task2;

public class HW2_Task2_Money implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*По сути тут сделано только под положительные числа
	 *Не знаю, надо ли было адаптировать еще под отрицательные
	 *Свой сложный расчет для деления и умножения оставила,
	 *т.к. не знаю, как по-другому получать корректный результат
	 *при использовании в качестве аргумента дробные числа с разным количеством знаков
	 *после запятой, чтобы всегда приходить к округлению до копеек
	 */
		
	long rub;
	char kop;
	long rubOp;
	char kopOp;
	double value;
		
	public HW2_Task2_Money(double value) {
		System.out.println("Starting value:");
		transferToRub(value);
		transferToKop(value);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(rub);
		builder.append(",");
		if ((int) kop < 10) {
		builder.append(0);	
		}
		builder.append((int) kop);
		builder.append("\n");
		return builder.toString();
	}

	public void transferToRub(double value) {
		this.rub = (int) value;
	}

	public void transferToKop(double value) {
		this.kop = (char) ((value * 100) % 100);
	}
	
	public long setRub(double valueOp) {
		rubOp = (int) valueOp;
		return rubOp;
	}

	public char setKop(double valueOp) {
		kopOp = (char) ((valueOp * 100) % 100);
		return kopOp;
	}

	public String resPrint (long rub, char kop) {
		StringBuilder builderRes = new StringBuilder();
		builderRes.append(rub);
		builderRes.append(",");
		if ((int) kop < 10) {
		builderRes.append(0);	
		}
		builderRes.append((int) kop);
		return builderRes.toString();
	}
	
	public double addition(double valueForAdd) {
		
		System.out.println("Addition: " + resPrint(rub, kop) + " plus " +
				resPrint(setRub(valueForAdd), setKop(valueForAdd)));
		
		rub += setRub(valueForAdd);
		kop += setKop(valueForAdd);
		if ((int) kop >= 100) {
			rub++;
			kop -= 100;
		}
		double addResult = rub + ((int) kop * 0.01);
		System.out.println(resPrint(rub, kop) + "\n");
		return addResult;
	}

	public double subtraction(double valueForSub) {
		
		System.out.println("Subtraction: " + resPrint(rub, kop) + " minus " +
				resPrint(setRub(valueForSub), setKop(valueForSub)));
		rub -= setRub(valueForSub);
		
		if (kop >= setKop(valueForSub)) {
			kop -= setKop(valueForSub);
		}
		else {
			kop = (char) ((int) kop + 100 - (int)setKop(valueForSub));
			rub--;
		}
						
		double subResult = rub + ((int) kop * 0.01);
		System.out.println(resPrint(rub, kop) + "\n");
		return subResult;
	}
	
	public void parity (double valueForComp) {
		
		System.out.println("Parity check:");
				
		if (rub > setRub(valueForComp) ||
				(rub == setRub(valueForComp) && (int) kop > (int) setKop(valueForComp))) {
			System.out.println(resPrint(rub, kop) + " is greater than " +
					resPrint(setRub(valueForComp), setKop(valueForComp)) + "\n");
		}
		else if (rub == setRub(valueForComp) && (int) kop == (int) setKop(valueForComp)) {
			System.out.println(resPrint(rub, kop) + " is equal to " +
					resPrint(setRub(valueForComp), setKop(valueForComp)) + "\n");
		}
		else {
			System.out.println(resPrint(rub, kop) + " is less than " +
					resPrint(setRub(valueForComp), setKop(valueForComp)) + "\n");
		}
	}
	
	public double multiplication (double valueForMult) {
					
		String valueForMultString = String.valueOf(valueForMult);
		
		int numberOfDigAftDecP = valueForMultString.length() - valueForMultString.indexOf(".") - 1;
		System.out.println("Multiplication: " + resPrint(rub, kop) + " multiplied by " +
			valueForMultString.substring(0, valueForMultString.indexOf(".")) + "," + 
				valueForMultString.substring(valueForMultString.indexOf(".") + 1, valueForMultString.length()));
		
		long valMult1 = (rub * 100) + kop;
		long valMult2 = (long) (valueForMult * Math.pow(10, numberOfDigAftDecP));
		long multLong = valMult1 * valMult2;
				
		rub = (long) (multLong / Math.pow(10, numberOfDigAftDecP + 2));
		kop = (char) ((int) (multLong / Math.pow(10, numberOfDigAftDecP)) -
				(int) (multLong / Math.pow(10, numberOfDigAftDecP + 2)) * 100);
		
		int roundingDigit = (int) (multLong / Math.pow(10, numberOfDigAftDecP - 1)) -
				(int) (multLong / Math.pow(10, numberOfDigAftDecP)) * 10;
				
		if (roundingDigit >= 5) {
			if (kop == 99) {
				rub++;
				kop = 0;
			}
			else {
				kop++;
			}
		}
		
		double multResult = rub + ((int) kop * 0.01);
		System.out.println(resPrint(rub, kop) + "\n");
		return multResult;
	}
	

	public double division (double valueForDiv) {
		
		String valueForDivString = String.valueOf(valueForDiv);
		int numberOfDigAftDecP = valueForDivString.length() - valueForDivString.indexOf(".") - 1;
		System.out.println("Division: " + resPrint(rub, kop) + " divided by " +
			valueForDivString.substring(0, valueForDivString.indexOf(".")) + "," +
				valueForDivString.substring(valueForDivString.indexOf(".") + 1, valueForDivString.length()));
		
		long valDiv1 = (rub * 100) + kop;
		long valDiv2 = (long) (valueForDiv * Math.pow(10, numberOfDigAftDecP));
		double divDouble = (double) (valDiv1) / (double) valDiv2 * Math.pow(10, numberOfDigAftDecP + 1);
				
		rub = (long) (divDouble / Math.pow(10, 3));
		kop = (char) ((int) (divDouble / Math.pow(10, 1)) -
				(int) (divDouble / Math.pow(10, 3)) * Math.pow(10, 2));
		
		int roundingDigit = (int) (divDouble) -
				(int) (divDouble / Math.pow(10, 1)) * 10;
				
		if (roundingDigit >= 5) {
			if (kop == 99) {
				rub++;
				kop = 0;
			}
			else {
				kop++;
			}
		}
		
		double divResult = rub + ((int) kop * 0.01);
		System.out.println(resPrint(rub, kop) + "\n");
		return divResult;
	}
}
