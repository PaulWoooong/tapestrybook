package de.t5book.pages;

import java.util.Random;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.ajax.MultiZoneUpdate;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class MultipleZones {
	@Inject
	private Block counterBlock;

	@Inject
	private Block randomBlock;

	@Property
	@Persist
	private int number;

	@Property
	@Persist
	private int random;

	Object onAction() {
		random = new Random().nextInt();

		number += random;

		return new MultiZoneUpdate("counterZone", counterBlock).add(
				"randomZone", randomBlock);
	}
}
