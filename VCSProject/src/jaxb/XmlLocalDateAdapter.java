package jaxb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XmlLocalDateAdapter extends XmlAdapter<String, LocalDate> {

	public static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	@Override
	public LocalDate unmarshal(String value) throws Exception {
		return LocalDate.parse(value, PATTERN);
	}

	@Override
	public String marshal(LocalDate value) throws Exception {
		return value.format(PATTERN);
	}
}
