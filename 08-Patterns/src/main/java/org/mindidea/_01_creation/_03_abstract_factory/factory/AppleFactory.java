package org.mindidea._01_creation._03_abstract_factory.factory;

import org.mindidea._01_creation._03_abstract_factory.notebook.AbstractNotebook;
import org.mindidea._01_creation._03_abstract_factory.notebook.MacBook;
import org.mindidea._01_creation._03_abstract_factory.phone.AbstractPhone;
import org.mindidea._01_creation._03_abstract_factory.phone.Apple;

public class AppleFactory implements FutuFactory {
	@Override
	public AbstractPhone newPhone() {
		return new Apple("iPhone 14", "iOS-16", 4, 256);
	}

	@Override
	public AbstractNotebook newNotebook() {
		return new MacBook("MacBookProM1", "AppleM1Pro", "Monterey", "M1 Pro");
	}
}
