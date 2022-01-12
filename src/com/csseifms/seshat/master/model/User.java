package com.csseifms.seshat.master.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Random;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class User {
	@Column
	String name;
	@Column
	String address;

	@Column
	@Enumerated(EnumType.STRING)

	City city;

	@Column
	Integer age;

	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)

	UserType userType;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_interests", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tag"))

	List<Interest> interests;

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	public User(String name, int age, City city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	private User(Builder builder) {
		this.name = builder.name;
		this.id = builder.id;
		this.age = builder.age;
		this.city = builder.city;
		this.userType = builder.userType;
		this.address = builder.address;
		this.interests = builder.interests;
	}

	public static class Builder {
		String name, address;
		City city;
		int age;
		UserType userType;
		List<Interest> interests;
		long id;

		public Builder(String name) {
			this.id = new Random().nextLong();
			this.name = name;
		}

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder city(City city) {
			this.city = city;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder interests(List<Interest> interests) {
			this.interests = interests;
			return this;
		}

		public Builder userType(UserType userType) {
			this.userType = userType;
			return this;
		}

		public User build() {
			User user = new User(this);
			// user.userType = UserType.BUILDER.name();
			return user;
		}
	}

	public User() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public List<Interest> getInterests() {
		return interests;
	}

	public void setInterests(List<Interest> interests) {
		this.interests = interests;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
