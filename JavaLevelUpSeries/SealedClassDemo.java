package JavaLevelUpSeries;

// Sealed base class
sealed interface Payment permits UPI, CreditCard, NetBanking {
	void processPayment(double amount);
}

final class UPI implements Payment {
	@Override
	public void processPayment(double amount) {
		System.out.println("Processing ₹" + amount + " via UPI");
	}
}

final class CreditCard implements Payment {
	@Override
	public void processPayment(double amount) {
		System.out.println("Processing ₹" + amount + " via Credit Card");
	}
}

final class NetBanking implements Payment {
	@Override
	public void processPayment(double amount) {
		System.out.println("Processing ₹" + amount + " via Net Banking");
	}
}

class SealedClassDemo {
	public static void main(String[] args) {
		Payment payment1 = new UPI();
		Payment payment2 = new CreditCard();
		Payment payment3 = new NetBanking();
		payment1.processPayment(1500);
		payment2.processPayment(3200);
		payment3.processPayment(980);
	}
}
