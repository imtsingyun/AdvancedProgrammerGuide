package org.mindidea._01_creation._03_abstract_factory.factory;

import org.mindidea._01_creation._03_abstract_factory.notebook.AbstractNotebook;
import org.mindidea._01_creation._03_abstract_factory.notebook.MacBook;
import org.mindidea._01_creation._03_abstract_factory.phone.AbstractPhone;
import org.mindidea._01_creation._03_abstract_factory.phone.Samsung;

public class SamsungFactory implements FutuFactory {
	@Override
	public AbstractPhone newPhone() {
		return new Samsung("Samsung 盖世 20", "Android 12.01", 8, 256);
	}

	@Override
	public AbstractNotebook newNotebook() {
		return new MacBook("盖世 10", "intel 12", "Windows 12", "英伟达");
	}
}
