package festival.api.model.collection.user;

import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import java.util.Objects;

import static festival.api.constant.DbCollections.USER_COLLECTION;


@MongoEntity(collection = USER_COLLECTION)
public class User {

	private ObjectId id;
	private boolean admin;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public User() { }

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return admin == user.admin && Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, admin, firstName, lastName, email, password);
	}
}
