package com.neosoft.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.neosoft.ContactManager;

public class ContactManagerTest1 {

private ContactManager contactManager;
	
	@BeforeAll
	public static void setupAll() {
		System.out.println("Should print before all tests...");
	}
	
	@BeforeEach
	public void setup() {
		System.out.println("Instantiating Contact Manager");
		contactManager = new ContactManager();
	}
	@Test
	@DisplayName("Should Create Contact")
	public void shouldCreateContact() {
		contactManager.addContact("John", "Cena", "9898989898");
		assertFalse(contactManager.getAllContacts().isEmpty());
		assertEquals(1,contactManager.getAllContacts().size());
		System.out.println("Contact added");
	}
	
	
	@Test
	@DisplayName("Should not create a Contact if first name is null")
	public void shouldThrowRuntimeExceptionIfFirstNameNull() {
		assertThrows(RuntimeException.class,() -> {
			contactManager.addContact(null, "Xyz", "9999999999");
		});
	}
	
	@Test
	@DisplayName("Should not create a Contact if last name is null")
	public void shouldThrowRuntimeExceptionIfLastNameNull() {
		assertThrows(RuntimeException.class,() -> {
			contactManager.addContact("xyz", null, "9999999999");
		});
	}
	@Test
	@DisplayName("Should not create a Contact if contact number is null")
	public void shouldThrowRuntimeExceptionIfContactNoNull() {
		assertThrows(RuntimeException.class,() -> {
			contactManager.addContact("Abc", "vasu", null);
		});
	}
	@Test
	@DisplayName("Should not create a Contact if phone is not 13 digit")
	public void shouldThrowRuntimeExceptionIfPhoneNoGreater13Digit() {
		assertThrows(RuntimeException.class,() -> {
			contactManager.addContact("Abc", "Xyz", "9999999999999");
		});
	}
	@Test
	@DisplayName("Should list greater than5")
	public void shouldThrowRuntimeExceptionIfContactListSizeGreaterthan5() {
		assertThrows(RuntimeException.class,() -> {
			assertEquals(contactManager.getAllContacts().size(), 6);
			
		});
	}
	
	
	@Test
	@DisplayName("Contact exists!!")
	public void shouldThrowRuntimeExceptionIfCotactexist() {
		assertThrows(RuntimeException.class,() -> {
			if(contactManager.getAllContacts().contains("John-Cena"));
		});
	}
	
}
