package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DemoApplication {

	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<>();

		for (int i = 0; i < 10; ++i) {
			users.add(User.createUser());
		}

		users.forEach(System.out::println);
		System.out.println();

		// Create a stream with 3 users
		Stream<User> userStream = users.stream().limit(3);
		userStream.forEach(System.out::println);
		System.out.println();

		// Filter users with age < 18
		System.out.println("Filter users with age < 18");
		users.stream().filter(user -> user.getAge() < 18).forEach(System.out::println);
		System.out.println();

		// Double users’ age
		System.out.println("Double users’ age");
		users.forEach(user -> user.setAge(user.getAge() * 2));
		users.forEach(System.out::println);
		System.out.println();

		// Print the last element of the stream
		System.out.println("Print the last element of the stream");
		System.out.println(users.stream().reduce((first, second) -> second).orElse(null));
		System.out.println();

		// Find the person with the smallest age and the one with the greatest age
		System.out.println("Find the person with the smallest age and the one with the greatest age");
		System.out.println(users.stream().min(Comparator.comparing(User::getAge)).orElseThrow(NoSuchElementException::new));
		System.out.println(users.stream().max(Comparator.comparing(User::getAge)).orElseThrow(NoSuchElementException::new));
		System.out.println();

		// Remove duplicates from the list
		System.out.println("Remove duplicates from the list");
		users.add(users.get(2));
		users.add(users.get(5));
		users = users.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
		users.forEach(System.out::println);
		System.out.println();

		// Filter users with age > 30, transform their names to uppercase and sort them descending by age
		System.out.println("Filter users with age > 30, transform their names to uppercase and sort them descending by age");
		users.stream().filter(user -> user.getAge() > 30)
				.map(user -> {
					user.setName(user.getName().toUpperCase(Locale.ROOT));
					return user;
					})
				.sorted(Comparator.comparing(User::getAge).reversed())
				.forEach(System.out::println);
		System.out.println();
	}

}
